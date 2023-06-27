// 9.2.2 선언 지점 변성

interface List<T> {
  val size: Int
  fun get(index: Int): T
}

class ListByArray<T>(private vararg val items: T) : List<T> {
  override val size: Int get() = items.size
  override fun get(index: Int) = items[index]
}


fun <T> concat(list1: List<T>, list2: List<T>) = object : List<T> {
  override val size: Int
    get() = list1.size + list2.size

  override fun get(index: Int): T {
    return if (index < list1.size) {
      list1.get(index)
    } else {
      list2.get(index - list1.size)
    }
  }
}


val numbers = ListByArray<Number>(1, 2.5, 3f)
val integers = ListByArray(10, 20, 30)
val result = concat(numbers, integers) // error: type mismatch


interface List<out T> {
  val size: Int
  fun get(index: Int): T
}


interface MutableList<T> : List<T> {
  fun set(index: Int, value: T)
}


interface MutableList<out T> : List<T> {
  // error: type parameter T is declared as 'out' but occurs in 'in' position in type T
  fun set(index: Int, value: T)
}


interface LazyList<out T> {
  // 반환 타입으로 쓰임
  fun get(index: Int): T

  // 반환 타입의 out 타입 파라미터로 쓰임
  fun subList(range: IntRange): LazyList<T>

  // 함수 타입의 반환값 부분도 out 위치임
  fun getUpTo(index: Int): () -> List<T>
}


class ListByArray<out T>(private vararg val items: T) : List<T> { ... }


class Writer<in T> {
  // 함수 인자로 쓰임
  fun write(value: T) {
    println(value)
  }

  // in 위치에 사용된 Iterable 제네릭 타입의 out 위치 인자로 T를 사용함
  // 이런 경우 위치가 in 위치로 인정됨
  fun writeList(values: Iterable<T>) {
    values.forEach { println(it) } 
  }
}

fun main() {
  val numberWriter = Writer<Number>()

  // 맞음: Writer<Number>가 Int도 처리 가능
  val integerWriter: Writer<Int> = numberWriter

  integerWriter.write(100)
}