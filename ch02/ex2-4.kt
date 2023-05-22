// 2.1.4 가변 변수

var sum = 1
sum = sum + 2
sum = sum + 3


var sum = 1
sum = "Hello" // Error: assigning String value to Int variable


var result = 3
result *= 10 // result = result * 10
result += 6  // result = result + 6


var a = 1
println(a++)  // a는 2, 1이 출력됨
println(++a)  // a는 3, 3이 출력됨
println(--a)  // a는 2, 2가 출력됨
println(a--)  // a는 1, 2가 출력됨