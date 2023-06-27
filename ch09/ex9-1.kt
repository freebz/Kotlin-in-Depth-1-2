// 9.1 타입 파라미터

// 9.1.1 제네릭 선언

val map = HashMap<Int, String>()
val list = arrayListOf<String>()


// map의 타입을 명시했기 때문에 HashMap 클래스의 타입 인자를 추론할 수 있음
val map: Map<Int, String> = HashMap()

// arrayListOf()에 전달된 인자의 타입(모두 String)으로부터 타입 인자를 추론할 수 있음
val list = arrayListOf("abc", "def")


Map<Int, String> map = new HashMap<>() // new HashMap()이 아님!!


class TreeNode<T>(val data: T) {
  private val _children = arrayListOf<TreeNode<T>>()
  var parent: TreeNode<T>? = null
  private set

  val children: List<TreeNode<T>> get() = _children

  fun addChild(data: T) = TreeNode(data).also {
    _children += it
    it.parent = this
  }

  override fun toString() =
    _children.joinToString(prefix = "$data {", postfix = "}")
}

fun main() {
  val root = TreeNode("Hello").apply {
    addChild("World")
    addChild("!!!")
  }

  println(root) // Hello {World {}, !!! {}}
}


open class DataHolder<T>(val data: T)

// 실제 타입을 상위 타입의 타입 인자로 넘김
class StringDataHolder(data: String) : DataHolder<String>(data)

// 타입 인자를 상위 타입의 타입 인자로 넘김
class TreeNode<T>(data: T) : DataHolder<T>(data) { ... }


// error: one type argument expected for class DataHolder<T>
class StringDataHolder(data: String) : DataHolder(data)

// Ok: DataHolder<String>을 컴파일러가 추론함
fun stringDataHolder(data: String) = DataHolder(data)


class TreeNode<U>(data: U) : DataHolder<U>(data) { ... }


fun <T> TreeNode<T>.addChildren(vararg data: T) {
  data.forEach { addChild(it) }
}

fun <T> TreeNode<T>.walkDepthFirst(action: (T) -> Unit) {
  children.forEach { it.walkDepthFirst(action) }
  action(data)
}

val <T> TreeNode<T>.depth: Int
  get() = (children.asSequence().map { it.depth }.maxOrNull() ?: 0) + 1

fun main() {
  val root = TreeNode("Hello").apply {
    addChildren("World", "!!!")
  }

  println(root.depth) // 2
}


// error: type parameter of a property must be used in its receiver type
var <T> root: TreeNode<T>? = null


object EmptyTree<T> // error: type parameters are not allowed for objects


// error: expression 'depth' of type 'Int' cannot be invoked as a function.
val minDepth = TreeNode("").depth<String>

// error: type parameter of a property must be used in its receiver type
val <T> TreeNode<String>.upperCaseDataget() = data.toUpperCase()