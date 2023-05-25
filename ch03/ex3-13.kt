// 3.4.3 루프 제어 흐름 변경하기: break와 continue

import kotlin.random.*

fun main() {
  val num = Random.nextInt(1, 101)

  while (true) {
    val guess = readLine()!!.toInt()

    if (guess < num) println("Too small")
    else if (guess > num) println("Too big")
    else break
  }

  println("Right: it's $num")
}


import kotlin.random.*

fun main() {
  val num = Random.nextInt(1, 101)

  while (true) {
    val guess = readLine()!!.toInt()
    val message =
      if (guess < num) "Too small"
      else if (guess > num) "Too big"
      else break
    println(message)
  }

  println("Right: it's $num")
}


fun countLetters(text: String): IntArray {
  val counts = IntArray('z' - 'a' + 1)

  for (char in text) {
    val charLower = char.toLowerCase()
    if (charLower !in 'a'..'z') continue
    counts[charLower - 'a']++
  }

  return counts
}


val message = when {
  guess < num -> "Too small"
  guess > num -> "Too big"
  else -> break // 1.4 이전에는 오류, 1.4부터는 정상
}