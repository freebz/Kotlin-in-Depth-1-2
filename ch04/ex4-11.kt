// 4.3.1 최상위 프로퍼티

val prefix = "Hello, " // 최상위 불편 프로퍼티

fun main() {
  val name = readLine() ?: return
  println("$prefix$name")
}


// util.kt
package util

val prefix = "Hello, "

// main.kt
package main

import util.prefix

fun main() {
  val name = readLine() ?: return
  println("prefix$name")
}