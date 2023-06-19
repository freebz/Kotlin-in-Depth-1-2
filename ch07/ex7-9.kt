// 7.1.9 변환

println(setOf("red", "green", "blue").map { it.length })  // [3, 5, 4]
println(listOf(1, 2, 3, 4).map { it*it })                 // [1, 4, 9, 16]
println(byteArrayOf(10, 20, 30).map { it.toString(16) })  // [a, 14, 1e]

// 50, 16, 5, 1, 0
val seq = generateSequence(50) { if (it == 0) null else it / 3 }

println(seq.map { it*3 }.toList())                      // [150, 48, 15, 3, 0]


// [(0, 0), (1, 1), (2, 4), (3, 9), (4, 16), (5, 25)]
println(List(6) { it*it }.mapIndexed { i, n ->i to n })


println(
  arrayOf("1", "red", "2", "green", "3").mapNotNull { it.toIntOrNull() }
) // [1, 2, 3]

println(
  listOf("1", "red", "2", "green", "3").mapIndexedNotNull { i, s ->
    s.toIntOrNull()?.let { i to it }
  }
) // [(0, 1), (2, 2), (4, 3)]


val map = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50)

// [I 1, V 5, X 10, L 50]
println(map.map { "${it.key} ${it.value}" })

// {i=1, v=5, x=10, l=50}
println(map.mapKeys { it.key.lowercase() })

// {I=1, V=5, X=a, L=32}
println(map.mapValues { it.value.toString(16) })


val result = ArrayList<String>()

listOf(1, 2, 3).mapTo(result) { it.toString() }

arrayOf("one", "two", "three").mapIndexedTo(result) { i, s ->
  "${i + 1}: s"
}

sequenceOf("100", "?", "101", "?", "110").mapNotNullTo(result) {
  it.toIntOrNull(2)?.toString()
}

println(result) // [1, 2, 3, 1: s, 2: s, 3: s, 4, 5, 6]


// [a, b, c, d, e, f, g, h, i]
println(setOf("abc", "def", "ghi").flatMap { it.asIterable() })

// [1, 2, 3, 4]
println(listOf(1, 2, 3, 4).flatMap { listOf(it) })

// [1, 1, 2, 1, 2, 3]
println(Array(3) { it + 1 }.flatMap { 1..it })


println(
  listOf(listOf(1, 2), setOf(3, 4), listOf(5)).flatten()
) // [1, 2, 3, 4, 5]

println(Array(3) { arrayOf("a", "b") }.flatten()) // [a, b, a, b, a, b]

println(
  sequence {
    yield(sequenceOf(1, 2))
    yield(sequenceOf(3, 4))
  }.flatten().toList()
) // [1, 2, 3, 4]


val result = ArrayList<String>()

listOf(listOf("abc", "def"), setOf("ghi"))
  .flatMapTo(result) { it }

sequenceOf(sequenceOf(1, 2), sequenceOf(3, 4))
  .flatMapTo(result) { it.map { "$it" } }

println(result) // [abc, def, ghi, 1, 2, 3, 4]


println(
  listOf("red", "green", "blue").associateWith { it.length }
) // {red=3, green=5, blue=4}

println(
  generateSequence(1) { if (it > 50) null else it*3 }
    .associateWith { it.toString(3) }
) // {1=1, 3=10, 9=100, 27=1000, 81=10000}


// {3=red, 5=green, 4=blue}
println(listOf("red", "green", "blue").associateBy { it.length })

// {1=15, 2=25, 3=35}
println(intArrayOf(10, 15, 20, 25, 30, 35).associateBy { it/10 })

// {1=1, 10=3, 100=9, 1000=27, 10000=81}
println(
  generateSequence(1) { if (it > 50) null else it*3 }
    .associateBy { it.toString(3) }
)


println(
  listOf("red", "green", "blue")
    .associate { it.uppercase() to it.length }
) // {RED=3, GREEN=5, BLUE=4}

println(
  intArrayOf(10, 15, 20, 25, 30, 35).associate { it to it/10 }
) // {10=1, 15=1, 20=2, 25=2, 30=3, 35=3}

println(
  generateSequence(1) { if (it > 50) null else it*3 }
    .associate {
      val s = it.toString(3)
      "3^${s.length - 1}" to s
    }
) // {3^0=1, 3^1=10, 3^2=100, 3^3=1000, 3^4=10000}

println(
  listOf("red", "green", "blue").associateBy(
    keySelector = { it.uppercase() },
    valueTransform = { it.length }
  )
) // {RED=3, GREEN=5, BLUE=4}