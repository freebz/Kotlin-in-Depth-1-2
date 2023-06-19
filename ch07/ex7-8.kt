// 7.1.8 걸러내기

// List: [green, blue, green]
println(
  listOf("red", "green", "blue", "green").filter { it.length> 3 }
)

// List: [green, blue]
println(setOf("red", "green", "blue", "green").filter { it.length> 3 })

// List: [green, blue, green]
println(
  arrayOf("red", "green", "blue", "green").filter { it.length> 3 }
)

// List: [2, 4]
println(byteArrayOf(1, 2, 3, 4, 5).filter { it % 2 == 0 })

// Map: {X=10, L=50}
println(
  mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)
    .filter { it.value> 5 }
)

// Sequence
val seq = generateSequence(100) {
  if (it != 0) it/3 else null
}.filter { it > 10 }

// 리스트로 변환: [100, 33, 11]
println(seq.toList())


val map = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)

println(map.filterKeys { it != "L" })  // {I=1, V=5, X=10}
println(map.filterValues { it >= 10 }) // {X=10, L=50}


// [red]
println(listOf("red", "green", "blue").filterNot { it.length> 3 })

// {I=1, V=5}
println(
  mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)
    .filterNot { it.value> 5 }
)


val list = listOf("red", "green", "blue", "orange")

// [green, blue]
println(
  list.filterIndexed { i, v ->v.length> 3 && i<list.lastIndex }
)

val seq = generateSequence(100) { if (it != 0) it/3 else null }

// [33, 11, 3, 1]
println(seq.filterIndexed { i, v -> v > 0 && i> 0 }.toList())


val list = listOf("red", null, "green", null, "blue")

// 널이 될 수 있기 때문에 안전한 호출이나 널 아님 단언이 필요함
// error: only safe (?.) or non-null asserted (!!.) calls are allowed
list.forEach { println(it.length) }

// Ok: it이 널이 될 수 없음
list.filterNotNull().forEach { println(it.length) }


val hotchpotch = listOf(1, "two", 3, "four", 5, "six")
val numbers = hotchpotch.filterIsInstance<Int>()
val strings = hotchpotch.filterIsInstance<String>()

println(numbers.filter { it > 2 })        // [3, 5]
println(strings.filter { it != "two" })   // [four, six]


val allStrings = ArrayList<String>()

// green, blue 추가됨
listOf("red", "green", "blue").filterTo(allStrings) { it.length> 3 }

// one, two, three 추가됨
arrayOf("one", null, "two", null, "three").filterNotNullTo(allStrings)

// abcde, bcde, cde, de, e,
val seq = generateSequence("abcde") {
  if (it.isNotEmpty()) it.substring(1) else null
}

// abcde, bcde, cde 추가됨
seq.filterNotTo(allStrings) { it.length< 3 }

// [green, blue, one, two, three, abcde, bcde, cde]
println(allStrings)


val list = arrayListOf("red", "green", "blue")
list.filterTo(list) { it.length> 3 } // ConcurrentModificationException


val (evens, odds) = listOf(1, 2, 3, 4, 5).partition { it % 2 == 0 }
println(evens) // [2, 4]
println(odds)  // [1, 3, 5]


val seq = generateSequence(100) { if (it == 0) null else it/3 }

val (evens, odds) = seq.partition { it % 2 == 0 }

println(evens) // [100, 0]
println(odds)  // [33, 11, 3, 1]