// 5.4.1 람다와 수신 객체 지정 함수 타입

fun aggregate(numbers: IntArray, op: Int.(Int) -> Int): Int {
  var result = numbers.firstOrNull()
      ?: throw IllegalArgumentException("Empty array")

  for (i in 1..numbers.lastIndex) result = result.op(numbers[i])

  return result
}

fun sum(numbers: IntArray) = aggregate(numbers) { op -> this + op }


fun sum(numbers: IntArray) = aggregate(numbers, fun Int.(op: Int) = this + op)


fun aggregate(numbers: IntArray, op: Int.(Int) -> Int): Int {
  var result = numbers.firstOrNull()
      ?: throw IllegalArgumentException("Empty array")
  
  for (i in 1..numbers.lastIndex) {
    result = op(result, numbers[i]) // 비확장 함수 호출
  }

  return result
}


val min1: Int.(Int) -> Int = { if (this < it) this else it }
val min2: (Int, Int) -> Int = min1  // 수신 객체가 첫 번째 파라미터인 일반 함수
val min3: Int.(Int) -> Int = min2   // 수신 객체가 있는 함수 타입


fun main() {
  val min1: Int.(Int) -> Int = { if (this < it) this else it }
  val min2: (Int, Int) -> Int = min1
  println(3.min1(2))  // Ok: min1을 확장 함수로 호출함
  println(min1(1, 2)) // Ok: min1을 비확장 함수로 호출함
  println(3.min2(2))  // error: unresolved reference: min2
  println(min2(1, 2)) // Ok: min2를 비확장 함수로 호출함
}