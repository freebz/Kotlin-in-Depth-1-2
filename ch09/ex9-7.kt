// 9.2.3 프로젝션을 사용한 사용 지점 변성

fun <T> TreeNode<T>.addSubtree(node: TreeNode<T>): TreeNode<T> {
  val newNode = addChild(node.data)
  node.children.forEach { newNode.addSubtree (it) }
  return newNode
}

fun main() {
  val root = TreeNode("abc")
  val subRoot = TreeNode("def")

  root.addSubtree(subRoot)
  println(root) // abc {def {}}
}


val root = TreeNode<Number>(123)
val subRoot = TreeNode(456.7)
root.addSubtree(subRoot) // error: type mismatch


fun <T> TreeNode<T>.addSubtree(node: TreeNode<out T>): TreeNode<T> {
  val newNode = addChild(node.data)

  node.children.forEach { newNode.addSubtree(it) }
  return newNode
}

fun main() {
  val root = TreeNode<Number>(123)
  val subRoot = TreeNode(456.7)

  root.addSubtree(subRoot)
  println(root) // 123 {456.7 {}}
}


fun <T, U : T> TreeNode<T>.addSubtree(node: TreeNode<U>): TreeNode<T> {
  val newNode = addChild(node.data)

  node.children.forEach { newNode.addSubtree(it) }
  return newNode
}


fun processOut(node: TreeNode<out Any>) {
  node.addChild("xyz") // error: type mismatch
}


fun <T> TreeNode<T>.addTo(parent: TreeNode<in T>) {
  val newNode = parent.addChild(data)

  children.forEach { it.addTo(newNode) }
}


fun main() {
  val root = TreeNode<Number>(123)
  val subRoot = TreeNode(456.7)

  subRoot.addTo(root)

  println(root) // 123 {456.7 {}}
}


interface Producer<out T>{
  fun produce(): T
}

interface Consumer<in T> {
  fun consume(value: T)
}

fun main() {
  // error: projection is conflicting with variance of the corresponding type parameter of Producer
  val inProducer: Producer<in String>
  // warning: projection is redundant: the corresponding type parameter of Producer has the same variance
  val outProducer: Producer<out String>
  // warning: projection is redundant: the corresponding type parameter of Consumer has the same variance
  val inConsumer: Consumer<in String>
  // error: projection is confilicting with variance of the corresponding type parameter of Consumer
  val outConsumer: Consumer<out String>
}