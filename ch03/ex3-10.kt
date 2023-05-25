// 3.3.3 when 문과 여럿 중에 하나 선택하기

fun hexDigit(n: Int): Char {
  if (n in 0..9) return '0' + n
  else if (n in 10..15) return 'A' + n - 10
  else return '?'
}


fun hexDigit(n: Int): Char {
  when {
    n in 0..9 -> return '0' + n
    n in 10..15 -> return 'A' + n - 10
    else -> return '?'
  }
}


fun hexDigit(n: Int) = when {
  n in 0..9 -> '0' + n
  n in 10..15 -> 'A' + n - 10
  else -> '?'
}


fun numberDescription(n: Int): String = when {
  n == 0 -> "Zero"
  n == 1 || n == 2 || n == 3 -> "Small"
  n in 4..9 -> "Medium"
  n in 10..100 -> "Large"
  n !in Int.MIN_VALUE until 0 -> "Negative"
  else -> "Huge"
}


fun numberDescription(n: Int, max: Int = 100): String = when (n) {
  0 -> "Zero"
  1, 2, 3 -> "Small"
  in 4..9 -> "Medium"
  in 10..max -> "Large"
  !in Int.MIN_VALUE until 0 -> "Negative"
  else -> "Huge"
}


fun readHexDigit() = when(val n = readLine()!!.toInt()) { // n을 정의
  in 0..9 -> '0' + n
  in 10..15 -> 'A' + n - 10
  else -> '?'
}