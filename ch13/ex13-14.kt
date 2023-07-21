// 13.4 자바 동시성 사용하기

// 13.4.1 스레드 시작하기

import kotlin.concurrent.thread

fun main() {
  println("Starting a thread...")

  thread(name = "Worker", isDaemon = true) {
    for (i in 1..5) {
      println("${Thread.currentThread().name}: $i")
      Thread.sleep(150)
    }
  }

  Thread.sleep(500)
  println("Shutting down...")
}

// Starting a thread...
// Worker: 1
// Worker: 2
// Worker: 3
// Worker: 4
// Shutting down...


import kotlin.concurrent.timer

fun main() {
  println("Starting a thread...")
  var counter = 0

  timer(period = 150, name = "Worker", daemon = true) {
    println("${Thread.currentThread().name}: ${++counter}")
  }

  Thread.sleep(500)
  println("Shutting down...")
}