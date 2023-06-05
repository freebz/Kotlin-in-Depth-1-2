// 4.1.3 멤버 가시성

class Person(private val firstName: String,
             private val familyName: String) {
  fun fullName() = "$firstName $familyName"
}

fun main() {
  val person = Person("John", "Doe")
  // error: cannot access 'firstName': it is private in 'Person'
  println(person.firstName)
  println(person.fullName()) // Ok
}


class Empty private constructor() {
  fun showMe() = println("Empty")
}

fun main() {
  // error: cannot access '<init>': it is private in 'Empty'
  Empty().showMe()
}