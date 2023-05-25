// 3.1.3 오버로딩과 디폴트 값

fun readInt() = readLine()!!.toInt()
fun readInt(radix: Int) = readLine()!!.toInt(radix)


fun plus(a: String, b: String) = a + b
fun plus(a: String, b: String) = a.toInt() + b.toInt() // error: conflicting overloads: public final fun plus(a: String, b: String): String defined(이하 생략)


fun mul(a: Int, b: Int) = a*b            // 1
fun mul(a: Int, b: Int, c: Int) = a*b*c  // 2
fun mul(s: String, n: Int) = s.repeat(n) // 3
fun mul(o: Any, n: Int) = Array(n) { o } // 4


mul(1, 2)   // Int가 Any의 하위 타입이므로 1과 4 중에 1을 선택
mul(1, 2L)  // error: none of the following functions can be called with the arguments supplied
            // 오류: (Int, Long) 타입을 받을 수 있는 함수가 없음
mul(1L, 2)  // Long, Int 타입을 받을 수 있는 함수는 4번뿐이므로 4를 선택
mul("0", 3) // String이 Any의 하위 타입이기 때문에 3과 4 중에 3을 선택


mul("0" as Any, 3) // (Any, Int)를 받을 수 있는 함수는 4뿐이므로 4를 선택


fun readInt() = readInt(10)


fun readInt(radix: Int = 10) = readLine()!!.toInt(radix)


val decimalInt = readInt()
val decimalInt2 = readInt(10)
val hexInt = readInt(16)


fun restrictToRange(
  from: Int = Int.MIN_VALUE,
  to: Int = Int.MAX_VALUE,
  what: Int
): Int = Math.max(from, Math.min(to, what))

fun main() {
  println(restrictToRange(10, what = 1))
}


fun mul(a: Int, b: Int = 1) = a*b             // 1
fun mul(a: Int, b: Long = 1L) = a*b           // 2
fun mul(a: Int, b: Int, c: Int = 1) = a*b*c   // 3


mul(10)          // 오류: 1과 2 중에 어느 쪽을 호출할지 결정할 수 없음
mul(10, 20)      // 인자가 더 적기 때문에 1과 3 중에 1을 선택
mul(10, 20, 30)  // 적용 가능한 함수가 3번뿐이므로 3을 선택


fun mul(a: Number, b: Int = 1) = a*b