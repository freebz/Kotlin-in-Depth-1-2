// 5.1.4 호출 가능 참조

fun check(s: String, condition: (Char) -> Boolean): Boolean {
  for (c in s) {
    if (!condition(c)) return false
  }

  return true
}

fun isCapitalLetter(c: Char) = c.isUpperCase() && c.isLetter()

fun main() {
  println(check("Hello") { c -> isCapitalLetter(c) }) // false
  // 또는
  println(check("Hello") { isCapitalLetter(it) }) // false
}


fun main() {
  println(check("Hello", ::isCapitalLetter)) // false
}


fun evalAtZero(f: (Int) -> Int) = f(0)

fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

fun main() {
  fun dec(n: Int) = n - 1
  println(evalAtZero(::inc)) // 1
  println(evalAtZero(::dec)) // -1
}


class Person(val firstName: String, val familyName: String)

fun main() {
  val createPerson= ::Person
  createPerson("John", "Doe")
}


class Person(val firstName: String, val familyName: String) {
  fun hasNameOf(name: String) = name.equals(firstName,
                                            ignoreCase = true)
}

fun main() {
  val isJohn = Person("John", "Doe")::hasNameOf

  println(isJohn("JOHN")) // true
  println(isJohn("Jake")) // false
}


fun max(a: Int, b: Int) = if (a > b) a else b
fun max(a: Double, b: Double) = if (a > b) a else b

val f: (Int, Int) -> Int = ::max // Ok
val g = ::max                    // error: overload resolution ambiguity


fun max(a: Int, b: Int) = if (a > b) a else b

fun main() {
  println((::max)(1, 2)) // 2
  println(::max(1, 2))   // error: this syntax is reserved for future use
}


class Person(var firstName: String, var familyName: String)

fun main() {
  val person = Person("John", "Doe")
  val readName = person::firstName.getter      // 게터 참조
  val writeFamily = person::familyName.setter  // 세터 참조

  println(readName())        // John
  writeFamily("Smith")
  println(person.familyName) // Smith
}