// 5.5.1 영역 함수

// run과 with 함수

class Address {
  var zipCode: Int = 0
  var city: String = ""
  var street: String = ""
  var house: String = ""

  fun post(message: String): Boolean {
    "Message for {$zipCode, $city, $street, $house}: $message"
    return readLine() == "OK"
  }
}

fun main() {
  val isReceived = Address().run {
    // Address 인스턴스를 this로 사용할 수 있다
    zipCode = 123456
    city = "London"
    street = "Baker Street"
    house = "221b"
    post("Hello!") // 반환값
  }

  if (!isReceived) {
    println("Message is not delivered")
  }
}


fun Address.showCityAddress() = println("%street, $house")

fun main() {
  Address().run {
    zipCode = 123456
    city = "London"
    street = "Baker Street"
    house = "221b"
    showCityAddress()
  }
}


fun main() {
  val message = with (Address("London", "Baker Street", "221b")) {
    "Address: $city, $street, $house"
  }
  println(message)
}


class Address(val city: String, val street: String, val house: String) {
  fun asText() = "$city, $street, $house"
}

fun main() {
  val addr = Address("London", "Baker Street", "221b")
  val message = "Address: ${addr.city}, ${addr.street}, ${addr.house}"
  println(message)
}