// 13.3.3 티커

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
  val ticker = ticker(100)
  println(withTimeoutOrNull(50) { ticker.receive() })
  println(withTimeoutOrNull(60) { ticker.receive() })
  delay(250)
  println(withTimeoutOrNull(1) { ticker.receive() })
  println(withTimeoutOrNull(60) { ticker.receive() })
  println(withTimeoutOrNull(60) { ticker.receive() })
}

// FIXED_PERIOD

// null
// kotlin.Unit
// kotlin.Unit
// kotlin.Unit
// null


// FIXED_RATE

// null
// kotlin.Unit
// kotlin.Unit
// null
// kotlin.Unit