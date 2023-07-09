// 11.1.5 대입

var numbers = listOf(1, 2, 3)
numbers += 4
println(numbers) // [1, 2, 3, 4]


val numbers = mutableListOf(1, 2, 3)
numbers += 4
println(numbers) // [1, 2, 3, 4]


var numbers = mutableListOf(1, 2, 3)
// 변수에 저장된 참조를 바꿔야 할까, 객체 내부를 바꿔야 할까?
numbers += 4 // Error
println(numbers)


// 11장 앞에서 정의한 Rational 객체와 r 함수 정의를 여기에 포함시켜야 함

var r = r(1, 2) // 1/2

// r = r + r(1, 3)과 같음
r += r(1, 3)    // 1/2 + 1/3

println(r)      // 5/6


class TreeNode<T>(val data: T) {
  private val _children = arrayListOf<TreeNode<T>>()

  var parent: TreeNode<T>? = null
    private set

  // 복합 대입 연산자 함수들
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

  // -=의 동작을 확인하기 위해 단순 이항 연산자 함수를 정의함
  operator fun minus(data: T):TreeNode<T> = TODO("Comming soon")

  override fun toString() =
    _children.joinToString(prefix = "$data {", postfix = "}")
}


val tree = TreeNode("root")
tree += "child 1"             // plus()가 없어도 복합 대입 연산이 적용됨
tree += "child 2"
println(tree) // root {child1 {}, child 2 {}}

tree -= "child 2"
println(tree) // root {child1 {}}   // minus()가 없지만 복합 대입 연산 쪽이 적용됨