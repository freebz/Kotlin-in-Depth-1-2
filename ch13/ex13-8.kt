// 13.2.3 코루틴 디스패치하기

import kotlinx.coroutines.*

fun main() {
  runBlocking {
    // 전역 스레드 풀 디스패치를 사용해 코루틴을 실행한다
    launch(Dispatchers.Default) {
      println(Thread.currentThread().name) // DefaultDispatcher-worker-1
    }
  }
}


import kotlinx.coroutines.*
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.atomic.AtomicInteger

fun main() {
  val id = AtomicInteger(0)

  val executor = ScheduledThreadPoolExecutor(5) { runnable ->
    Thread(
      runnable,
      "WorkerThread-${id.incrementAndGet()}"
    ).also { it.isDaemon = true }
  }

  executor.asCoroutineDispatcher().use { dispatcher ->
    runBlocking {
      for (i in 1..3) {
        launch(dispatcher) {
          println(Thread.currentThread().name)
          delay(1000)
        }
      }
    }
  }
}

// WorkerThread-1
// WorkerThread-2
// WorkerThread-3


import kotlinx.coroutines.*

@Suppress("EXPERIMENTAL_API_USAGE")
fun main() {
  newFixedThreadPoolContext(5, "WorkerThread").use { dispatcher ->
    runBlocking {
      for (i in 1..3) {
        launch(dispatcher) {
          println(Thread.currentThread().name)
          delay(1000)
        }
      }
    }
  }
}


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    println("Root: ${Thread.currentThread().name}")

    launch {
      println("Nested, inherited: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
      println("Nexted, explicit: ${Thread.currentThread().name}")
    }
  }
}

// Root: main
// Nested, explicit: DefaultDispatcher-worker-1
// Nested, inherited: main


import kotlinx.coroutines.*

@Suppress("EXPERIMENTAL_API_USAGE")
fun main() {
  newSingleThreadContext("Worker").use { worker ->
    runBlocking {
      println(Thread.currentThread().name)   // main
      withContext(worker) {
        println(Thread.currentThread().name) // Worker
      }
      println(Thread.currentThread().name)   // main
    }
  }
}