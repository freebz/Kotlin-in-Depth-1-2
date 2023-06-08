// 5.3 확장 프로퍼티

val IntRange.leftHalf: IntRange
  get() = start..(start + endInclusive)/2

fun main() {
  println((1..3).leftHalf) // 1..2
  println((3..6).leftHalf) // 3..4
}


val IntArray.midIndex
  get() = lastIndex/2

var IntArray.midValue
  get() = this[midIndex]
  set(value) {
    this[midIndex] = value
  }

fun main() {
  val numbers = IntArray(6) { it*it } // 0, 1, 4, 9, 16, 25

  println(numbers.midValue) // 4
  numbers.midValue *= 10
  println(numbers.midValue) // 40
}


val String.message by lazy { "Hello" }

fun main() {
  println("Hello".message)  // Hello
  println("Bye".message)   // Hello
}


object Messages

val Messages.HELLO by lazy { "Hello" }

fun main() {
  println(Messages.HELLO)
}