// 7.2.4 파일 콘텐츠 접근하기

import java.io.File

fun main() {
  val file = File("data.txt")

  file.writeText("One")
  println(file.readText()) // One

  file.appendText("\nTwo")
  println(file.readLines()) // [One, Two]

  file.writeText("Three")
  println(file.readLines()) // [Three]
}


import java.io.File

fun main() {
  val file = File("data.bin")

  file.writeBytes(byteArrayOf(1, 2, 3))
  println(file.readBytes().contentToString()) // [1, 2, 3]

  file.appendBytes(byteArrayOf(4, 5))
  println(file.readBytes().contentToString()) // [1, 2, 3, 4, 5]

  file.writeBytes(byteArrayOf(6, 7))
  println(file.readBytes().contentToString()) // [6, 7]
}


import java.io.File

fun main() {
  val file = File("data.txt")

  file.writeText("One\nTwo\nThree")
  file.forEachLine { print("/$it") } // /One/Two/Three
}


import java.io.File

fun main() {
  val file = File("data.txt")

  file.writeText("One\nTwo\nThree")
  println(file.useLines { lines ->lines.count { it.length> 3 } }) // 1
}


import java.io.File

fun main() {
  val file = File("data.bin")
  var sum = 0

  file.forEachBlock { buffer, bytesRead ->
    (0 until bytesRead).forEach { sum += buffer[it] }
  }
  println(sum)
}