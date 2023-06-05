// 4.2.4 안전한 호출 연산자

fun readInt() = readLine()!!.toInt()


fun readInt() = readLine()?.toInt()


fun readInt(): Int? {
  val tmp = readLine()

  return if (tmp != null) tmp.toInt() else null
}


println(readLine()?.toInt()?.toString(16))


fun readInt() = readLine()?.toInt()

fun main() {
  val n = readInt() // Int?

  if (n != null) {
    println(n + 1)
  } else {
    println("No value")
  }
}