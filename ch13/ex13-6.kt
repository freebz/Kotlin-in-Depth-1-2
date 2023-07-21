// 13.2.1 취소

import kotlinx.coroutines.*

suspend fun main() {
  val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
    var i = 1
    while (true) {
      println(i++)
    }
  }

  delay(100) // 자식 잡이 어느 정도 실행될 시간을 준다
  squarePrinter.cancel()
}


import kotlinx.coroutines.*

suspend fun main() {
  val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
    var i = 1
    while (isActive) {
      println(i++)
    }
  }

  delay(100) // 자식 잡이 어느 정도 실행될 시간을 준다
  squarePrinter.cancel()
}


import kotlinx.coroutines.*

suspend fun main() {
  val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
    var i = 1
    while (true) {
      yield()
      println(i++)
    }
  }
  delay(100) // 자식 잡이 어느 정도 실행될 시간을 준다
  squarePrinter.cancel()
}


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val parentJob = launch {
      println("Parent started")

      launch {
        println("Child 1 started")
        delay(500)
        println("Child 1 completed")
      }

      launch {
        println("Child 2 started")
        delay(500)
        println("Child 2 completed")
      }

      delay(500)
      println("Parent completed")
    }

    delay(100)
    parentJob.cancel()
  }
}

// Parent startted
// Child 1 started
// Child 2 started