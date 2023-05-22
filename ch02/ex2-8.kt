// 2.2.2 부동소수점 수

val pi = 3.14
val one = 1.0


val quarter = .25 // 0.25
val one = 1.      // Error: Exception an element
val two = 2       // 오류는 아니지만, 정수 리터럴임


val pi = 0.314E1        // 3.14 = 0.314*10
val pi100 = 0.314E3     // 314.0 = 0.314*1000
val piOver100 = 3.14E-2 // 0.0314 = 3.14/100
val thousand = 1E3      // 1000.0 = 1*1000


val pi = 3.14f
val one = 1f


val pi: Double = 3.14f // Error


println(Float.MIN_VALUE)                // 1.4E-45
println(Double.MAX_VALUE)               // 1.7976931348623157E308
println(Double.POSITIVE_INFINITY)       // Infinity
println(1.0/Double.NEGATIVE_INFINITY)   // -0.0
println(2 - Double.POSITIVE_INFINITY)   // -Infinity
println(3 * Float.NaN)                  // NaN