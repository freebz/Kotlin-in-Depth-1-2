// 10.2.3 호출 가능

fun combine(n: Int, s: String) = "$s$n"

fun main() {
  println(::combine.returnType) // kotlin.String
}


val isAbstract: Boolean
val isFinal: Boolean
val isOpen: Boolean
val isSuspend: Boolean
val visibility: KVisibility?


val name: String
val typeParameters: List<KTypeParameter>
val parameters: List<KParameter>
val returnType: KType


import kotlin.reflect.KCallable

val simpleVal = 1
val Int.extVal get() = this

class A {
  val Int.memberExtVal get() = this
}

fun main() {
  fun printParams(callable: KCallable<*>) {
    println(
      callable.parameters.joinToString(prefix = "[", postfix = "]") {
        it.type.toString()
      }
    )
  }

  // []
  printParams(::simpleVal)

  // [kotlin.Int]
  printParams(Int::extVal)

  // [A, kotlin.Int]
  printParams(A::class.members.first { it.name == "memberExtVal" })
}


val index: Int
val isOptional: Boolean
val isVararg: Boolean
val name: String?
val type: KType
val kind: KParameter


fun call(vararg args: Any?): R


fun main() {
  val person = Person("John", "Doe")
  val personClass = person::class
  val firstName = personClass.members.first { it.name == "firstName" }

  println(firstName.call(person)) // John
}


fun callBy(args: Map<KParameter, Any>): R


val isConst: Boolean
val isLateinit: Boolean


val myValue = 1

fun main() {
  println(::myValue.getter()) // 1
}


var myValue = 1

fun main() {
  ::myValue.setter(2)
  println(myValue) // 2
}


val isInfix: Boolean
val isInline: Boolean
val isOperator: Boolean
val isSuspend: Boolean


import kotlin.reflect.KFunction2

fun combine(n: Int, s: String) = "$s$n"

fun main() {
  val f: KFunction2<Int, String, String> = ::combine
  println(f(1, "2")) // 21
}


import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.isAccessible

class SecretHolder(private val secret: String)

fun main() {
  val secretHolder = SecretHolder("Secret")
  val secretProperty = secretHolder::class.members
    .first { it.name == "secret" } as KProperty1<SecretHolder, String>

  secretProperty.isAccessible = true
  println(secretProperty.get(secretHolder))
}