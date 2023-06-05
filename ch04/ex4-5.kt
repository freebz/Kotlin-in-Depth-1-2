// 4.1.5 지역 클래스

fun main() {
  class Point(val x: Int, val y: Int) {
    fun shift(dx: Int, dy: Int): Point = Point(x + dx, y + dy)
    override fun toString() = "($x, $y)"
  }
  val p = Point(10, 10)
  println(p.shift(-1, 3)) // (9, 13)
}

fun foo() {
  println(Point(0, 0)) // error: unresolved reference: Point
}


fun main() {
  var x = 1

  class Counter {
    fun increment() {
      x++
    }
  }

  Counter().increment()

  println(x) // 2
}


import kotlin.jvm.internal.Ref.IntRef;

class MainKt {
  public static void main(String[] args) {
    final IntRef x = new IntRef(); // 래퍼 생성
    x.element = 1;

    final class Counter {
      public final void increment() {
        x.element++; // 공유된 데이터 변경하기
      }
    }

    (new Counter()).increment();

    System.out.println(x.element); // 공유된 데이터 읽기
  }
}


fun main(args: Array<String>) {
  class Foo {
    val length = args.size
    inner class Bar {
      val firstArg = args.firstOrNull()
    }
  }
}