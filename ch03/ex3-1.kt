// 3.1.1 코틀린 함수의 구조

import kotlin.math.PI

fun circleArea(radius: Double): Double {
  return PI*radius*radius
}

fun main() {
  print("Enter radius: ")
  val radius = readLine()!!.toDouble()
  println("Circle area: ${circleArea(radius)}")
}


fun readInt(): Int {
  return readLine()!!.toInt()
}

fun main() {
  println(readInt())
}


fun increment(n: Int): Int {
  return n++ // Error: can't change immutable variable
}


fun increment(a: IntArray): Int {
  return ++a[0]
}

fun main() {
  val a = intArrayOf(1, 2, 3)
  println(increment(a)) // 2
  println(a.contentToString()) // [2, 2, 3]
}


fun prompt(name: String) {
  println("***** Hello, $name! *****")
}

fun prompt(name: String): Unit {
  println("***** Hello, $name! *****")
}


fun circleArea(radius: Double): Double = PI*radius*radius


fun circleArea(radius: Double) = PI*radius*radius // 반환값이 Double로 추론됨


fun circleArea(radius: Double) = { PI*radius*radius }


fun circleArea(radius: Double) = {
  return PI*radius*radius      // error: 'return' is not allowed here
                               // error: type mismatch: inferred type is () -> [ERROR : Return not allowed] but Double was expected
}