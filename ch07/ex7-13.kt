// 7.2.2 스트림 생성

import java.io.File

fun main() {
  val file = File("data.txt")

  file.bufferedWriter().use { it.write("Hello!") }
  file.bufferedReader().use { println(it.readLine()) } // Hello!
}


file.writer(charset = Charsets.US_ASCII).use { it.write("Hello!") }

File.bufferedReader(
  charset = Charsets.US_ASCII,
  bufferSize = 100
).use { println(it.readLine()) }


import java.io.File

fun main() {
  val file = File("data.bin")
  file.outputStream().use { it.write("Hello!".toByteArray()) }
  file.inputStream().use {
    println(String(it.readAllBytes()))
  } // Hello!
}


println("Hello".byteInputStream().read().toChar())                  // H
println("Hello".byteInputStream(Charsets.US_ASCII).read().toChar()) // H


println("One\nTwo".reader().readLines()) // [One, Two]


println(byteArrayOf(10, 20, 30).inputStream().read())


val bytes = byteArrayOf(10, 20, 30, 40, 50)

println(
  bytes.inputStream(2, 2).readBytes().contentToString()
) // [30, 40]


fun InputStream.reader(
  charset: Charset = Charsets.UTF_8
): InputStreamReader

fun InputStream.bufferReader(
  charset: Charset = Charsets.UTF_8
): bufferedReader

fun InputStream.buffered(
  bufferSize: Int = DEFAULT_BUFFER_SIZE
): BufferedInputStream


import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
  val name = "data.txt"
  FileOutputStream(name).bufferedWriter().use { it.write("One\nTwo") }
  val line = FileInputStream(name).bufferedReader().use {
    it.readLine()
  }

  println(line) // One
}