// 7.2 파일과 I/O 스트림

// 7.2.1 스트림 유틸리티

fun InputStream.readBytes(): ByteArray
fun Reader.readText(): String
fun Reader.readLines(): List<String>


import java.io.*

fun main() {
  FileWriter("data.txt").use { it.write("One\nTwo\nThree") }

  // One
  FileReader("data.txt").buffered().use { println(it.readLine()) }

  // One Two Three
  FileReader("data.txt").use { println(it.readText().replace('\n', ' ')) }

  // [One, Two, Three]
  println(FileReader("data.txt").readLines())
}


FileInputStream("data.bin").buffered().use {
  var sum = 0
  for (byte in it) sum += byte
}


FileReader("data.bin").buffered().use {
  for (line in it.lineSequence()) println(line)
}


import java.io.*

fun main() {
  FileWriter("data.txt").use { it.write("One\nTwo\nThree") }

  // One, Two, Three
  FileReader("data.txt").useLines { println(it.joinToString()) }

  // One/Two/Three/
  FileReader("data.txt").forEachLine { println("$it/") }
}


fun InputStream.copyTo(
  out: OutputStream,
  bufferSize: Int = DEFAULT_BUFFER_SIZE
): Long

fun Reader.copyTo(out: Writer,
  bufferSize: Int = DEFAULT_BUFFER_SIZE): Long


import java.io.*

fun main() {
  FileWriter("data.txt").use { it.write("Hello") }

  val writer = StringWriter()
  FileReader("data.txt").use { it.copyTo(writer) }
  println(writer.buffer)            // Hello

  val output = ByteArrayOutputStream()
  FileInputStream("data.txt").use { it.copyTo(output) }
  println(output.toString("UTF-8")) // Hello
}


val lines = FileReader("data.bin").use { it.readLines() }


val reader = FileReader("data.bin")

val lines = try {
  reader.readLines()
} finally {
  reader.close()
}