// 5.5.2 클래스 멤버인 확장

class Address(val city: String, val street: String, val house: String)

class Person(val firstName: String, val familyName: String) {
  fun Address.post(message: String) {
    // 암시적 this: 확장 수신 객체(Address)
    val city = city
    // 한정시키지 않은 this: 확장 수신 객체(Address)
    val street = this.city
    // 한정시킨 this: 확장 수신 객체(Address)
    val house = this@post.house
    // 암시적 this: 디스패치 수신 객체(Person)
    val firstName = firstName
    // 한정시킨 this: 디스패치 수신 객체(Person)
    val familyName = this@Person.familyName

    println("From $firstName, $familyName at $city, $street, $house:")
    println(message)
  }

  fun test(address: Address) {
    // 디스패치 수신 객체: 암시적
    // 확장 수신 객체: 명시적
    address.post("Hello")
  }
}


class Address(val city: String, val street: String, val house: String)

class Person(val firstName, val familyName: String) {
  fun Address.post(message: String) { }
  inner class Mailbox {
    fun Person.testExt(address: Address) {
      address.post("Hello")
    }
  }
}

fun Person.testExt(address: Address) {
  address.post("Hello")
}


class Address(val city: String, val street: String, val house: String) {
  fun test(person: Person) {
    person.post("Hello") // Error: method post() is not defined
  }
}

class Person(val firstName: String, val familyName: String) {
  fun Address.post(message: String) { }
}


class Address(val city: String, val street: String, val house: String) {
  fun test(person: Person) {
    with(person) {
      // 암시적 디스패치와 확장 수신 객체
      post("Hello")
    }
  }
}

class Person(val firstName: String, val familyName: String) {
  fun Address.post(message: String) { }
}


class Address(val city: String, val street: String, val house: String)

class Person(val firstName: String, val familyName: String) {
  fun Address.post(message: String) { }
}

fun main() {
  with(Person("John", "Watson")) {
    Address("London", "Baker Street", "221b").post("Hello")
  }
}


class Address(val city: String, val street: String, val houe: String)

class Person(val firstName: String, val familyName: String) {
  // Person 클래스 밖에서는 쓸 수 없음
  private fun Address.post(message: String) { }
  fun test(address: Address) = address.post("Hello")
}


class Address(val city: String, val street: String, val house: String) {
  fun Address.post(message: String) { }
}


import Person.Companion.parsePerson

class Person(val firstName: String, val familyName: String) {
  companion object {
    fun String.parsePerson(): Person? {
      val names = split(" ")
      return if (names.size == 2) Person(names[0], names[1]) else null
    }
  }
}

fun main() {
  // Person.Companion 인스턴스가 암시적으로 공급됨
  println("John Doe".parsePerson()?.firstName) // John
}