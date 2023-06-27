// 9.2.4 스타 프로젝션

// List의 원소 타입은 'Any?'에 의해 제한되므로 아무 리스트나 가능함
val anyList: List<*> = listOf(1, 2, 3)

// 자기 자신과 비교 가능한 아무 객체나 가능(T : Comparable<T> 바운드에 의해)
val anyComparable: Comparable<*> = "abcde"


val any: Any = ""
any is TreeNode<*>


any is TreeNode<out Any?> // Ok


any is TreeNode<out Number> // error: cannot check for instance of erased type


interface Named {
  val name: String
}

interface Identified {
  val id: Int
}

class Registry<T> where T : Named, T : Identified

// Registry의 타입 파라미터의 바운드는 Named와 Identified의 교집합이다
var registry: Registry<*>? = null
println(registry?.id ?: "")    // error: unresolved reference: id
println(registry?.name ?: "")  // error: unresolved reference: name


interface Consumer<in T> {
  fun consume(value: T)
}

interface Producer<out T> {
  fun produce(): T
}

fun main() {
  val starProducer: Producer<*> // Producer<Any?>와 같음
  val starConsumer: Consumer<*> // Consumer<Nothing>과 같음
}