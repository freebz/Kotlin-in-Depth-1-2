// 5.1.3 람다와 익명 함수

fun sum(numbers: IntArray) =
  aggregate(numbers, { result op -> result + op })
fun max(numbers: IntArray) =
  aggregate(numbers, { result, op -> if (op > result) op else result })

fun main() {
  println(sum(intArrayOf(1, 2, 3))) // 6
  println(max(intArrayOf(1, 2, 3))) // 3
}


fun sum(numbers: IntArray) =
  aggregate(numbers) { result, op -> result + op }

fun max(numbers: IntArray) =
  aggregate(numbers) { result, op -> if (op > result) op else result }


fun measureTime(action: () -> Unit): Long {
  val start = System.nanoTime()
  action()
  return System.nanoTime() - start
}

val time = measureTime{ 1 + 2 }


fun check(s: String, condition: (Char) -> Boolean): Boolean {
  for (c in s) {
    if (!condition(c)) return false
  }
  return true
}

fun main() {
  println(check("Hello") { c ->c.isLetter() }) // true
  println(check("Hello") { it.isLowerCase() }) // false
}


fun check(s: String, condition: (Int, Char) -> Boolean): Boolean {
  for (i in s.indices) {
    if (!condition(i, s[i])) return false
  }
  return true
}

fun main() {
  println(check("Hello") { _, c ->c.isLetter() })               // true
  println(check("Hello") { i, c ->i == 0 || c.isLowerCase() })  // true
}


fun sum(numbers: IntArray) =
  aggregate(numbers, fun(result, op) = result + op)


fun sum(numbers: IntArray) =
  aggregate(numbers, fun(result, op): Int { return result + op })


fun forEach(a: IntArray, action: (Int) -> Unit) {
  for (n in a) {
    action(n)
  }
}

fun main() {
  var sum = 0
  forEach(intArrayOf(1, 2, 3, 4)) {
    sum += it
  }
  println(sum) // 10
}