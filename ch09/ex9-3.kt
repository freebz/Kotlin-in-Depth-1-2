// 9.1.3 타입 소거와 구체화

fun <T>TreeNode<Any>.isInstanceOf(): Boolean =
  // error: cannot check for instance of erased type: T
  data is T && children.all{ it.isInstanceOf<T>() }


val list = listOf(1, 2, 3) // List<Int>
list is List<Number> // OK
// error: cannot check for instance of erased type: List<String>
list is List<String>


list is List<*>
map is Map<*, *>


val collection: Collection<Int> = setOf(1, 2, 3)

if (collection is List<Int>) {
  println("list")
}


val n = (listOf(1, 2, 3) as List<Number>)[0] // OK
val s = (listOf(1, 2, 3) as List<String>)[0] // java.lang.ClassCastException


fun <T>TreeNode<T>.cancellableWalkDepthFirst(
  onEach: (T) -> Boolean
): Boolean {
  // 자바 LinkedList는 Deque를 구현하고 있어서 스택으로도 사용 가능함
  // 자바 Stack 사용은 권장하지 않음
  val nodes = java.util.LinkedList<TreeNode<T>>()

  nodes.push(this)

  while (nodes.isNotEmpty()) {
    val node = nodes.pop()
    if (!onEach(node.data)) return false
    node.children.forEach { nodes.push(it) }
  }

  return true
}

inline fun <reified T> TreeNode<*>.isInstanceOf() =
  cancellableWalkDepthFirst{ it is T }


fun main() {
  val tree = TreeNode<Any>("abc").addChild("def").addChild(123)
  println(tree.isInstanceOf<String>())
}


// error: type parameter T cannot be called as function
inline fun <reified T> factory() = T()


fun <T, U> TreeNode<*>.isInstanceOfBoth() =
  isInstanceOf<T>() && isInstanceOf<U>()