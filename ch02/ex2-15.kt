// 2.3.2 기본 문자열 연산

"Hello!".length     // 6
"Hello!".lastIndex  // 5(첫 번째 문자의 인덱스가 0이므로)


val s = "Hello!"
println(s[0])   // H
println(s[1])   // e
println(s[5])   // !
println(s[10])  // 잘못된 인덱스


val s = "The sum is: " + sum // "The sum is $sum"으로 대신할 수 있음


val s1 = "Hello!"
val s2 = "Hel" + "lo!"
println(s1 == s2) // true


println("abc" < "cba") // true
println("123" > "34")  // false