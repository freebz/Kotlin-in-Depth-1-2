// 4.2.5 엘비스 연산자

fun sayHello(name: String?) {
  println("Hello, " + (name ?: "Unknown"))
}

fun main() {
  sayHello("John") // Hello, Jhon
  sayHello(null)   // Hello, Unknown
}


fun sayHello(name: String?) {
  println("Hello, " + (if (name != null) name else "Unknown"))
}


val n = readLine()?.toInt() ?: 0


class Name(val firstName: String, val familyName: String?)

class Person(val name: Name?) {
  fun describe(): String {
    val currentName = name ?: return "Unknown"
    return "${currentName.firstName} ${currentName.familyName}"
  }
}

fun main() {
  println(Person(Name("John", "Doe")).describe()) // John Doe
  println(Person(null).describe()) // Unknown
}