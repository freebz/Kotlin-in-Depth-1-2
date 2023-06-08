// 문맥이 없는 run

class Address(val city: String, val street: String, val house: String) {
  fun asText() = "$city, $street, $house"
}

fun main() {
  val address = Address("London", "Baker Street", "221b")
  println(address.asText())
}


fun main() {
  val city = readLine() ?: return
  val street = readLine() ?: return
  val house = readLine() ?: return
  val address = Address(city, street, house)
  println(address.asText())
}


fun main() {
  val address = Address(readLine() ?: return,
                        readLine() ?: return,
                        readLine() ?: return)
  println(address.asText())
}


fun main() {
  val address = run {
    val city = readLine() ?: return
    val street = readLine() ?: return
    val house = readLine() ?: return
    Address(city, street, house)
  }

  println(address.asText())
}


fun main() {
  val address = {
    val city = readLine() ?: return // Error: return is not allowed
    val street = readLine() ?: return // Error: return is not allowed
    val house = readLine() ?: return // Error: return is not allowed
    Address(city, street, house)
  }

  println(address.asText()) // Error: no asText() method
}