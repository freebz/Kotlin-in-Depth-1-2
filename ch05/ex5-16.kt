// apply/also 함수

class Address {
  var city: String = ""
  var street: String = ""
  var house: String = ""

  fun post(message: String) { }
}

fun main() {
  val message = readLine() ?: return

  Address().apply {
    city = "London"
    street = "Baker Street"
    house = "221b"
  }.post(message)
}


fun main() {
  val message = readLine() ?: return

  Address().also {
    it.city = "London"
    it.street = "Baker Street"
    it.house = "221b"
  }.post(message)
}