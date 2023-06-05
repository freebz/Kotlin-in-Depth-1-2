// 4.2.3 널 아님 단언 연산자

val n = readLine()!!.toInt()


fun main() {
  var name: String? = null

  fun initialize() {
    name = "John"
  }

  fun sayHello() {
    println(name!!.uppercase())
  }

  initialize()
  sayHello()
}