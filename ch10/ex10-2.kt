// 10.1.2 내장 애너테이션

// error: expression annotations with retention other than SOURCE are prohibited
@Target(AnnotationTarget.EXPRESSION)
annotation class NeedToRefactor


@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class NeedToRefactor // Ok


@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation class Author(val name: String)

@Author("John")
@Author("Harry")
class Services


@Deprecated("Deprecated")
@Deprecated("Even more deprecated") // error: this annotation is not repeatable
class OldClass


val strings = listOf<Any>("1", "2", "3")
val numbers = listOf<Any>(1, 2, 3)

// 경고 표시되지 않음
val s = @Suppress("UNCHECKED_CAST") (strings as List<String>)[0]

// warning: unchecked cast: List<Any> to List<Number>
val n = (numbers as List<Number>)[1]


@Suppress("UNCHECKED_CAST")
fun main() {
  val strings = listOf<Any>("1", "2", "3")
  val numbers = listOf<Any>(1, 2, 3)
  val s = (strings as List<String>)[0]    // 경고 표시되지 않음
  val n = (numbers as List<Number>)[1]    // 경고 표시되지 않음

  println(s + n) // 12
}


@file:Suppress("UNCHECKED_CAST")
val strings = listOf<Any>("1", "2", "3")
val numbers = listOf<Any>(1, 2, 3)

fun takeString() = (strings as List<String>)[0]   // 경고 표시되지 않음
fun takeNumber() = (numbers as List<Number>)[1]   // 경고 표시되지 않음

@Suppress("UNCHECKED_CAST")
fun main() {
  println(takeString() + takeNumber()) // 12
}


@Deprecated(
  "Use readInt() instead", // 메시지
  ReplaceWith("readInt()") // 대안
)

fun readNum() = readLine()!!.toInt()


@Target()
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
public annotation class ReplaceWith(
  val expression: String,
  vararg val imports: String
)