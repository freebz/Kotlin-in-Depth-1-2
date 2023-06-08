// let 함수

class Address(val city: String, val street: String, val house: String) {
  fun post(message: String) {}
}

fun main() {
  Address("London", "Baker Street", "221b").let {
    // 이 안에서는 it 파라미터를 통해 Address 인스턴스에 접근할 수 있음
    println("To city: ${it.city}")
    it.post("Hello")
  }
}


fun main() {
  Address("London", "Baker Street", "221b").let { addr ->
    // 이 안에서는 addr 파라미터를 통해 Address 인스턴스에 접근할 수 있음
    println("To city: ${addr.city}")
    addr.post("Hello")
  }
}


fun readInt() = try {
  readLine()?.toInt()
} catch (e: NumberFormatException) {
  null
}

fun main(args: Array<String>) {
  val index = readInt()
  val arg = if (index != null) args.getOrNull(index) else null
  if (arg != null) {
    println(arg)
  }
}


val arg = index?.let { args.getOrNull(it) }