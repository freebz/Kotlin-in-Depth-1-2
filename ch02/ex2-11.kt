// 2.2.6 수 변환

val n = 100     // Int
val l: Long = n // Error: can't assign Int  to Long


println(l == n)


// 자바 코드
Integer n = 100;
Long l = n; // Error: can't assign Integer to Long


val n = 945
println(n.toByte())  // -79
println(n.toShort()) // 945
println(n.toChar())  // α
println(n.toLong())  // 945


println(2.5.toInt())    // 2
println((-2.5).toInt()) // -2
println(1_000_000_000_000.toFloat().toLong()) // 999999995904