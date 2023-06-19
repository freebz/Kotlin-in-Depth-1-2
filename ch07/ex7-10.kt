// 7.1.10 하위 컬렉션 추출

// 0, 1, 4, 9, 16, 25
println(List(6) { it*it }.slice(2..4)) // [4, 9, 16]

// 0, 1, 8, 27, 64, 125
println(Array(6) { it*it*it }.slice(2..4)) // [8, 27, 64]


val slice = Array(6) { it*it*it }.sliceArray(2..4).contentToString()


println(List(6) { it*it }.slice(listOf(1, 2, 3)))     // [1, 4, 9]
println(Array(6) { it*it*it }.slice(setOf(1, 2, 3)))  // [1, 8, 27]
println(
  Array(6) { it*it*it }.sliceArray(listOf(1, 2, 3)).contentToString()
) // [1, 8, 27]


println(List(6) { it*it }.take(2))         // [0, 1]
println(List(6) { it*it }.takeLast(2))     // [16, 25]
println(Array(6) { it*it*it }.take(3))     // [0, 1, 8]
println(Array(6) { it*it*it }.takeLast(3)) // [27, 64, 125]


val seq = generateSequence(1) { if (it > 100) null else it*3 }
println(seq.take(3).toList()) // [1, 3, 9]


println(List(6) { it*it }.drop(2))          // [4, 9, 16, 25]
println(List(6) { it*it }.dropLast(2))      // [0, 1, 4, 9]

println(Array(6) { it*it*it }.drop(3))      // [27, 64, 125]
println(Array(6) { it*it*it }.dropLast(3))  // [0, 1, 8]

val seq = generateSequence(1) { if (it > 100) null else it*3 }
println(seq.drop(3).toList())               // [27, 81, 243]


val list = List(6) { it * it }

println(list.takeWhile { it < 10 })         // [0, 1, 4, 9]
println(list.takeLastWhile { it > 10 })     // [16, 25]
println(list.dropWhile { it < 10 })         // [16, 25]
println(list.dropLastWhile { it > 10 })     // [0, 1, 4, 9]

val seq = generateSequence(1) { if (it > 100) null else it*3 }

println(seq.takeWhile { it < 10 }.toList()) // [1, 3, 9]
println(seq.dropWhile { it < 10 }.toList()) // [27, 81, 243]


// 0, 1, 4, 9, 16, 25, 36, 49, 64, 81
val list = List(10) { it*it }

println(list.chunked(3)) // [[0, 1, 4], [9, 16, 25], [36, 49, 64], [81]]

// 1, 3, 9, 27, 81, 243, 729
val seq = generateSequence(1) { if (it > 300) null else it*3 }

println(seq.chunked(3).toList()) // [[1, 3, 9], [27, 81, 243], [729]]


// 0, 1, 4, 9, 16, 25, 36, 49, 64, 81
val list = List(10) { it * it }

println(list.chunked(3) { it.sum() }) // [5, 50, 149, 81]

// 1, 3, 9, 27, 81, 243, 729
val seq = generateSequence(1) { if (it > 300) null else it*3 }

println(seq.chunked(3) { it.sum() }.toList()) // [13, 351, 729]


// 0, 1, 4, 9, 16, 25
val list = List(6) { it*it }

// [[0, 1, 4], [1, 4, 9], [4, 9, 16], [9, 16, 25]]
println(list.windowed(3))

// 1, 3, 9, 27, 81, 243
val seq = generateSequence(1) { if (it > 100) null else it*3 }

// [[1, 3, 9], [3, 9, 27], [9, 27, 81], [27, 81, 243]]
println(seq.windowed(3).toList())


// 0, 1, 4, 9, 16, 25
val list = List(6) { it*it }

println(list.windowed(3) { it.sum() }) // [5, 14, 29, 50]

// 1, 3, 9, 27, 81, 243
val seq = generateSequence(1) { if (it > 100) null else it*3 }

println(seq.windowed(3) { it.sum() }.toList()) // [13, 39, 117, 351]


// 0, 1, 4, 9, 16, 25
val list = List(6) { it*it }

// 짝수 인덱스(0, 2) 원소만 윈도우 시작 원소가 된다
// [[0, 1, 4], [4, 9, 16]]
println(list.windowed(3, step = 2))

// 맨 뒤에 두 가지 부분 윈도우(크기가 3보다 작음)를 포함시킨다
// [[0, 1, 4], [1, 4, 9], [4, 9, 16], [9, 16, 25], [16, 25], [25]]
println(list.windowed(3, partialWindows = true))


// 0, 1, 4, 9, 16, 25
val list = List(6) { it*it }

// [(0, 1), (1, 4), (4, 9), (9, 16), (16, 25)]
println(list.zipWithNext())

// 1, 3, 9, 27, 81, 243
val seq = generateSequence(1) { if (it > 100) null else it*3 }

// [(1, 3), (3, 9), (9, 27), (27, 81), (81, 243)]
println(seq.zipWithNext().toList())


// [0, 4, 36, 144, 400]
println(List(6) { it*it }.zipWithNext { a, b -> a * b })