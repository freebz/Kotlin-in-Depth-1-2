// 11.1.7 구조 분해

operator fun RationalRange.component1() = from
operator fun RationalRange.component2() = to


// 11장 앞부분에서 정의한 Rational, RationalRange 클래스와 r 함수 정의 필요
fun main() {
  val (from, to) = r(1, 3)..r(1, 2)

  println(from) // 1/3
  println(to)   // 1/2
}


val map = mapOf("I" to 1, "V" to 5, "X" to 10)
for ((key, value) in map) {
  println("$key = $value")
}


val numbers = listOf(10, 20, 30, 40, 50)
val (a, b, c) = numbers
println("$a, $b, $c") // 10, 20, 30