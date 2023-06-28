// 10.2.2 지정자와 타입

println(String::class.isFinal) // true


inline fun <reified T> Any.cast() = this as? T


val obj: Any = "Hello"
println(obj.cast<String>())


val obj: Any = "Hello"
println(obj as? String)


println((1 + 2)::class)  // class kotlin.Int
println("abc"::class)    // class kotlin.String


val stringClass = Class.forName("java.lang.String").kotlin
println(stringClass.isInstance("Hello")) // true


println(String::class.java) // class java.lang.String


val isAbstract: Boolean
val isCompanion: Boolean
val isData: Boolean
val isFinal: Boolean
val isInner: Boolean
val isOpen: Boolean
val isSealed: Boolean


enum class Kvisibility {
  PUBLIC,
  PROTECTED,
  INTERNAL,
  PRIVATE
}


val simpleName: String?
val qualifiedName: String?


println(Any::class.qualifiedName)   // kotlin.Any
println(Any::class.jvmName)         // java.lang.Object


println(String::class.isInstance(""))   // true
println(String::class.isInstance(12))   // false
println(String::class.isInstance(null)) // false


class Person(val firstName: String, val familyName: String) {
  fun fullName(familyFirst: Boolean): String = if (familyFirst) {
      "$familyName $firstName"
    } else {
      "$firstName $familyName"
    }
}

fun main() {
  val personClass = Class.forName("Person").kotlin
  val person = personClass.constructors.first().call("John", "Doe")
  val fullNameFun = personClass.members.first { it.name == "fullName" }

  println(fullNameFun.call(person, false)) // John Doe
}


object O {
  val text = "Singleton"
}

fun main() {
  println(O::class.objectInstance!!.text) // Singleton
}


open class GrandParent
open class Parent :GrandParent()
interface IParent
class Child : Parent(), IParent

fun main() {
  println(Child::class.supertypes) // [Parent, IParent]
}


// KTypeParameter의 프로퍼티
val isReified: Boolean
val name: String
val upperBounds: List<KType>
val variance: KVariance


interface MyMap<K : Any, out V>

fun main() {
  val parameters = MyMap::class.typeParameters
  // K: [kotlin.Any], V: [kotlin.Any?]
  println(parameters.joinToString { "${it.name}: ${it.upperBounds}" })
}


enum class KVariance{ INVARIANT, IN, OUT }


val type: kotlin.reflect.KType?
val variance: kotlin.reflect.KVariance?