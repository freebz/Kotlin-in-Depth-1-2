// 5.2.1 확장 함수

fun String.truncate(maxLength: Int): String {
  return if (length <= maxLength) this else substring(0, maxLength)
}


fun main() {
  println("Hello".truncate(10)) // Hello
  println("Hello".truncate(3))  // Hel
}


class Person(val name: String, private val age: Int)

fun Person.showInfo() = println("$name, $age") // Error: can't access age


class Person(val name: String, private val age: Int) {
  // Ok: age에 접근할 수 있음
  fun Person.showInfo() = println("$name, $age")
}


class Person(val name: String, val age: Int)

fun Person.hasName(name: String) = name.equals(this.name,
                                               ignoreCase = true)

fun main() {
  val f = Person("John", 25)::hasName
  println(f("JOHN")) // true
  println(f("JAKE")) // false
}


class Person(val firstName: String, val familyName: String) {
  fun fullName() = "$firstName $familyName"
}

fun Person.fullName() = "$familyName $firstName"

fun main() {
  println(Person("John", "Doe").fullName()) // ???
}


package bad

fun Person.fullName() = "$familyName $firstName"


import bad.fullName


interface Truncated {
  val truncated: String
  val original: String
}

private fun String.truncator(max: Int) = object: Truncated {
  override val truncated
    get() = if (length <= max) this@truncator else substring(0, max)
  
  override val original
    get() = this@truncator
}

fun main() {
  val truncator = "Hello".truncator(3)

  println(truncator.original)  // Hello
  println(truncator.truncated) // Hel
}


// util.kt
package util

fun String.truncate(maxLength: Int): String {
  return if (length <= maxLength) this else substring(0, maxLength)
}

// main.kt
package main

import util.truncate

fun main() {
  println("Hello".truncate(3))
}


fun truncate(s: String, maxLength: Int): String {
  return if (s.length <= maxLength) s else s.substring(0, maxLength)
}


public final class UtilKt {
  public static String truncate(String s, int maxLength) {
    return s.length() <= maxLength
           ? s
           : s.substring(0, maxLength)
  }
}


fun truncate(s: String, maxLength: Int) =
  if (s.length <= maxLength) s else s.substring(0, maxLength)


// 널이 될 수 있는 수신 객체 타입
fun String?.truncate(maxLength: Int): Stirng? {
  if (this == null) return null
  return if (length <= maxLength) this else substring(0, maxLength)
}

fun main() {
  val s = readLine()      // 널이 될 수 있는 문자열
  println(s.truncate(3))  // 여기서 '?.'를 쓰지 않아도 된다.
}