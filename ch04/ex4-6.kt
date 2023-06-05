// 4.2.1 널이 될 수 있는 타입

fun isLetterString(s: String): Boolean {
  if (s.isEmpty()) return false
  for (ch in s) {
    if (!ch.isLetter()) return false
  }
  return true
}


fun main() {
  println(isLetterString("abc")) // Ok
  // error: null can not be a value of a non-null type String
  println(isLetterString(null)) 
}


class Test {
  static booleanisLetterString(String s) {
    for (int i = 0; i<s.length; i++) {
      if (!Character.isLetter(s.charAt(i))) return false;
    }
    return true;
  }
  public static void main(String[] args) {
    // 컴파일은 되지만 런타임에 예외가 발생한다
    System.out.println(isEmpty(null))
  }
}


fun isBooleanString(s: String?) = s == "false" || s == "true"


fun main() {
  println(isBooleanString(null)) // Ok
  val s: String? = "abc"         // Ok
  // error: type mismatch: inferred type is String? but String was expected
  val ss: String = s
}


fun main() {
  val n: Int = 1  // 원시 타입의 값
  val x: Int? = 1 // 박싱한 타입의 값을 참조
}


fun isLetterString(s: String?): Boolean {
  // error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
  if (s.isEmpty()) return false

  // error: not nullable value required to call an 'iterator()' method on for-loop range
  for (ch in s) {
    if (!ch.isLetter()) return false
  }
  return true
}


fun exclaim(s: String?) {
  println(s + "!")
}

fun main() {
  exclaim(null) // null
}