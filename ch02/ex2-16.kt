// 2.4.1 배열 정의하기

val a = emptyArray<String>()            // Array<String> (원소 0개)
val b = arrayOf("hello", "world")       // Array<String> (원소 두 개)
val c = arrayOf(1, 4, 9)                // Array<Int> (원소 세 개)


val size = readLine()!!.toInt()
val squares = Array(size) { (it + 1)*(it + 1) }


val operations = charArrayOf('+', '-', '*', '/', '%')
val squares = IntArray(10) { (it + 1)*(it + 1) }