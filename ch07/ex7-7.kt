// 7.1.7 집계

println(listOf(1, 2, 3, 4).count())                   // 4
println(mapOf(1 to "I", 5 to "V", 10 to "X").count()) // 3

// 1, 3, 9, 27, 81로 이뤄진 시퀀스
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.count())                                  // 5


// 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, ...으로 이뤄진 시퀀스
val seq = generateSequence(0) { (it + 1) % 5 }

// Int.MAX_VALUE보다 많은 원소를 방문하자마자 예외를 던짐
// java.lang.ArithmeticException: Count overflow has happened.
println(seq.count())


println(listOf(1, 2, 3, 4).count { it < 0 })      // 0
println(listOf(1, 2, 3, 4).count { it % 2 == 0 }) // 2
println(
  mapOf(1 to "I", 5 to "V", 10 to "X").count { it.key == 1 }
)                                        // 1

// 1, 3, 9, 27, 81로 이뤄진 시퀀스
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.count { it % 3 == 0 }) // 4
println(seq.count { it > 100 })    // 0


println(listOf(1, 2, 3, 4).sum())           // 10
println(doubleArrayOf(1.2, 2.3, 3.4).sum()) // 6.9

// 1, 3, 9, 27, 81의 합계 구하기
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.sum()) // 121


println(listOf(1, 2, 3, 4).sumOf { it/4.0 })         // 2.5
println(arrayOf("1", "2", "3").sumOf { it.toInt() }) // 6

// X, XX, XXX, XXXX, XXXXX
val seq = generateSequence("X") {
  if (it.length>=5) null else it + "X"
}

println(seq.sumOf { it.length })              // 15


println(listOf(1, 2, 3, 4).average())           // 2.5
println(doubleArrayOf(1.2, 2.3, 3.4).average()) // 2.3000000000000003

// 1, 3, 9, 27, 81의 평균 구하기
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.average())                          // 24.2


println(intArrayOf(5, 8, 1, 4, 2).minOrNull())                // 1
println(intArrayOf(5, 8, 1, 4, 2).maxOrNull())                // 8
println(listOf("abc", "w", "xyz", "def", "hij").minOrNull())  // abc
println(listOf("abc", "w", "xyz", "def", "hij").maxOrNull())  // xyz

// 1, -3, 9, -27, 81
val seq = generateSequence(1) { if (it < 50) -it * 3 else null }

println(seq.min()) // -27
println(seq.max()) // 81


class Person(val firstName: String,
             val familyName: String,
             val age:Int) {
  override fun toString() = "$firstName $familyName: $age"
}

fun main() {
  val persons = sequenceOf(
    Person("Brook", "Watts", 25),
    Person("Silver", "Hudson", 30),
    Person("Dae", "Ortiz", 19),
    Person("Val", "Hall", 28)
  )

  println(persons.minByOrNull { it.firstName })  // Brook Watts: 25
  println(persons.maxByOrNull { it.firstName })  // Val Hall: 28
  println(persons.minByOrNull { it.familyName }) // Val Hall: 25
  println(persons.maxByOrNull { it.familyName }) // Brook Watts: 28
  println(persons.minByOrNull { it.age })        // Dane Ortiz: 19
  println(persons.maxByOrNull { it.age })        // Silver Hudson: 30
}


class Person(val firstName: String,
             val familyName: String,
             val age:Int) {
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
  val persons = sequenceOf(
    Person("Brook", "Hudson", 25),
    Person("Silver", "Watts", 30),
    Person("Dane", "Hall", 19),
    Person("Val", "Ortiz", 28)
  )

  // Brook Hudson: 25
  println(persons.minWithOrNull(FULL_NAME_COMPARATOR))
  // Val Ortiz: 28
  println(persons.maxWithOrNull(FULL_NAME_COMPARATOR))
  // Dane Hall: 19
  println(persons.minWithOrNull(REVERSE_FULL_NAME_COMPARATOR))
  // Silver Watts: 30
  println(persons.maxWithOrNull(REVERSE_FULL_NAME_COMPARATOR))
}


println(listOf(1, 2, 3).joinToString()) // 1, 2, 3


println(listOf(1, 2, 3).joinToString { it.toString(2) }) // 1, 10, 11


val list = listOf(1, 2, 3)
println(list.joinToString(prefix = "[", postfix = "]")) // [1, 2, 3]
println(list.joinToString(separator = "|"))             // 1|2|3
println(list.joinToString(limit = 2))                   // 1, 2, ...
println(list.joinToString(
  limit = 1,
  separator = " ",
  truncated = "???"
))                                                      // 1 ???


import java.lang.StringBuilder

fun main() {
  val builder = StringBuilder("joinTo: ")
  val list = listOf(1, 2, 3)

  println(list.joinTo(builder, separator = "|")) // joinTo: 1|2|3
}


println(intArrayOf(1, 2, 3, 4, 5).reduce { acc, n -> acc * n })  // 120
println(listOf("a", "b", "c", "d").reduce { acc, s -> acc + s })  // abcd


// 8
println(intArrayOf(1, 2, 3, 4, 5)
  .reduceIndexed { i, acc, n -> if (i % 2 == 1) acc * n else acc })

// abd
println(listOf("a", "b", "c", "d")
  .reduceIndexed { i, acc, s -> if (i % 2 == 1) acc + s else acc })


println(
  intArrayOf(1, 2, 3, 4).fold("") { acc, n -> acc ('a' + n - 1) }
) // abcd

println(
  listOf(1, 2, 3, 4).foldIndexed("") { i, acc, n ->
    if (i % 2 == 1) acc + ('a' + n - 1) else acc
  }
) // bd


println(
  arrayOf("a", "b", "c", "d").reduceRight { s, acc -> acc + s }
) // dcba

println(
  listOf("a", "b", "c", "d").reduceRightIndexed { i, s, acc ->
    if (i % 2 == 0) acc + s else acc
  }
) // dca

println(
  intArrayOf(1, 2, 3, 4).foldRight("") { n, acc -> acc + ('a' + n - 1) }
) // dcba

println(
  listOf(1, 2, 3, 4).foldRightIndexed("") { i, n, acc ->
    if (i % 2 == 0) acc + ('a' + n - 1) else acc
  }
) // ca