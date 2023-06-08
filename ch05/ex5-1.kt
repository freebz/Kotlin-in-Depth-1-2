// 5.1.1 고차 함수

val squares = IntArray(5) { n -> n*n } // 0, 1, 4, 9, 16


fun sum(numbers: IntArray): Int {
  var result = numbers.firstOrNull()
    ?: throw IllegalArgumentException("Empty array")

  for (i in 1..numbers.lastIndex) result += numbers[i]

  return result
}

fun main() {
  println(sum(intArrayOf(1, 2, 3))) // 6
}


fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
  var result = numbers.firstOrNull()
    ?: throw IllegalArgumentException("Empty array")
  
    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])

    return result
}

fun sum(numbers: IntArray) =
  aggregate(numbers, { result, op -> result + op })

fun max(numbers: IntArray) =
  aggregate(numbers, { result, op -> if (op > result) op else result })

fun main() {
  println(sum(intArrayOf(1, 2, 3))) // 6
  println(max(intArrayOf(1, 2, 3))) // 3
}