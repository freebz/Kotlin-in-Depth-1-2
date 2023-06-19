// 7.1.11 순서

println(intArrayOf(5, 8, 1, 4, 2).sorted())        // [1, 2, 4, 5, 8]

println(
  intArrayOf(5, 8, 1, 4, 2).sortedDescending()
)                                                  // [8, 5, 4, 2, 1]

println(
  listOf("abc", "w", "xyz", "def", "hij").sorted()
)                                                  // [abc, def, hij, w, xyz]

println(
  listOf("abc", "w", "xyz", "def", "hij").sortedDescending()
)                                             // [xyz, w, hij, def, abc]

// 1, -3, 9, -27, 81
val seq = generateSequence(1) { if (it < 50) -it * 3 else null }

println(seq.sorted().toList())                  // [-27, -3, 1, 9, 81]
println(seq.sortedDescending().toList())        // [81, 9, 1, -3, -27]


class Person(val firstName: String,
             val familyName: String,
             val age: Int) {
  override fun toString() = "$firstName $familyName: $age"
}

val Person.fullName get() = "$firstName $familyName"
val Person.reverseFullName get() = "$familyName $firstName"

val FULL_NAME_COMPARATOR = Comparator<Person>{ p1, p2 ->
  p1.fullName.compareTo(p2.fullName)
}
val REVERSE_FULL_NAME_COMPARATOR = Comparator<Person>{ p1, p2 ->
  p1.reverseFullName.compareTo(p2.reverseFullName)
}

fun main() {
  val persons = listOf(
    Person("Brook", "Hudson", 25),
    Person("Silver", "Watts", 30),
    Person("Dane", "Hall", 19),
    Person("Val", "Ortiz", 28)
  )

  println(persons.sortedWith(FULL_NAME_COMPARATOR))
  println(persons.sortedWith(FULL_NAME_COMPARATOR))
  println(persons.sortedWith(REVERSE_FULL_NAME_COMPARATOR))
  println(persons.sortedWith(REVERSE_FULL_NAME_COMPARATOR))
  println(persons.sortedBy { it.age })
  println(persons.sortedByDescending { it.age })
}


val array = intArrayOf(4, 0, 8, 9, 2).apply { sort() }
println(array.contentToString())  // [0, 2, 4, 8, 9]

val list = arrayListOf("red", "blue", "green").apply { sort() }
println(list)                     // [blue, green, red]


println(intArrayOf(1, 2, 3, 4, 5).reversed())       // [5, 4, 3, 2, 1]
println(listOf("red", "green", "blue").reversed())  // [blue, green, red]


val array = intArrayOf(1, 2, 3, 4, 5).apply { reverse() }.contentToString()
println(array) // [5, 4, 3, 2, 1]

val list = arrayListOf("red", "green", "blue").apply { reverse() }
println(list) // [blue, green, red]


val list = arrayListOf("red", "green", "blue")
val reversedCopy = list.reversed()
val reversedMirror = list.asReversed()

list[0] = "violet"

println(list)           // [violet, green, blue]
println(reversedCopy)   // [blue, green, red]
println(reversedMirror) // [blue, green, violet]


println(listOf(1, 2, 3, 4, 5).shuffled())


arrayListOf(1, 2, 3, 4, 5).shuffle()