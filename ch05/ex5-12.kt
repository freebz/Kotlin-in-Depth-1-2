// 5.5 수신 객체가 있는 호출 가능 참조

fun aggregate(numbers: IntArray, op: Int.(Int) -> Int): Int {
  var result = numbers.firstOrNull()
      ?: throw IllegalArgumentException("Empty array")

  for (i in 1..numbers.lastIndex) result = result.op(numbers[i])

  return result
}

fun Int.max(other: Int) = if (this > other) this else other

fun main() {
  val numbers = intArrayOf(1, 2, 3, 4)
  println(aggregate(numbers, Int::plus)) // 10
  println(aggregate(numbers, Int::max)) // 4
}


fun aggregate(numbers: IntArray, op: Int.(Int) -> Int): Int {
  var result = numbers.firstOrNull()
      ?: throw IllegalArgumentException("Empty array")

  for (i in 1..numbers.lastIndex) result = result.op(numbers[i])

  return result
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun main() {
  println(aggregate(intArrayOf(1, 2, 3, 4), ::max))
}


fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
  var result = numbers.firstOrNull()
      ?: throw IllegalArgumentException("Empty array")

  for (i in 1..numbers.lastIndex) result = op(result, numbers[i])

  return result
}

fun Int.max(other: Int) = if (this > other) this else other

fun main() {
  println(aggregate(intArrayOf(1, 2, 3, 4), Int::plus))  // 10
  println(aggregate(intArrayOf(1, 2, 3, 4), Int::max))  // 4
}