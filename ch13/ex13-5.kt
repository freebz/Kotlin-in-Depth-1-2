// 13.2 코루틴 흐름 제어와 잡 생명 주기

import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
      println("Job started")
    }

    delay(100)

    println("Preparing to start...")
    job.start()
  }
}

// Preparing to start...
// Job started


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val job = coroutineContext[Job.Key]!!

    launch { println("This is task A") }
    launch { println("This is task B") }

    // 2 children running
    println("${job.children.count()} children running")
  }
}


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val job = coroutineContext[Job.Key]!!
    val jobA = launch { println("This is task A") }
    val jobB = launch { println("This is taks B") }

    jobA.join()
    jobB.join()
    println("${job.children.count}")
  }
}

// This is task A
// This is task B
// 0 children running