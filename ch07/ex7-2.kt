// 7.1.2 Comparable과 Comparator

class Person(
  val firstName: String,
  val familyName: String,
  val age: Int
) : Comparable<Person> {
  val fullName get() = "$firstName $familyName"
  override fun compareTo(other: Person) = fullName.compareTo(other.fullName)
}


val AGE_COMPARATOR = Comparator<Person>{ p1, p2 ->
  p1.age.compareTo(p2.age)
}


val AGE_COMPARATOR = compareBy<Person>{ it.age }
val REVERSE_AGE_COMPARATOR = compareByDescending<Person>{ it.age }