// 7.1 컬렉션

// 7.1.1 컬렉션 타입

val list = listOf("red", "green", "blue") // Create new list

for (item in list) {
  print(item + " ")
} // red green blue 출력함


val list = ArrayList<String>()
list.add("abc")             // Ok: 컬렉션 데이터를 변경
list = ArrayList<String>()  // error: val cannot be reassigned


fun processCollection(c: Iterable<Any>) {...}

fun main() {
  val list = listOf("a", "b", "c") // List<String>
  processCollection(list)          // Ok: List<String>을 List<Any>로 전달
}


fun processCollection(c: MutableCollection<Any>) { c.add(123) }

fun main() {
  val list = arrayListOf("a", "b", "c") // ArrayList<String>
  processCollection(list)               // 컴파일이 되면 문제가 생기는 코드!!!
}