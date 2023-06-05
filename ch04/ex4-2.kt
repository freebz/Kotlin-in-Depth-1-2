// 4.1.2 생성자

class Person(firstName: String, familyName: String) {
  val fullName = "$firstName $familyName"
}


fun main() {
  val person = Person("John", "Doe") // 새 Person 인스턴스 생성
  println(person.fullName)           // John Doe
}


class Person(firstName: String, familyName: String) {
  val fullName = "$firstName $familyName"

  init {
    println("Created new Person instance: $fullName")
  }
}


class Person(firstName: String, familyName: String) {
  val fullName = "$firstName $familyName"

  init {
    // error: 'return' is not allowed here
    if (firstName.isEmpty() && familyName.isEmpty()) return
    println("Created new Person instance: $fullName")
  }
}


class Person(fullName: String) {
  val firstName: String
  val familyName: String
  init {
    val names = fullName.split(" ")
    if (names.size != 2) {
      throw IllegalArgumentException("Invalid name: $fullName")
    }
    firstName = names[0]
    familyName = names[1]
  }
}

fun main() {
  val person = Person("John Doe")
  println(person.firstName) // John
}


class Person(fullName: String) {
  // error: property must be initialized or be abstract
  val firstName: String
  val familyName: String
  init {
    val names = fullName.split(" ")
    if (names.size == 2) {
      firstName = names[0]
      familyName = names[1]
    }
  }
}


class Person(firstName: String, familyName: String) {
  val fullName = "$firstName $familyName"
  fun printFirstName() {
    println(firstName) // Error: first name is not available here
  }
}


class Person(firstName: String, familyName: String) {
  val firstName = firstName // firstName은 생성자 파라미터를 가리킴
  val fullName = "$firstName $familyName"

  fun printFirstName() {
    println(firstName) // Ok: 여기서 firstName은 멤버 프러퍼티를 가리킴
  }
}


class Person(val firstName: String, familyName: String) {
  // firstName은 생성자 파라미터를 가리킴
  val fullName = "$firstName $familyName"

  fun printFirstName() {
    println(firstName) // firstName은 멤버 프로퍼티를 가리킴
  }
}

fun main() {
  val person = Person("John", "Doe")
  println(person.firstName) // firstName은 프로퍼티를 가리킴
}


class Person(val firstName: String, val familyName: String = "") {
}


class Person(val firstName: String, val familyName: String = "")


class Person(val firstName: String, val familyName: String = "") {
  fun fullName() = "$firstName $familyName"
}

class Room(vararg val persons: Person) {
  fun showNames() {
    for (person in persons) println(person.fullName())
  }
}

fun main() {
  val room = Room(Person("John"), Person("Jane", "Smith"))
  room.showNames()
}


class Person {
  val firstName: String
  val familyName: String

  constructor(firstName: String, familyName: String) {
    this.firstName = firstName
    this.familyName = familyName
  }

  constructor(fullName: String) {
    val names = fullName.split(" ")
    if (names.size != 2) {
      throw IllegalArgumentException("Invalid name: $fullName")
    }
    firstName = names[0]
    familyName = names[1]
  }
}


class Person {
  val fullName: String
  constructor(firstName: String, familyName: String):
    this("$firstName $familyName")
  constructor(fullName: String) {
    this.fullName = fullName
  }
}


class Person(val fullName: String) {
  constructor(firstName: String, familyName: String):
    this("$firstName $familyName")
}


class Person {
  // error: 'val' on secondary constructor parameter is not allowed
  constructor(val fullName: String)
}