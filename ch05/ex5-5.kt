// 5.1.5 인라인 함수와 프로퍼티

inline fun indexOf(numbers: IntArray, condition: (Int) -> Boolean): Int {
  for (i in numbers.indices) {
    if (condition(numbers[i])) return i
  }

  return -1
}

fun main() {
  println(indexOf(intArrayOf(4, 3, 2, 1)) { it < 3 }) // 2
}


fun main() {
  val numbers = intArrayOf(4, 3, 2, 1)
  var index = -1

  for (i in numbers.indices) {
    if (numbers[i] < 3) {
      index = i
      break
    }
  }

  println(index)
}


var lastAction: () -> Unit = {}

inline fun runAndMemorize(action: () -> Unit) {
  action()
  lastAction = action // Error
}


inline fun forEach(a: IntArray, action: ((Int) -> Unit)?) { // Error
  if (action == null) return
  for (n in a) action(n)
}


inline fun forEach(a: IntArray, noinline action: ((Int) -> Unit)?) {
  if (action == null) return
  for (n in a) action(n)
}


class Person(private val firstName: String,
             private val familyName: String) {
  inline fun sendMessage(message: () -> String) {
    println("$firstName $familyName: ${message()}") // Error
  }
}


class Person(var firstName: String, var familyName: String) {
  var fullName
  inline get() = "$firstName $familyName"  // inline 게터
  set(value) { ... }                       // inline이 아닌 세터
}


class Person(var firstName: String, var familyName: String) {
  inline var fullName // inline 게터와 세터
    get() = "$firstName $familyName"
    set(value) { ... }
}


class Person(private val firstName: String,
             private val familyName: String) {

  inline var age = 0 // Error: property has a backing field
  // Error: firstName and familyName are private
  inline val fullName get() = "$firstName $familyName"
}