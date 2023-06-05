// 4.1.4 내포된 클래스

class Person (val id: Id, val age: Int) {
  class Id(val firstName: String, val familyName: String)
  fun showMe() = println("${id.firstName} ${id.familyName}, $age")
}

fun main() {
  val id = Person.Id("John", "Doe")
  val person = Person(id, 25)
  person.showMe()
}


class Person (private val id: Id, private val age: Int) {
  class Id(private val firstName: String,
           private val familyName: String) {
    fun nameSake(person: Person) = person.id.firstName == firstName
  }

  // error: cannot access 'familyName': it is private in 'id'
  fun showMe() = println("${id.firstName} ${id.familyName}, $age")
}


class Person(val firstName: String, val familyName: String) {
  inner class Possession(val description: String) {
    fun showOwner() = println(fullName())
  }
  private fun fullName() = "$firstName $familyName"
}

fun main() {
  val person = Person("John", "Doe")
  // Possession 생성자 호출
  val wallet = person.Possession("Wallet")
  wallet.showOwner() // John Doe
}


class Person(val firstName: String, val familyName: String) {
  inner class Possession(val description: String) {
    fun showOwner() = println(fullName())
  }

  // this.Possession("Wallet")과 같음
  val myWallet = Possession("Wallet")

  fun fullName() = "$firstName $familyName"
}


class Person(val firstName: String, val familyName: String) {
  inner class Possession(val description: String) {
    fun getOwner() = this@Person
  }
}


class Outer {
  inner class inner

  class Nested
}


class Outer {
  public class Inner {

  }

  public class class Nested {
    
  }
}