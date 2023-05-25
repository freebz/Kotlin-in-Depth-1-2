// 3.3.2 범위, 진행, 연산

val chars = 'a'..'h'      // 'a'부터 'h'까지의 모든 문자
val twoDigits = 10..99    // 10부터 99까지의 모든 수
val zero2One = 0.0..1.0   // 0부터 1까지의 모든 부동소수점 수


val num = readLine()!!.toInt()
println(num in 10..99) // num >= 10 && num <= 99


println(num !in 10..99) // !(num in 10..99)


println("def" in "abc".."xyz") // true
println("zzz" in "abc".."xyz") // false


val twoDigits = 10 until 100 // 10..99와 같음. 100은 포함되지 않음


println(5 in 5..5)      // true
println(5 in 5 until 5) // false
println(5 in 10..1)     // false


println(5 in 10 downTo 1) // true
println(5 in 1 downTo 10) // false: 빈 진행임


1..10 step 3          // 1, 4, 7, 10
15 downTo 9 step 2    // 15, 13, 11 9


1..12 step 3          // 1, 4, 7, 10: 1..10 step 3과 같음
15 downTo 8 step 2    // 15, 13, 11, 9: 15 downTo 9 step 2와 같음


"Hello, World".substring(1..4)                  // ello
"Hello, World".substring(1 until 4)             // ell
"Hello, World".substring(1, 4)                  // ell: substring(1 until 4) 와 같음
IntArray(10) { it*it }.sliceArray(2..5)         // 4, 9, 16, 25
IntArray(10) { it*it }.sliceArray(2 until 5)    // 4, 9, 16


fun main() {
  val a = readLine()!!.toInt()
  val b = readLine()!!.toInt()
  println(5 in a..b)
}


val numbers = intArrayOf(3, 7, 2, 1)
val text = "Hello!"
println(2 in numbers)  // true
println(9 !in numbers) // true
println(4 in numbers)  // false
println('a' in text)   // false
println('H' in text)   // true
println('h' !in text)  // true