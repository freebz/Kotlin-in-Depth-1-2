// 13.1.2 코루틴 빌더

import kotlinx.coroutines.*
import java.lang.System.*

fun main() {   // main이 suspend 함수가 아님에 유의
  val time = currentTimeMillis()

  GlobalScope.launch {
    delay(100)
    println("Task 1 finished in ${currentTimeMillis() - time} ms")
  }

  GlobalScope.launch {
    delay(100)
    println("Task 2 finished in ${currentTimeMillis() - time} ms")
  }

  Thread.sleep(200)
}

// Task 2 finished in 176 ms
// Task 1 finished in 176 ms


import kotlinx.coroutines.*

suspend fun main() {
  val message = GlobalScope.async {
    delay(100)
    "abc"
  }

  val count = GlobalScope.async {
    delay(100)
    1 + 2
  }

  delay(200)

  val result = message.await().repeat(count.await())
  println(result)
}

// abcabcabc


import kotlinx.coroutines.*

fun main() {
  GlobalScope.launch {
    delay(100)
    println("Background task: ${Thread.currentThread().name}")
  }
  runBlocking {
    println("Primary task: ${Thread.currentThread().name}")
    delay(200)
  }
}

// Primary task: main
// Background task: DefaultDispatcher-worker-1