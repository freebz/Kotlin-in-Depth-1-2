// 11.2.3 위임 표현

class Person(val firstName: String, val familyName: String) {
  var age: Int by finalLateInit()
}


class Person(val firstName: String, val familyName: String) {
  private val `age$delegate` = finalLateInit<Person, Int>()

  var age: Int
    get() = `age$delegate`.getValue(this, this::age)
    set(value) {
      `age$delegate`.setValue(this, this::age, value)
    }
}


import kotlin.reflect.jvm.isAccessible

class Person(val firstName: String, val familyName: String) {
  val fullName by lazy { "$firstName $familyName" }
}

fun main() {
  val person = Person("John", "Doe")

  // KProperty0: 모든 수신 객체가 엮여 있음
  println(
    person::fullName
      .apply { isAccessible = true }
      .getDelegate()!!::class.qualifiedName
  ) // kotlin.SynchronizedLazyImpl

  // KProperty1: 수신 객체가 엮여 있지 않아서 수신 객체를 따로 지정해야 함
  println(
    Person::fullName
      .apply { isAccessible = true }
      .getDelegate(person)!!::class.qualifiedName
  ) // kotlin.SynchronizedLazyImpl
}


import kotlin.reflect.full.getExtensionDelegate

class Person(val firstName: String, val familyName: String)
val Person.fullName: String by cached { "$firstName $familyName" }

// 조금 전에 정의했던 NoCache(애너테이션) 클래스, CachedPropertyProvider 클래스,
// CachedProperty 클래스, cached 함수가 여기에 들어가야 함

fun main() {
  println(
    Person::fullName
      .apply { isAccessible = true }
      .getExtensionDelegate()!!::class.qualifiedName
  ) // CachedProperty
}