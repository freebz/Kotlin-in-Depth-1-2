// 5.1.6 비지역적 제어 흐름

fun forEach(a: IntArray, action: (Int) -> Unit) {
  for (n in a) action(n)
}

fun main() {
  forEach(intArrayOf(1, 2, 3, 4)) {
    if (it < 2 || it > 3) return
    println(it) // Error
  }
}


fun main() {
  forEach(intArrayOf(1, 2, 3, 4), fun(it: Int) {
    if (it < 2 || it > 3) return
    println(it)
  })
}


val action: (Int) -> Unit = myFun@ {
  if (it < 2 || it > 3) return@myFun
  println(it)
}


forEach(intArrayOf(1, 2, 3, 4)) {
  if (it < 2 || it > 3) return@forEach
  println(it)
}


fun main(args: Array<String>) {
  if (args.isEmpty()) return@main
  println(args[0])
}


inline fun forEach(a: IntArray, action: (Int) -> Unit) { ... }

fun main() {
  forEach(intArrayOf(1, 2, 3, 4)) {
    if (it < 2 || it > 3) return // main에서 반환됨
    println(it)
  }
}


inline fun forEach(a: IntArray, action: (Int) -> Unit) = object {
  fun run() {
    for (n in a) {
      action(n) // Error
    }
  }
}


inline fun forEach(
  a: IntArray, crossinline action: (Int) -> Unit
) = object {
  fun run() {
    for (n in a) {
      action(n) // Ok
    }
  }
}

fun main() {
  forEach(intArrayOf(1, 2, 3, 4)) {
    if (it < 2 || it > 3) return // Error
    println(it)
  }
}


while (true) {
  forEach(intArrayOf(1, 2, 3, 4)) {
    if (it < 2 || it > 3) break // Error
    println(it)
  }
}