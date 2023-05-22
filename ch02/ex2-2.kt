// 2.1.2 변수 정의하기

val timeInSeconds = 15


fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    println(a + b)
}


var text = "Hello"; // 자동으로 text의 타입을 String으로 추론한다


val n: Int = 100
val text: String = "Hello!"


val n: Int = "Hello!" // Error: assigning String value to Int variable


val text: String
text = "Hello!"


val n: Int
println(n + 1) // Error: variable n is not initialized