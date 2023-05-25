// 3.5.2 try 문으로 예외 처리하기

import java.lang.NumberFormatException

fun readInt(default: Int): Int {
  try {
    return readLine()!!.toInt()
  } catch (e: NumberFormatException) {
    return default
  }
}


import java.lang.NumberFormatException

fun readInt(default: Int): Int {
  try {
    return readLine()!!.toInt()
  } catch (e: Exception) {
    return 0
  } catch (e: NumberFormatException) {
    return default // 죽은 코드
  }
}


import java.lang.NumberFormatException

fun readInt(default: Int) = try {
  readLine()!!.toInt()
} catch (e: NumberFormatException) {
  default
}


import java.lang.NumberFormatException

fun readInt(default: Int) = try {
  readLine()!!.toInt()
} finally {
  println("Error")
}