// 4.4.3 객체 식

fun main() {
  fun midPoint(xRange: IntRange, yRange: IntRange) = object {
    val x = (xRange.first + xRange.last)/2
    val y = (yRange.first + yRange.last)/2
  }

  val midPoint = midPoint(1..5, 2..6)

  println("${midPoint.x}, ${midPoint.y}") // (3, 4)
}


fun printMiddle(xRange: IntRange, yRange: IntRange) {
  // error: named object 'MidPoint' is a singleton and cannot be local. Try to use anonymous object instead
  object MidPoint {
    val x = (xRange.first + xRange.last)/2
    val y = (yRange.first + yRange.last)/2
  }

  println("${MidPoint.x}, ${MidPoint.y}")
}


fun main() {
  val o = object { // 익명 객체 타입이 추론됨
    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()
  }
  println(o.x + o.y) // 여기서 o 안의 x와 y에 접근할 수 있음
}


fun midPoint(xRange: IntRange, yRange: IntRange) = object {
  val x = (xRange.first + xRange.last)/2
  val y = (yRange.first + yRange.last)/2
}

fun main() {
  val midPoint = midPoint(1..5, 2..6)
  // error: unresolved reference: x
  // error: unresolved reference: y
  println("${midPoint.x}, ${midPoint.y}")
}


fun main() {
  var x = 1

  val o = object {
    fun change() {
      x = 2
    }
  }

  o.change()
  println(x) // 2
}


fun main() {
  var x = 1

  val o = object {
    val a = x++;
  }

  println("o.a = ${o.a}") // o.a = 1
  println("x = $x")
}