// 13.4.2 동기화와 락

import kotlin.concurrent.thread

fun main() {
  var counter = 0
  val lock = Any()

  for (i in 1..5) {
    thread(isDaemon = false) {
      synchronized(lock) {
        counter += i
        println(counter)
      }
    }
  }
}

// 1
// 4
// 8
// 13
// 15


import kotlin.concurrent.thread

fun main() {
  var counter = 0
  val lock = Any()

  for (i in 1..5) {...} // 앞의 예제에서 본 스레드를 생성하는 부분

  val currentCounter = synchronized(lock) { counter }
  println("Current counter: $currentCounter")
}


import kotlin.concurrent.thread

class Counter {
  private var value = 0
  @Synchronized fun addAndPrint(value: Int) {
    this.value += value
    println(value)
  }
}

fun main() {
  val counter = Counter()
  for (i in 1..5) {
    thread(isDaemon = false) { counter.addAndPrint(i) }
  }
}


class Counter {
  private var value = 0
  private val lock = ReentrantLock()

  fun addAndPrint(value: Int) {
    lock.withLock {
      this.value += value
      println(value)
    }
  }
}


(obj as Object).wait()