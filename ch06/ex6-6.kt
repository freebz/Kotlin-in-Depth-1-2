// 6.2.2 구조 분해 선언

import kotlin.random.Random

data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

fun newPerson() = Person(readLine()!!,
                         readLine()!!,
                         Random.nextInt(100))

fun main() {
  val person = newPerson()
  val firstName = person.firstName
  val familyName = person.familyName
  val age = person.age

  if (age < 10) {
    println("$firstName $familyName is under-age")
  }
}


val (firstName, familyName, age) = person


val (firstName, familyName, age) = Person("John", "Doe", 25)

println("$firstName $familyName: $age") // John Doe: 25


val (familyName, firstName, age) = Person("John", "Doe", 25)

println("$firstName $familyName: $age") // Doe John: 25


val (firstName, familyName: String, age) = Person("John", "Doe", 25)


val (firstName, familyName) = Person("John", "Doe", 25)
println("$firstName $familyName") // John Doe

val (name) = Person("John", "Doe", 25)
println(name)                     // John


val (_, familyName) = Person("John", "Doe", 25)
println(familyName) // Doe


var (firstName, familyName) = Person("John", "Doe", 25)
firstName = firstName.lowercase()
familyName = familyName.lowercase()
println("$firstName $familyName") // john doe


val pairs = arrayOf(1 to "one", 2 to "two", 3 to "three")

for ((number, name) in pairs) {
  println("$number: $name")
}


fun combine(person1: Person,
            person2: Person,
            folder: ((String, Person) -> String)): String {
  return folder(folder("", person1), person2)
}

fun main() {
  val p1 = Person("John", "Doe", 25)
  val p2 = Person("Jane", "Doe", 26)

  // 구조 분해를 쓰지 않음
  println(combine(p1, p2) { text, person -> "$text ${person.age}" })

  // 구조 분해를 씀
  println(combine(p1, p2) { text, (firstName) -> "$text $firstName" })
  println(combine(p1, p2) { text, (_, familyName) -> "$text $familyName" })
}


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

val (firstName, familyName) = Person("John", "Doe", 25) // Error


data class Person(val firstName: String,
                  val familyName: String,
                  val age: Int)

data class Mailbox(val address: String, val person: Person)

fun main() {
  val (address, (firstName, familyName, age)) =
        // error: expecting a name 외 여러 가지 오류
        Mailbox("Unknown", Person("John", "Doe", 25))
}