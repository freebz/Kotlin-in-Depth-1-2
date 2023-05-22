// 2.2.3 산술 연산

println(7.floorDiv(4))      // 1
println((-7).floorDiv(4))   // -2
println(7.floorDiv(-4))     // -2
println((-7).floorDiv(-4))  // 1
println(7.mod(4))           // 3
println((-7).mod(4))        // 1
println(7.mod(-4))          // -1
println((-7).mod(-4))       // -3


val byte: Byte = 1
val int = 1
val long = 1L
val float = 1.5f
val double = 1.5
-byte      // -1: Int
-int       // -1: Int
-long      // -1: Long
-float     // -1.5: Float
-double    // -1.5: Double


byte + byte     // 2: Byte
int + byte      // 2: Int
int + int       // 2: Int
int + long      // 2: Long
long + double   // 2.5: Double
float + double  // 3.0: Double
float + int     // 2.5: Float
long + double   // 2.5: Double