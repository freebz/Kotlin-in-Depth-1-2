// 8.1.3 타입 검사와 캐스팅

val objects = arrayOf("1", 2, "3", 4)


for (obj in objects) {
  println(obj*2) // error: unresolved reference
}


for (obj in objects) {
  println(obj is Int)
}


println(null is Int)     // false
println(null is String?) // true


val o: Any = ""
println(o !is Int)    // true
println(o !is String) // false


println(12 is String) // error: incompatible types: String and Int


val objects = arrayOf("1", 2, "3", 4)

var sum = 0

for (obj in objects) {
  if (obj is Int) {
    sum += obj // 여기서는 obj의 타입을 'Int'로 세분화한다
  }
}
println(sum) // 6


val objects = arrayOf("1", 2, "3", 4)
var sum = 0

for (obj in objects) {
  when (obj) {
    is Int -> sum += obj              // 여기서 obj는 Int 타입이다
    is String -> sum += obj.toInt()   // 여기서 obj는 String 타입이다.
  }
}
println(sum) // 10


class Holder {
  val o: Any get() = ""
}

fun main() {
  val o: Any by lazy { 123 }

  if (o is Int) {
    println(o*2)              // error: smart cast to 'Int' is impossible
  }

  val holder = Holder()

  if (holder.o is String) {
    println(holder.o.length)  // error: smart cast to 'String' is impossible
  }
}


open class Holder {
  open val o: Any = ""
}

fun main() {
  val holder = Holder()
  if (holder.o is String) {
    println(holder.o.length) // error: smart cast to 'String' is impossible
  }
}


fun main() {
  var o: Any = 123
  if (o is Int) {
    println(o + 1)     // Ok: Int로 스마트 캐스트
    o = ""
    println(o.length)  // Ok: String으로 스마트 캐스트
  }
  if (o is String) {
    val f = { o = 123 }
    println(o.length)  // Error: 스마트 캐스트 불가능
  }
}


val o: Any = 123
println((o as Int) + 1)               // 124
println((o as? Int)!! + 1)            // 124
println((o as? String ?: "").length)  // 0
println((o as String).length)         // java.lang.ClassCastException


val o: Any = 123
println(o as? String) // null
println(o as String?) // java.lang.ClassCastException


println(null as String) // java.lang.NullPointerException