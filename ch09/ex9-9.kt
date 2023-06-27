// 9.3 타입 별명

typealias IntPredicate = (Int) -> Boolean
typealias IntMap = HashMap<Int, Int>


fun readFirst(filter: IntPredicate) =
  generateSequence{ readLine()?.toIntOrNull() }.firstOrNull(filter)

fun main() {
  val map = IntMap().also {
    it[1] = 2
    it[2] = 3
  }
}


sealed class Status {
  object Success : Status()
  class Error(val message: String) : Status()
}

typealias StSuccess = Status.Success
typealias StError = Status.Error


typealias ThisPredicate<T> = T.() -> Boolean
typealias MultiMap<K, V> = Map<K, Collection<V>>


private typealias MyMap = Map<String, String> // 현재 파일 내부에서만 볼 수 있음


fun main() {
  // error: nested and local type aliases are not supported
  typealias A = Int
}


// error: bounds are not allowed on type alias parameters
typealias ComparableMap<K : Comparable<K>, V> = Map<K, V>


typealias A = Int

fun main() {
  val n = 1
  val a: A = n
  val b: Int = a
}


class MyMap<T> : HashMap<T, T>()

fun main() {
  val map: Map<String, String> = MyMap() // Ok, MyMap은 Map의 하위 타입
  val myMap: MyMap<String> = map // error: type mismatch
}