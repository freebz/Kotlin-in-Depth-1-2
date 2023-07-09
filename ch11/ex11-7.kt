// 11.1.6 호출과 인덱스로 원소 찾기

operator fun <K, V> Map<K, V>.invoke(key: K) = get(key)


val map = mapOf("1" to 1, "V" to 5, "X" to 10)
println(map("V")) // 5
println(map("L")) // null


operator fun Rational.Companion.invoke(num: Int, den: Int = 1) =
  of(num, den)


val r = Rational(1, 2)
// invoke() -> of() -> Rational의 비공개 생성자


val array = arrayOf(1, 2, 3)
println(array[0]) // println(array.get(0))과 같음


val array = arrayOf(1, 2, 3)
array[0] = 10 // array.set(0, 10)과 같음


class TreeNode<T>(var data: T) {
  private val _children = arrayListOf<TreeNode<T>>()

  var parent: TreeNode<T>? = null
    private set

  operator fun plusAssign(data: T) {
    val node = TreeNode(data)
    _children += node
    node.parent = this
  }

  operator fun minusAssign(data: T) {
    val index = _children.indexOfFirst { it.data == data }
    if (index < 0) return
    val node = _children.removeAt(index)
    node.parent = null
  }

  operator fun get(index: Int) = _children[index]

  operator fun set(index: Int, node: TreeNode<T>) {
    node.parent?._children?.remove(node)
    node.parent = this
    _children[index].parent = null
    _children[index] = node
  }
}

fun main() {
  val root = TreeNode("Root")

  root += "Child 1"
  root += "Child 2"
  println(root[1].data) // Child 2

  root[0] = TreeNode("Child 3")
  println(root[0].data) // Child 3
}


val array = arrayOf(r(1, 2), r(2, 3))
array[0] += Rational(1, 3)


val array = arrayOf(r(1, 2), r(2, 3))
array[0] = array[0] + r(1, 3)


val array = arrayOf(r(1, 2), r(2, 3))
array.set(0, array.get(0) + r(1, 3))


val array = arrayOf(TreeNode("Root 1"), TreeNode("Root 2"))
array[0] += TreeNode("Child 1")


val array = arrayOf(TreeNode("Root 1"), TreeNode("Root 2"))
array.get(0).plusAssign(TreeNode("Child 1"))