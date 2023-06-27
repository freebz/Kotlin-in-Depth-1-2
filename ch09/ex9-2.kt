// 9.1.2 바운드와 제약

fun <T : Number>TreeNode<T>.average(): Double {
  var count = 0
  var sum = 0.0
  walkDepthFirst {  // 깊이 우선으로 노드를 방문하면서 함수 수행
    count++
    sum += it.toDouble()
  }
  return sum/count
}


val intTree = TreeNode(1).apply {
  addChild(2).addChild(3)
  addChild(4).addChild(5)
}
println(intTree.average()) // 3.0


val stringTree = TreeNode("Hello").apply {
  addChildren("World", "!!!")
}
// error: unresolved reference. None of the following candidates is applicable because of receiver type mismatch
println(stringTree.average())


// 제네릭이 아닌 함수로 대신할 수 있다
// fun TreeNode<Int>.sum(): Int {...}
// warning: 'Int' is a final type, and thus a value of the type parameter is predetermined
fun <T : Int> TreeNode<T>.sum(): Int {
  var sum = 0
  walkDepthFirst{ sum += it }
  return sum
}


fun <T : Comparable<T>> TreeNode<T>.maxNode(): TreeNode<T> {
  val maxChild = children.maxByOrNull { it.data } ?: return this

  return if (data >= maxChild.data) this else maxChild
}

fun main() {
  // Double은 Comparable<Double>의 하위 타입임
  val doubleTree = TreeNode(1.0).apply {
    addChild(2.0)
    addChild(3.0)
  }
  println(doubleTree.maxNode().data) // 3.0

  // String은 Comparable<String>의 하위 타입임
  val stringTree = TreeNode("abc").apply {
    addChildren("xyz", "def")
  }
  println(stringTree.maxNode().data) // xyz
}


fun <T, U : T> TreeNode<U>.toList(list: MutableList<T>) {
  walkDepthFirst{ list += it }
}


fun main() {
  val list = ArrayList<Number>()

  TreeNode(1).apply {
    addChild(2)
    addChild(3)
  }.toList(list)

  TreeNode(1.0).apply {
    addChild(2.0)
    addChild(3.0)
  }.toList(list)
}


fun <T: Any> notNullTreeOf(data: T) = TreeNode(data)


interface Named {
  val name: String
}

interface Identified {
  val id: Int
}


class Registry<T> where T : Named, T : Identified {
  val items = ArrayList<T>()
}