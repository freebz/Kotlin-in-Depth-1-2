// 3.1.5 함수의 영역과 가시성

fun main() {
  fun readInt() = readLine()!!.toInt()
  println(readInt() + readInt())
}

fun readIntPair() = intArrayOf(readInt(), readInt()) // error: unresolved reference: readInt


fun main(args: Array<String>) {

  fun swap(i: Int, j: Int): String {
    val chars = args[0].toCharArray()
    val tmp = chars[i]
    chars[i] = chars[j]
    chars[j] = tmp
    return chars.concatToString()
  }

  println(swap(0, args[0].lastIndex))
}