// 4.2.2 널 가능성과 스마트 캐스트

fun isLetterString(s: String?): Boolean {
  if (s == null) return false

  // s는 여기서 널이 될 수 없다
  if (s.isEmpty()) return false

  for (ch in s) {
    if (!ch.isLetter()) return false
  }

  return true
}


fun describeNumber(n: Int?) = when (n) {
  null -> "null"
  // 아래에 있는 가지에서 n은 널이 될 수 없다
  in 0..10 -> "small"
  in 11..100 -> "large"
  else -> "out of range"
}


fun isSingleChar(s: String?) = s != null && s.length == 1


var s = readLine() // String?
if (s != null) {
  s = readLine()
  // 변수 값이 바뀌므로 스마트 캐스트를 쓸 수 없음
  // error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
  println(s.length)
}