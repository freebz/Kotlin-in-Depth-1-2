// 11.3 고차 함수와 DSL

// 11.3.1 중위 함수를 사용해 플루언트 DSL 만들기

val nums = listOf(2, 8, 9, 1, 3, 6, 5)
val query = from(nums) where { it > 3 } select { it*2 } orderBy { it }
println(query.items.toList())


interface ResultSet<out T> {
  val items: Sequence<T>
}


class From<out T>(private val source: Iterable<T>) : ResultSet<T> {
  override val items: Sequence<T>
    get() = source.asSequence()
}

class Where<out T>(
  private val from: ResultSet<T>,
  private val condition: (T) -> Boolean
) :ResultSet<T> {
  override val items: Sequence<T>
    get() = from.items.filter(condition)
}

class Select<out T, out U>(
  private val from: ResultSet<T>,
  private val output: (T) -> U
) :ResultSet<U> {
  override val items: Sequence<U>
    get() = from.items.map(output)
}

class OrderBy<out T, in K : Comparable<K>>(
  private val select: ResultSet<T>,
  private val orderKey: (T) -> K
) :ResultSet<T> {
  override val items: Sequence<T>
    get() = select.items.sortedBy(orderKey)
}


// from 뒤에 where이 올 수 있음
infix fun <T> From<T>.where(condition: (T) -> Boolean) =
  Where(this, condition)

// from이나 where 뒤에 select가 올 수 있음
infix fun <T, U> From<T>.select(output: (T) -> U) =
  Select(this, output)

infix fun <T, U> Where<T>.select(output: (T) -> U) =
  Select(this, output)

// select 뒤에 orderBy가 올 수 있음
infix fun <T, K : Comparable<K>> Select<*, T>.orderBy(
  orderKey: (T) -> K
) = OrderBy(this, orderKey)


fun <T>from(source: Iterable<T>) = From(source)


val nums = listOf(2, 8, 9, 1, 3, 6, 5)
val query = from(nums) where { it > 3 } select { it*2 } orderBy { it }
println(query.items.toList())

// [10, 12, 16, 18]


val query = from(nums) where { it> 3 } where { it < 10 }


infix fun <T> Where<T>.where(condition: (T) -> Boolean) =
  Where(this, condition)