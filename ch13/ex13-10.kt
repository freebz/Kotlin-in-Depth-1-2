// 13.3 동시성 통신

// 13.3.1 채널

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
  runBlocking {
    val streamSize = 5
    val channel = Channel<Int>(3)  // 채널 용량 = 3

    launch {
      for (n in 1..streamSize) {
        delay(Random.nextLong(100))
        val square = n*n
        println("Sending: $square")
        channel.send(square)
      }
    }

    launch {
      for (i in 1..streamSize) {
        delay(Random.nextLong(100))
        val n = channel.receive()
        println("Receiving: $n")
      }
    }
  }
}

// Sending: 1
// Receiving: 1
// Sending: 4
// Receiving: 4
// Sending: 9
// Sending: 16
// Receiving: 9
// Sending: 25
// Receiving: 16
// Receiving: 25


// Channel.RENDEZVOUS

// Sending: 1
// Receiving: 1
// Sending: 4
// Receiving: 4
// Sending: 9
// Receiving: 9
// Sending: 16
// Receiving: 16
// Sending: 25
// Receiving: 25


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val streamSize = 5
    val channel = Channel<Int>(Channel.CONFLATED)

    launch {
      for (n in 1..streamSize) {
        delay(100)
        val square = n*n
        println("Sending: $square")
        channel.send(square)
      }
    }

    launch {
      for (i in 1..streamSize) {
        delay(200)
        val n = channel.receive()
        println("Receiving: $n")
      }
    }
  }
}

// Sendig: 1
// Receiving: 1
// Sending: 4
// Sending: 9
// Receiving: 9
// Sending: 16
// Sending: 25
// Receiving: 25


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*

fun main() {
  runBlocking {
    val streamSize = 5
    val channel = Channel<Int>(Channel.CONFLATED)
    launch {
      for (n in 1..streamSize) {
        delay(100)
        val square = n*n
        println("Sending: $square")
        channel.send(square)
      }
      channe.close()
    }
    launch {
      for (n in channel) {
        println("Receiving: $n")
        delay(200)
      }
    }
  }
}


channel.consumeEach {
  println("Receiving: $it")
  delay(200)
}


import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
  runBlocking {
    val streamSize = 5
    val channel = Channel<Int>(2)

    launch {
      for (n in 1..streamSize) {
        val square = n*n
        println("Sending: $square")
        channel.send(square)
      }
      channel.close()
    }

    for (i in 1..3) {
      launch {
        for (n in channel) {
          println("Receiving by consumer #$i: $n")
          delay(Random.nextLong(100))
        }
      }
    }
  }
}

// Sending: 1
// Sending: 4
// Sending: 9
// Receiving by consumer #1: 1
// Receiving by consumer #2: 4
// Receiving by consumer #3: 9
// Sending: 16
// Sending: 25
// Receiving by consumer #3: 16
// Receiving by consumer #1: 25