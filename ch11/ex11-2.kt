// 11.1.1 단항 연산

enum class Color {
  BLACK, RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE;
}


enum class Color {
  BLACK, RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE;

  operator fun not() = when (this) {
    BLACK -> WHITE
    RED -> CYAN
    GREEN -> MAGENTA
    BLUE -> YELLOW
    YELLOW -> BLUE
    CYAN -> RED
    WHITE -> BLACK
  }
}

fun main() {
  println(!Color.RED) // CYAN
  println(!Color.CYAN) // RED
}


operator fun <T> ((T) -> Boolean).not(): (T) -> Boolean = { !this(it) }


fun isShort(s: String) = s.length <= 4
fun String.isUpperCase() = all { it.isUpperCase() } // 역주 참조

fun main() {
  val data = listOf("abc", "abcde", "ABCDE", "aBcD", "ab")

  println(data.count(::isShort)) // 3
  println(data.count(!::isShort)) // 2
  println(data.count(String::isUpperCase)) // 1
  println(data.count(!String::isUpperCase)) // 4
}