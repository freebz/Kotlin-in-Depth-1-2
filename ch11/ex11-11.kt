// 11.2.1 표준 위임들

val text by lazy { File("data.txt").readText() }


private val lock = Any()
val text by lazy { File("data.txt").readText() }


val myValue by lazy {
  println("Initializing myValue")
  123
}


val myValue by lazy(LazyThreadSafetyMode.PUBLICATION) {
  println("Initializing myValue")
  123
}


fun main() {
  val x by lazy(LazyThreadSafetyMode.NONE) { 1 + 2 }
  println(x) // 3
}


import kotlin.properties.Delegates.notNull

var text: String by notNull()
fun readText() {
  text = readLine()!!
}

fun main() {
  readText()
  println(text)
}


import kotlin.properties.Delegates.notNull

var num: Int by notNull() // lateinit을 쓸 수 없음

fun main() {
  num = 10
  println(num) // 10
}


import kotlin.properties.Delegates.observable

class Person(name: String, val age: Int) {
  var name: String by observable(name) { _, old, new ->
    println("Name changed: $old to $new")
  }
}

fun main() {
  val person = Person("John", 25)

  person.name = "Harry"   // Name changed: John to Harry
  person.name = "Vincent" // Name changed: Harry to Vincent
  person.name = "Vincent" // Name changed: Vincent to Vincent
}


import kotlin.properties.Delegates.vetoable

var password: String by vetoable("password") { _, old, new ->
  if (new.length< 8) {
    println("Password should be at least 8 characters long")
    false
  } else {
    println("Password is Ok")
    true
  }
}

fun main() {
  password = "pAsSwOrD" // Password is Ok
  password = "qwerty"   // Password should be at least 8 characters long 표시됨
}


class CartItem(data: Map<String, Any?>) {
  val title: String by data
  val price: Double by data
  val quantity: Int by data
}

fun main() {
  val item = CartItem(mapOf(
    "title" to "Laptop",
    "price" to 999.9,
    "quantity" to 1
  ))

  println(item.title)    // Laptop
  println(item.price)    // 999.9
  println(item.quantity) // 1
}


class CartItem(data: MutableMap<String, Any?>) {
  var title: String by data
  var price: Double by data
  var quantity: Int by data
}