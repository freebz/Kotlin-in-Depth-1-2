// 12.1.7 단일 추상 메서드 인터페이스

public interface Runnable {
  public void run();
}


import java.util.concurrent.ScheduledThreadPoolExecutor

fun main() {
  val executor = ScheduledThreadPoolExecutor(5)

  executor.execute {
    println("Working on asynchronous task...")
  }
  executor.shutdown()
}


import java.util.concurrent.ScheduledThreadPoolExecutor

fun main() {
  val executor = ScheduledThreadPoolExecutor(5)

  executor.execute(object: Runnable {
    override fun run() {
      println("Working on asynchronous task...")
    }
  })
  executor.shutdown()
}


public interface Callable<V> {
  V call() throws Exception;
}


import java.util.concurrent.ScheduledThreadPoolExecutor

fun main() {
  val executor = ScheduledThreadPoolExecutor(5)
  // 암시적으로 Runnable로 변환됨
  val future = executor.submit { 1 + 2 }

  println(future.get()) // null
  executor.shutdown()
}


import java.util.concurrent.Callable
import java.util.concurrent.ScheduledThreadPoolExecutor
fun main() {
  val executor = ScheduledThreadPoolExecutor(5)
  val future = executor.submit(Callable { 1 + 2})

  println(future.get()) // 3
  executor.shutdown()
}


fun interface SomeCallback {
  fun execute(arg: Any): Unit
}


fun callWithString(arg: String, callback: SomeCallback) = callback.execute(arg)

fun main() {
  callWithString("World!"){println("Hello,$it")}  // Hello, World!
}