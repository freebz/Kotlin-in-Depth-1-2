// 7.1.6 컬렉션에 대한 조건 검사

println(listOf(1, 2, 3, 4).all { it < 10 })     // true
println(listOf(1, 2, 3, 4).all { it % 2 == 0 }) // false
println(
  mapOf(1 to "I", 5 to "V", 10 to "X")
    .all { it.key == 1 || it.key % 5 == 0 }
)                                     // true

// 1, 3, 9, 27, 81
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.all { it % 3 == 0 })             // false
println(seq.all { it == 1 || it % 3 == 0 })  // true


println(listOf(1, 2, 3, 4).none { it > 5 })  // true
println(
  mapOf(1 to "I", 5 to "V", 10 to "X").none { it.key % 2 == 0 }
)                                            // false

// 1, 3, 9, 27, 81
val seq = generateSequence(1) { if (it < 50) it*3 else null }
println(seq.none { it >= 100 })              // true


println(listOf(1, 2, 3, 4).any { it < 0 })      // false
println(listOf(1, 2, 3, 4).any { it % 2 == 0 }) // true
println(
  mapOf(1 to "I", 5 to "V", 10 to "X").any { it.key == 1 }
)                                 // true

// 1, 3, 9, 27, 81로 이뤄진 시퀀스 만들기
val seq = generateSequence(1) { if (it < 50) it*3 else null }

println(seq.any { it % 3 == 0 }) // true
println(seq.any { it > 100 })    // false


c.all{ p(it) } == c.none { !p(it) }
c.none{ p(it) } == !c.nay { p(it) }


// 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, ...으로 이뤄진 시퀀스
val seq = generateSequence(0) { (it + 1) % 5 }
println(seq.all { it < 5 }) // 끝나지 않음


println(emptyList<String>().any())   // false
println(emptyList<String>().none())  // true
println(listOf(1, 2, 3).any())       // true
println(listOf(1, 2, 3).none())      // false