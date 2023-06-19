// 7.1.3 컬렉션 생성하기

val list = ArrayList<String>()
list.add("red")
list.add("green")
println(list) // [red, green]

val set = HashSet<Int>()
set.add(12)
set.add(21)
set.add(12)
println(set) // [12, 21]

import java.util.TreeMap
val map = TreeMap<Int, String>()
map[20] = "Twenty"
map[10] = "Ten"
println(map) // {10=Ten, 20=Twenty}


val emptyList = emptyList<String>()
println(emptyList)   // []
emptyList.add("abc") // Error: add is unresolved

val singletonSet = setOf("abc")
println(singletonSet)      // [abc]
singletonSet.remove("abc") // Error: remove is unresolved

val mutableList = mutableListOf("abc")
println(mutableList) // [abc]
mutableList.add("def")
mutableList[0] = "xyz"
println(mutableList) // [xyz, def]

val sortedSet = sortedSetOf(8, 5, 7, 1, 4)
println(sortedSet) // [1, 4, 5, 7, 8]
sortedSet.add(2)
println(sortedSet) // [1, 2, 4, 5, 7, 8]


val emptyMap = emptyMap<Int, String>()
println(emptyMap) // {}
emptyMap[10] = "Ten" // error: unresolved reference: add

val singletonMap = mapOf(10 to "Ten")
println(singletonMap) // {10=Ten}
singletonMap.remove("abc") // error: unresolved reference

val mutableMap = mutableMapOf(10 to "Ten")
println(mutableMap) // {10=Ten}
mutableMap[20] = "Twenty"
mutableMap[100] = "Hundred"
mutableMap.remove(10)
println(mutableMap) // {20=Twenty, 100=Hundred}

val sortedMap = sortedMapOf(3 to "three", 1 to "one", 2 to "two")
println(sortedMap) // {1=one, 2=two, 3=three}
sortedMap[0] = "zero"
println(sortedMap) // {0=zero, 1=one, 2=two, 3=three}


println(List(5) { it*it }) // [0, 1, 4, 9, 16]

val numbers = MutableList(5) { it*2 }
println(numbers) // [0, 2, 4, 6, 8]
numbers.add(100)
println(numbers) // [0, 2, 4, 6, 8, 100]


println(sequenceOf(1, 2, 3).iterator().next())              // 1
println(listOf(10, 20, 30).asSequence().iterator().next())  // 10
println(
  mapOf(1 to "One", 2 to "Two").asSequence().iterator().next()
)                                                           // 1=One


val numbers = generateSequence{ readLine()?.toIntOrNull() }


// 무한 시퀀ㅅ(단, 값 오버플로가 발생해서 음수와 양수를 왔다갔다 함): 1, 2, 4, 8, ...
val powers = generateSequence(1) { it*2 }

// 유한 시퀀스: 10, 8, 6, 4, 2, 0
val evens = generateSequence(10) { if (it >= 2) it - 2 else null }


val numbers = sequence {
  yield(0)
  yieldAll(listOf(1, 2, 3))
  yieldAll(intArrayOf(4, 5, 6).iterator())
  yieldAll(generateSequence(10) { if (it < 50) it*3 else null })
}

println(numbers.toList()) // [0, 1, 2, 3, 4, 5, 6, 10, 30, 90]


println(
  listOf(1, 2, 3, 2, 3).toSet()
) // [1, 2, 3]

println(
  arrayOf("red", "green", "blue").toSortedSet()
) // [blue, green, blue]

println(
  mapOf(1 to "one", 2 to "two", 3 to "three").toList()
) // [(1, one), (2, two), (3, three)]

println(
  sequenceOf(1 to "one", 2 to "two", 3 to "three").toMap()
) // {1=one, 2=two, 3=three}