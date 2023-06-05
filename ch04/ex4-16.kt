// 4.4.2 동반 객체

class Application private constructor(val name: String) {
  object Factory {
    fun create(args: Array<String>): Application? {
      val name = args.firstOrNull() ?: return null
      return Application(name)
    }
  }
}

fun main(args: Array<String>) {
  // 직접 생성자를 호출하도록 허용하지 않음
  // val app = Application(name)
  val app = Application.Factory.create(args) ?: return
  println("Application started: ${app.name}")
}


class Application private constructor(val name: String) {
  companion object Factory {
    fun create(args: Array<String>): Application? {
      val name = args.firstOrNull() ?: return null
      return Application(name)
    }
  }
}

fun main(args: Array<String>) {
  val app = Application.create(args) ?: return
  println("Application started: ${app.name}")
}


val app = Application.Factory.create(args) ?: return


class Application private constructor(val name: String) {
  companion object {
    fun create(args: Array<String>): Application? {
      val name = args.firstOrNull() ?: return null
      return Application(name)
    }
  }
}


import Application.Companion.create // Ok
import Application.create           // Error


class Application {
  companion object Factory
  // error: only one companion object is allowed per class
  companion object Utils
}