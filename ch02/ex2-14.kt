// 2.3.1 문자열 템플릿

val hello = "Hello, world!"


val text = "Hello, world!\nThis is \"multiline\" string"
println("\u03C0 \u2248 3.14") // π ≈ 3.14


import java.util.Date
fun main() {
  val name = readLine()
  println("Hello, $name!\n Today is ${Date()}")
}


// Hello, John!
// Today is Sat Sep 04 08:47:21 KST 2021


val message = """
  Hello, $name!
  Today is ${Date()}
""".trimIndent()


val message = """
This is triple quote: '${"\"\"\""}'
""".trimIndent()