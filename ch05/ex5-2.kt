// 5.1.2 함수 타입

result = op.invoke(result, numbers[i])


import java.util.funciton.Consumer;

public class Main {
  public static void main(String[] args) {
    Consumer<String> consume = s ->System.out.println(s);
    consume.accept("Hello");
  }
}


import java.util.function.Consumer

fun main() {
  // Error: type mismatch
  val consume: Consumer<String> = { s ->println(s) }
  consume.accept("Hello")
}


fun interface StringConsumer {
  fun accept(s:String)
}

fun main() {
  val consume = StringConsumer { s -> println(s) }

  consume.accept("Hello")
}


fun measureTime(action: () -> Unit): Long {
  val start = System.nanoTime()

  action()

  return System.nanoTime() - start
}


val inc: (Int) -> Int = { n -> n + 1 }  // Ok
val dec: Int -> Int = { n -> n - 1 }   // Error


fun main() {
  val lessThan: (Int, Int) -> Boolean = { a, b -> a < b }
  println(lessThan(1, 2)) // true
}


val lessThan = { a, b -> a < b } // error: cannot infer a type for this parameter. Please specify it explicity.


val lessThan = { a: Int, b: Int -> a < b } // Ok


fun measureTime(action: (() -> Unit)?): Long {
  val start = System.nanoTime()

  action?.invoke()

  return System.nanoTime() - start
}

fun main() {
  println(measureTime(null))
}


fun main() {
  val shifter: (Int) -> (Int) -> Int = { n -> { i ->i + n } }

  val inc = shifter(1)

  val dec = shifter(-1)

  println(inc(10)) // 11
  println(dec(10)) // 9
}


fun main() {
  val evalAtZero: ((Int) -> (Int)) -> Int = { f -> f(0) }

  println(evalAtZero { n -> n + 1 }) // 1
  println(evalAtZero { n -> n - 1 }) // -1
}


fun aggregate(
  numbers: IntArray,
  op: (resultSoFar: Int, nextValue: Int) -> Int
): Int {...}