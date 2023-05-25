// 3.4.4 내포된 루프와 레이블

fun indexOf(subarray: IntArray, array: IntArray): Int {
  outerLoop@ for (i in array.indices) {
    for (j in subarray.indices) {
      if (subarray[j] != array[i + j]) continue@outerLoop
    }
    return i
  }
  return -1
}


loop@ while(true) break@loop // 코틀린
loop: while(true) break loop // 자바


import kotlin.random.*

fun main() {
  val num = Random.nextInt(1, 101)

  loop@ while (true) {
    val guess = readLine()!!.toInt()

    val message = when {
      guess < num -> "Too small"
      guess > num -> "Too big"
      else ->break@loop // 정상
    }
    println(message)
  }
  println("Right: it's $num")
}