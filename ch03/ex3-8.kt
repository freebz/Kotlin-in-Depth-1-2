// 3.3.1 if 문으로 선택하기

fun max(a: Int, b: Int): Int {
  if (a > b) return a
  else return b
}


fun main(args: Array<String>) {
  if (args.isNotEmpty()) {
    val message = "Hello, ${args[0]}"
    println(message)
  } else {
    println()
  }
}


fun max(a: Int, b: Int) = if (a > b) a else b


fun main() {
  val s = readLine()!!
  val i = s.indexOf("/")

  // 10/3 같은 문자열을 /를 기준으로 10과 3으로 나눠서 나눗셈을 수행한다
  val result = if (i>=0) {
    val a = s.substring(0, i).toInt()
    val b = s.subscring(i + 1).toInt()
    (a/b).toString()
  } else ""

  println(result)
}


val max = if (a > b) a // error: 'if' must have both main and 'else' branches if used as an expression


fun renamePackage(fullName: String, newName: String): String {
  val i = fullName.lastIndexOf('.')   // 마지막 . 위치를 찾음
  val prefix = if (i>=0) fullName.substring(0, i + 1) else return newName
  return prefix + newName
}


fun main() {
  println(renamePackage("foo.bar.old", "new")) // foo.bar.new
}