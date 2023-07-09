// 11.2.2 커스텀 위임 만들기

import kotlin.reflect.KProperty

class CachedProperty<in R, out T : Any>(val initializer: R.() -> T) {
  private val cachedValues = HashMap<R, T>()

  operator fun getValue(receiver: R, property: KProperty<*>): T {
    return cachedValues.getOrPut(receiver) { receiver.initializer() }
  }
}

fun <R, T : Any> cached(initializer: R.() -> T) = CachedProperty(initializer)

class Person(val firstName: String, val familyName: String)

val Person.fullName: String by cached { "$firstName $familyName" }

fun main() {
  val johnDoe = Person("John", "Doe")
  val harrySmith = Person("Harry", "Smith")

  // johnDoe에 저장된 수신 객체에 최초 접근, 값을 계산해 캐시에 담음
  println(johnDoe.fullName)  // John Doe

  // harrySmith에 저장된 수신 객체에 최초 접근. 값을 계산해 캐시에 담음
  println(harrySmith.fullName) // Harry Smith

  // johnDoe에 저장된 수신 객체에 재접근. 캐시에서 값을 읽음
  println(johnDoe.fullName)  // John Doe

  // harrySmith에 저장된 수신 객체에 재접근. 캐시에서 값을 읽음
  println(harrySmith.fullName) // Harry Smith
}


interface ReadOnlyProperty<in R, out T> {
  operator fun getValues(thisRef: R, property: KProperty<*>): T
}


import kotlin.reflect.KProperty

class FinalLateinitProperty<in R, T : Any> {
  private lateinit var value: T
  operator fun getValue(receiver: R, property: KProperty<*>): T {
    return value
  }
  operator fun setValue(receiver: R,
                        property: KProperty<*>,
                        newValue: T) {
    if (this::value.isInitialized) throw IllegalStateException(
          "Property ${property.name} is already initialized"
        )
      value = newValue
  }
}

fun <R, T : Any> finalLateInit() = FinalLateinitProperty<R, T>()

var message: String by finalLateInit()

fun main() {
  message = "Hello"
  println(message) // Hello
  message = "Bye"  // Exception: Property message is already initialized
}


public interface ReadWriteProeprty<in R, T> {
  operator fun getValue(thisRef: R, property: KProperty<*>): T
  operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}


inline operator fun <V, V1 : V> Map<in String, V>.getValue(
  thisRef: Any?,
  property: KProperty<*>
): V1 {...}


@Target(AnnotationTarget.PROPERTY)
annotation class NoCache

class CachePropertyProvider<in R, out T : Any>(
  val initializer: R.() -> T
) {
  operator fun provideDelegate(
    receiver: R?,
    property: KProperty<*>
  ): CachedProperty<R, T> {
    if (property.annotations.any{ it is NoCache }) {
      throw IllegalStateException("${property.name} forbids caching")
    }
    return CachedProperty(initializer)
  }
}

fun <R, T : Any> cached(initializer: R.() -> T) =
  CachedPropertyProvider(initializer)


class Person(val firstName: String, val familyName: String)

@NoCache val Person.fullName: String by cached {
  if (this != null) "$firstName $familyName" else ""
}

fun main() {
  val johnDoe = Person("John", "Doe")
  println(johnDoe.fullName) // Exception: java.lang.ExceptionInitializerError
}