// 3.2.2 임포트 디렉티브 사용하기

import java.lang.Math         // JDK 클래스
import foo.bar.util.readInt   // 최상위 함수


import kotlin.Int.Companion.MIN_VALUE
fun fromMin(steps: Int) = MIN_VALUE + n // MIN_VALUE를 간단한 이름으로 가리킴


import app.util.foo.readInt
import app.util.bar.readInt

fun main() {
  val n = readInt() // 오류: 두 가지 readInt() 중에 하나를 선택할 수 없음
}


import foo.readInt as fooReadInt
import bar.readInt as barReadInt

fun main() {
  val n = fooReadInt()
  val m = barReadInt()
}


import kotlin.math.* // kotlin.math 패키지 안에 있는 모든 선언을 임포트


import app.util.foo.readInt
import app.util.bar.*

fun main() {
  val n = readInt() // 모호하지 않음. app.util.foo.readInt를 사용
}