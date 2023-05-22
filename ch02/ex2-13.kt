// 2.2.8 비교와 동등성

val a = 1
val b = 2
println(a == 1 || b != 1)   // true
println(a >= 1 && b < 3)    // true
println(a < 1 || b < 1)     // false
println(a > b)              // false


val a = 1                 // Int
val b = 2L                // Long
println(a == b)           // Error: comparing Int and Long
println(a.toLong() == b)  // OK: 두 타입 모두 Long임


1 <= 2L || 3 > 4.5


false == true // false
false < true  // true
false > 1     // Error: comparing Boolean and Int
'a' < 'b'     // true
'a' > 0       // Error: comparing Int and Char


println(Double.NaN == Double.NaN)               // false
println(Double.NaN != Double.NaN)               // true
println(Double.NaN <= Double.NaN)               // false
println(Double.NaN < Double.POSITIVE_INFINITY)  // false
println(Double.NaN > Double.NEGATIVE_INFINITY)  // false


val set = sortedSetOf(Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0)
println(set) // [-Infinity, 0.0, Infinity, NaN]