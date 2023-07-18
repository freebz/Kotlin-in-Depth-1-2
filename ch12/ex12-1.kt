// 12.1 자바 코드를 코틀린에서 사용하기

// 12.1.1 자바 메서드와 필드

// 12.1.2 Unit과 Void

val length = String::class.java.getDeclaredMethod("length")
println(length("abcde")) // 5