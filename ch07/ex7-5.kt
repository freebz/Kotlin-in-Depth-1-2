// 7.1.5 컬렉션 원소에 접근하기

println(listOf(1, 2, 3).first())            // 1
println(listOf(1, 2, 3).last())             // 3
println(emptyArray<String>().first())       // Exception
println(emptyArray<String>().firstOrNull()) // null

val seq = generateSequence(1) { if (it > 50) null else it * 3 }

println(seq.first())  // 1
println(seq.last())   // 81


println(listOf(1, 2, 3).first { it > 2 })      // 3
println(listOf(1, 2, 3).lastOrNull { it < 0 }) // null
println(intArrayOf(1, 2, 3).first { it > 3 })  // java.util.NoSuchElementEception


println(listOf(1).single())                    // 1
println(emptyArray<String>().singleOrNull())   // null
println(setOf(1, 2, 3).singleOrNull())         // null
// java.lang.IllegalArgumentException: Sequence has more than one element.
println(sequenceOf(1, 2, 3).single())          // Exception


println(listOf(1, 2, 3).elementAt(2))                        // 3
println(sortedSetOf(1, 2, 3).elementAtOrNull(-1))            // null
println(arrayOf("a", "b", "c").elementAtOrElse(1) { "???" }) // b

val seq = generateSequence(1) { if (it > 50) null else it * 3 }

println(seq.elementAtOrNull(2))                              // 9
println(seq.elementAtOrElse(100) { Int.MAX_VALUE })          // 2147483647
// java.lang.IndexOutOfBoundsException
println(seq.elementAt(10))


val list = listOf(1, 2, 3)

val (x, y) = list        // 1, 2
val (a, b, c, d) = list  // java.lang.IndexOutOfBoundsException