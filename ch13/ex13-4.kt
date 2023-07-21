// 13.1.4 코루틴 문맥

GlobalScope.launch {
  // 현재 잡을 얻고 "Task is active: true"를 출력
  println("Task is active: ${coroutineContext[Job.Key]!!.isActive}")
}


import kotlinx.coroutines.*

private fun CoroutineScope.showName() {
  println("Current coroutine: ${coroutineContext[coroutineName]?.name}")
}

fun main() {
  runBlocking {
    showName() // Current coroutine: null
    launch(coroutineContext + CoroutineName("Worker")) {
      showName() // Current coroutine: Worker
    }
  }
}