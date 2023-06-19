// 7.1.4 기본 컬렉션 연산

val map = mapOf(1 to "one", 2 to "two", 3 to "three")

for ((key, value) in map) {
  println("$key -> $value")
}


intArrayOf(1, 2, 3).forEach { println(it*it) }

listOf("a", "b", "c").forEach { println("'$it'") }

sequenceOf("a", "b", "c").forEach { println("'$it'") }

mapOf(1 to "one", 2 to "two", 3 to "three").forEach { (key, value) ->
  println("$key -> $value")
}


listOf(10, 20, 30).forEachIndexed { i, n ->println("$i: ${n*n}") }


val list = listOf(1, 2, 3)

println(list.isEmpty())                 // false
println(list.size)                      // 3
println(list.contains(4))               // false
println(2 in list)                      // true
println(list.containsAll(listOf(1, 2))) // true


val list = arrayListOf(1, 2, 3)
list.add(4)                      // 원소 하나 추가: [1, 2, 3, 4]
list.remove(3)                   // 원소 하나 제거: [1, 2, 4]
list.addAll(setOf(5, 6))         // 합집합: [1, 2, 4, 5, 6]
list.removeAll(listOf(1, 2))     // 차집합: [4, 5, 6]
list.retainAll(listOf(5, 6, 7))  // 교집합: [5, 6]
list.clear()                     // 모든 원소 제거: []


list += 4
list -= 3
list += setOf(5, 6)
list -= listOf(1, 2)


println(listOf(1, 2, 3) + 4)           // [1, 2, 3, 4]
println(listOf(1, 2, 3) - setOf(2, 5)) // [1, 3]


val readOnly = listOf(1, 2, 3)
readOnly += 4 // Error: can't assign to val
var mutable = listOf(1, 2, 3)
mutable += 4  // Correct


val list = listOf(1, 4, 6, 2, 4, 1, 7)

println(list.get(3))         // 2
println(list[2])             // 6
println(list[10])            // java.lang.ArrayIndexOutOfBoundsException
println(list.indexOf(4))     // 1
println(list.lastIndexOf(4)) // 4
println(list.indexOf(8))     // -1


val list = arrayListOf(1, 4, 6, 2, 4, 1, 7)

list.set(3, 0)    // [1, 4, 6, 0, 4, 1, 7]
list[2] = 1       // [1, 4, 1, 0, 4, 1, 7]
list.removeAt(5)  // [1, 4, 1, 0, 4, 7]
list.add(3, 8)    // [1, 4, 1, 8, 0, 4, 7]


val list = arrayListOf(1, 4, 6, 2, 4, 1, 7)
val segment = list.subList(2, 5) // [6, 2, 4, 1]

list[3] = 0
println(segment[1])   // 0
segment[1] = 8
println(list[3])      // 8


val map = mapOf(1 to "I", 5 to "V", 10 to "X", 50 to "L")

println(map.isEmpty())              // false
println(map.size)                   // 4
println(map.get(5))                 // V
println(map[10])                    // X
println(map[100])                   // null
println(map.getOrDefault(100, "?")) // ?
println(map.getOrElse(100) { "?" }) // ?
println(map.containsKey(10))        // true
println(map.containsValue("C"))     // false
println(map.keys)                   // [1, 5, 10, 50]
println(map.values)                 // [I, V, X, L]
println(map.entries)                // [1=I, 5=V, 10=X, 50=L]


val map = sortedMapOf(1 to "I", 5 to "V")

map.put(100, "C")            // {1=I, 5=V, 100=C}
map[500] = "D"               // {1=I, 5=V, 100=C, 500=D}
map.putAll(mapOf(10 to "X")) // {1=I, 5=V, 10=X, 100=C, 500=D}
map += 50 to "L"             // {1=I, 5=V, 10=X, 50=L, 100=C, 500=D}
map += mapOf(2 to "II",
3 to "III")                  // {1=I, 2=II, 3=III, 5=V, 10=X, 50=L, 100=C, 500=D}
map -= 100                   // {1=I, 2=II, 3=III, 5=V, 10=X, 50=L, 500=D}
map -= listOf(2, 3)          // {1=I, 5=V, 10=X, 50=L, 500=D}