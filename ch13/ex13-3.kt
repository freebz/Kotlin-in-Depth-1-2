// 13.1.3 코루틴 영역과 구조적 동시성

import kotlinx.coroutines.*

fun main() {
  runBlocking {
    println("Parent task started")

    launch {
      println("Task A started")
      delay(200)
      println("Task A finished")
    }

    launch {
      println("Task B started")
      delay(200)
      println("Task B finished")
    }

    delay(100)
    println("Parent task finished")
  }
  println("Shutting down...")
}

// Parent task started
// Task A started
// Task B started
// Parent task finished
// Task A finished
// Task B finished
// Shutting down...


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    println("Custom scope start")

    coroutineScope {
      launch {
        delay(100)
        println("Task 1 finished")
      }

      launch {
        delay(100)
        println("Task 2 finished")
      }
    }

    println("Custom scope end")
  }
}