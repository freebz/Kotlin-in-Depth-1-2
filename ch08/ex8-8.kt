// 8.2.4 위임

interface PersonData {
  val name: String
  val age: Int
}

open class Person(
  override val name: String,
  override val age: Int
): PersonData

data class Book(val title: String, val author: PersonData) {
  override fun toString() = "'$title' by ${author.name}"
}

fun main() {
  val valWatts = Person("Val Watts", 30)
  val introKotlin = Book("Introduction to Kotlin", valWatts)

  println(introKotlin) // 'Introduction to Kotlin' by Val Watts
}


class Alias(
  private val realIdentity: PersonData,
  private val newIdentity: PersonData
): PersonData {
  override val name: String
    get() = newIdentity.name

  override val age: Int
    get() = newIdentity.age
}


fun main() {
  val valWatts = Person("Val Watts", 30)
  val johnDoe = Alias(valWatts, Person("John Doe", 25))
  val introJava = Book("Introduction to Java", johnDoe)

  println(introJava) // 'Introduction to Java' by John Doe
}


class Alias(
  private val realIdentity: PersonData,
  private val newIdentity: PersonData
): PersonData by newIdentity


class Alias(
  private val realIdentity: PersonData,
  private val newIdentity: PersonData
): PersonData by newIdentity {
  override val age: Int get() = realIdentity.age
}

fun main() {
  val valWatts = Person("Val Watts", 30)
  val johnDoe = Alias(valWatts, Person("John Doe", 25))
  println(johnDoe.age) // 30
}


class Alias(
  private val realIdentity: PersonData,
  newIdentity: PersonData
): PersonData by newIdentity


class Alias(
  private val realIdentity: PersonData
): PersonData by newIdentity { // error: unresolved reference: newIdentity
  val newIdentity = Person("John Doe", 30)
}


fun PersonData.aliased(newIdentity: PersonData) =
  object : PersonData by newIdentity {
    override val age: Int get() = this@aliased.age
  }

fun main() {
  val valWatts = Person("Val Watts", 30)
  val johnDoe = valWatts.aliased(Person("John Doe", 25))

  println("${johnDoe.name}, ${johnDoe.age}") // John Doe, 30
}


class Alias(
  private val realIdentity: PersonData,
  private val newIdentity: PersonData
): Person by newIdentity // error: only interfaces can be delegated to