// 7.2.5 파일 시스템 유틸리티

import java.io.File

fun main() {
  File("my/nested/dir").mkdirs()
  val root = File("my")

  println("Dir exists: ${root.exists()}")                  // true
  println("Simple delete: ${root.delete()}")               // false
  println("Dir exists: ${root.exists()}")                  // true
  println("Recursive delete: ${root.deleteRecursively()}") // true
  println("Dir exists: ${root.exists()}")                  // false
}


import java.io.File

fun main() {
  val source = File("data.txt")
  source.writeText("Hello")

  val target = source.copyTo(File("dataNew.txt"))
  println(target.readText()) // Hello
}


import java.io.File

fun main() {
  val source = File("data.txt").also { it.writeText("One") }
  val target = File("dataNew.txt").also { it.writeText("Two") }
  source.copyTo(target, overwrite = true)
  println(target.readText()) // One
}


import java.io.File

fun main() {
  File("old/dir").mkdirs()
  File("old/dir/data1.txt").also { it.writeText("One") }
  File("old/dir/data2.txt").also { it.writeText("Two") }

  File("old").copyRecursively(File("new"))

  println(File("new/dir/data1.txt").readText()) // One
  println(File("new/dir/data2.txt").readText()) // Two
}


File("old").copyRecursively(File("new")) { file, ex -> OnErrorAction.SKIP }


import java.io.File
import kotlin.io.FileWalkDirection.*

fun main() {
  File("my/dir").mkdirs()
  File("my/dir/data1.txt").also { it.writeText("One") }
  File("my/dir/data2.txt").also { it.writeText("Two") }

  println(File("my").walk().map { it.name }.toList())
  println(File("my").walk(TOP_DOWN).map { it.name }.toList())
  println(File("my").walk(BOTTOM_UP).map { it.name }.toList())
}


println(
  File("my").walk().maxDepth(1).map { it.name }.toList()
) // [my, dir]


println(
  File("my")
    .walk()
    .onEnter { it.name != "dir" }
    .onLeave { println("Processed: ${it.name}") }
    .map { it.name }
    .toList())


val tmpDir = createTempDir(prefix = "data")
val tmpFile = createTempFile(directory = tmpDir)


fun createTempDir(
  prefix: String = "tmp",
  suffix: String? = null,
  directory: File? = null
): File