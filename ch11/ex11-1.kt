// 11.1 연산자 오버로딩

operator fun String.times(n: Int) = repeat(n)


println("abc" * 3) // abcabcabc


println("abc".times(3))


val x = 1.plus(2) // 1 + 2와 같음