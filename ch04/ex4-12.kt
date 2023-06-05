// 4.3.2 늦은 초기화

import java.io.File

class Content {
  var text: String? = null

  fun loadFile(file: File) {
    text = file.readText()
  }
}

fun getContentSize(content: Content) = content.text?.length ?: 0


import java.io.File

class Content {
  lateinit var text: String

  fun loadFile(file: File) {
    text = file.readText()
  }
}

fun getContentSize(content: Content) = content.text.length


lateinit var text: String

fun readText() {
  text = readLine()!!
}

fun main() {
  readText()
  println(text)
}