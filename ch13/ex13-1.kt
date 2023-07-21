// 13.1 코루틴

// 13.1.1 코루틴 일시 중단 함수

suspend fun foo() {
  println("Task started")
  delay(100)
  println("Task finished")
}


fun foo() {
  println("Task started")
  delay(100) // error: delay is a suspend function
  println("Task finished")
}


import kotlinx.coroutines.delay

suspend fun main() {
  println("Task started")
  delay(100)
  println("Task finished")
}