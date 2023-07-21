// 13.2.4 예외 처리

import kotlinx.coroutines.*

fun main() {
  runBlocking {
    launch {
      throw Exception("Error in task A")
      println("Task A completed")
    }

    launch {
      delay(1000)
      println("Task B completed")
    }

    println("Root")
  }
}

// Root
// Exception in thread "main" java.lang.Exception: Error in task A


fun handleException(context: CoroutineContext, exception: Throwable)


val handler = CoroutineExceptionHandler{ _, exception ->
  println("Caught $exception")
}


import kotlinx.coroutines.*

suspend fun main() {
  val handler = CoroutineExceptionHandler{ _, exception ->
    println("Caught $exception")
  }

  GlobalScope.launch(handler) {
    launch {
      throw Exception("Error in task A")
      println("Task A completed")
    }

    launch {
      delay(1000)
      println("Task B completed")
    }

    println("Root")
  }.join()
}

// Root
// Caught java.lang.Exception: Error in task A


import kotlinx.coroutines.*

fun main() {
  val handler = ...
  runBlocking(handler) {
    ...
  }
}


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val deferredA = async {
      throw Exception("Error in task A")
      println("Task A completed")
    }
    val deferredB = async {
      println("Task B completed")
    }
    deferredA.await()
    deferredB.await()
    println("Root")
  }
}

// Exception in thread "main" java.lang.Exception: Error in task A


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val deferredA = async {
      throw Exception("Error in task A")
      println("Task A completed")
    }

    val deferredB = async {
      println("Task B completed")
    }

    try {
      deferredA.await()
      deferredB.await()
    } catch (e: Exception) {
      println("Caught $e")
    }
    println("Root")
  }
}

// Caught java.lang.Exception: Error in task A
// Root
// Exception in thread "main" java.lang.Exception: Error in task A


import kotlinx.coroutines.*

fun main() {
  runBlocking {
    supervisorScope {
      val deferredA = async {
        throw Exception("Error in task A")
        println("Task A completed")
      }

      val deferredB = async {
        println("Task B completed")
      }

      try {
        deferredA.await()
      } catch (e: Exception) {
        println("Caught $e")
      }
      deferredB.await()
      println("Root")
    }
  }
}

// Task B completed
// Caught java.lang.Exception: Error in task A
// Root