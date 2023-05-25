// 3.1.4 vararg

fun printSorted(vararg items: Int) {
  items.sort()
  println(items.contentToString())
}

fun main() {
  printSorted(6, 2, 10, 1) // [1, 2, 6, 10]
}


val numbers = intArrayOf(6, 2, 10, 1)
printSorted(*numbers)
printSorted(numbers) // Error: passing IntArray instead of Int


fun main() {
  val a = intArrayOf(6, 2, 10, 1)
  printSorted(*a)              // [1, 2, 6, 10]
  println(a.contentToString()) // [6, 2, 10, 1] 
}


fun change(vararg items: IntArray) {
  items[0][0] = 100
}

fun main() {
  val a = intArrayOf(1, 2, 3)
  val b = intArrayOf(4, 5, 6)
  change(a, b)
  println(a.contentToString()) // [100, 2, 3]
  println(b.contentToString()) // [4, 5, 6]
}


printSorted(6, 1, *intArrayOf(3, 8), 2) // 6, 1, 3, 8, 2 순서로 원소가 들어있는 배열이 전달되고, [1, 2, 3, 6, 8]이 반환됨


printSorted(items = *intArrayOf(1, 2, 3))
printSorted(items = 1, 2, 3) // Error: assigning single elements to varargs in named from is forbidden
                             // Error: the integer literal does not conform to the expected type IntArray


fun printSorted(prefix: String = "", vararg items: Int) { }

fun main() {
  printSorted(6, 2, 10, 1) // Error: 6 is taken as value of prefix
  printSorted(items = *intArrayOf(6, 2, 10, 1)) // 정상
}


fun printSorted(vararg items: Int, prefix: String = "") { }

fun main() {
  printSorted(6, 2, 10, 1, "!")           // Error: type mismatch: inferred type is
                                          // String but Int was expected
  printSorted(6, 2, 10, 1, prefix = "!")  // 정상
}


fun printSorted(vararg items: Int) { } // 1

fun printSorted(a: Int, b: Int, c: Int) { } // 2

fun main() {
  printSorted(1, 2, 3) // 2번 함수가 가변 인자 함수가 아니므로 2를 선택
  printSorted(1, 2)    // 적용할 수 있는 함수가 1번밖에 없으므로 1을 선택
}