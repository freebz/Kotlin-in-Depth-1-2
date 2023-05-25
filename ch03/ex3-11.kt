// 3.4.1 while과 do-while 루프

fun main() {
  var sum = 0
  var num

  do {
    num = readLine()!!.toInt()
    sum += num
  } while (num != 0)

  println("Sum: $sum")
}


import kotlin.random.*

fun main() {
  val num = Random.nextInt(1, 101)
  var guess = 0

  while (guess != num) {
    guess = readLine()!!.toInt()
    if (guess < num) println("Too small")
    else if (guess > num) println("Too big")
  }
  println("Right: it's $num")
}