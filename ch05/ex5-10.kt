// 5.4 동반 확장

fun IntRange.Companion.singletonRange(n: Int) = n..n

fun main() {
  println(IntRange.singletonRange(5))           // 5..5
  println(IntRange.Companion.singletonRange(3)) // 3..3
}


val String.Companion.HELLO
  get() = "Hello"

fun main() {
  println(String.HELLO)
  println(String.Companion.HELLO)
}


class Person(val firstName: String, val familyName: String) {
  companion object // 확장 정의를 위해 내용이 없는 동반 객체를 정의함
}

val Person.Companion.UNKNOWN by lazy { Person("John", "Doe") }


// error: unresolved reference: Companion
fun Any.Companion.sayHello() = println("Hello")