// 9.2.1 변성: 생산자와 소비자 구분

val node: TreeNode<Any> = TreeNode<String>("Hello") // error: type mismatch


val stringNode = TreeNode<String>("Hello")
val anyNode: TreeNode<Any> = stringNode
anyNode.addChild(123)
val s = stringNode.children.first() // ???


val stringProducer: () -> String = { "Hello" }
val anyProducer: () -> Any = stringProducer
println(anyProducer()) // Hello


interface NonGrowingList<T> {
  val size: Int
  fun get(index: Int): Int
  fun remove(index: Int)
}


interface Set<T> {
  fun contains(element: T): Boolean
}


val anyConsumer: (Any) -> Unit = { println(it) }
val stringConsumer: (String) -> Unit = anyConsumer
stringConsumer("Hello") // Hello