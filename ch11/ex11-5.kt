// 11.1.4 중위 연산

val pair1 = 1 to 2   // 중위 호출
val pair2 = 1.to(2)  // 일반적인 호출


infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)


infix fun <T> ((T) -> Boolean).and(
  other: (T) -> Boolean
): (T) -> Boolean {
  return { this(it) && other(it) }
}

infix fun <T> ((T) -> Boolean).or(
  other: (T) -> Boolean
): (T) -> Boolean {
  return { this(it) || other(it) }
}


// 11장 앞부분에서 정의한 ! 연산자 확장 함수의 String.isUpperCase 확장 함수
operator fun <T> ((T) -> Boolean).not(): (T) -> Boolean = { !this(it) }
fun String.isUpperCase() = all { it.isUpperCase() }

fun main() {
  val data = listOf("abc", "abcde", "ABCDE", "aBcD", "ab")

  println(data.count(::isShort and String::isUpperCase))     // 0
  println(data.count(::isShort or String::isUpperCase))      // 4
  println(data.count(!::isShort or String::isUpperCase))     // 2
  println(data.count(!(::isShort and String::isUpperCase)))  // 5
}


!::isShort or String::isEmpty and String::isUpperCase


(!::isShort or String::isEmpty) and String::isUpperCase


!s.isShort() || s.isEmpty() &&s.isUpperCase()


!s.isShort() || (s.isEmpty() &&s.isUpperCase())