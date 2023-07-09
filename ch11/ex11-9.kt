// 11.1.8 이터레이션

operator fun <T>TreeNode<T>.iterator() = children.iterator()


fun main() {
  val content = TreeNode("Title").apply {
    addChild("Topic 1").apply {
      addChild("Topic 1.1")
      addChild("Topic 1.2")
    }
    addChild("Topic 2")
    addChild("Topic 3")
  }
  for (item in content) {
    println(item.data)
  }
}

// Topic 1
// Topic 2
// Topic 3