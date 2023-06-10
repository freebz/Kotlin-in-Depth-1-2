// 6.2.1 데이터 클래스와 데이터 클래스에 대한 연산

class Person(val firstName: String,
             val familyName: String,
             val age: Int)


fun main() {
  val person1 = Person("John", "Doe", 25)
  val person2 = Person("John", "Doe", 25)
  val person3 = person1

  println(person1 == person2) // false, 서로 다른 정체성
  println(person1 == person3) // true, 같은 정체성
}


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

fun main() {
  val person1 = Person("John", "Doe", 25)
  val person2 = Person("John", "Doe", 25)
  val person3 = person1

  println(person1 == person2) // true
  println(person1 == person3) // true
}


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

data class Mailbox(val address: String, val person: Person)

fun main() {
  val box1 = Mailbox("Unknown", Person("John", "Doe", 25))
  val box2 = Mailbox("Unknown", Person("John", "Doe", 25))
  println(box1 == box2) // true
}


class Person(val firstName: String,
             val familyName: String,
             val age: Int)

data class Mailbox(val address: String, val person: Person)

fun main() {
  val box1 = Mailbox("Unknown", Person("John", "Doe", 25))
  val box2 = Mailbox("Unknown", Person("John", "Doe", 25))
  // false: 두 Person 인스턴스의 정체성이 다름
  println(box1 == box2)
}


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

fun main() {
  val person = Person("John", "Doe", 25)
  println(person) // Person(firstName=John, familyName=Doe, age=25)
}


data class Person(val firstName: String, val familyName: String) {
  var age = 0
}

fun main() {
  val person1 = Person("John", "Doe").apply { age = 25 }
  val person2 = Person("John", "Doe").apply { age = 26 }
  println(person1 == person2) // true
}


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

fun Person.show() = println("$firstName $familyName: $age")

fun main() {
  val person = Person("John", "Doe", 25)

  person.show()                                     // John Doe: 25
  person.copy().show()                              // John Doe: 25
  person.copy(familyName = "Smith").show()          // John Smith: 25
  person.copy(age = 30, firstName = "Jane").show()  // Jane Doe: 30
}


fun main() {
  val pair = Pair(1, "two")

  println(pair.first + 1)    // 2
  println("${pair.second}!") // two!

  val triple = Triple("one", 2, false)

  println("${triple.first}!")    // one!
  println(triple.second - 1)     // 1
  println(!triple.third)         // true
}


val pair = 1 to "two"

println(pair.first + 1)    // 2
println("${pair.second}!") // two!