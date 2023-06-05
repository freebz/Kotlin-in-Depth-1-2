// 4.3.4 지연 계산 프로퍼티와 위임

import java.io.File

val text by lazy {
  File("data.txt").readText()
}

fun main() {
  while (true) {
    when (val command = readLine() ?: return) {
      "print data" ->println(text)
      "exit" -> return
    }
  }
}


val text = File("data.txt").readText()


val text get() = File("data.txt").readText()


val text: String by lazy { File("data.txt").readText() }


// error: type 'Lazy<String>' has no method 'setValue(Chapter4, KProperty<*>, String)' and thus it cannot serve as a delegate for var (read-write property)
var text by lazy { "Hello" }


fun longComputation(): Int {...}

fun main(args: Array<String>) {
  val date by lazy { longComputation() } // lazy 지역 변수
  val name = args.firstOrNull() ?: return
  println("$name: $data") // name이 널이 아닐 때만 data에 접근할 수 있음
}


fun main() {
  val data by lazy { readLine() }

  if (data != null) {
    // error: smart cast to 'String' is impossible, because 'data' is a property that has open or custom getter
    println("Length: ${data.length}")
  }
}