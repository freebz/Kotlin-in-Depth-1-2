// 2.2.1 정수 타입

val n = 12345


val n = 34_721_189


val one: Byte = 1                               // OK
val tooBigForShort: Short = 100_000             // Error: too big for Short
val million = 1_000_000                         // OK: Int로 타입이 추론됨
val tooBigForInt: Int = 10_000_000_000          // Error: too big for Int
val tenBillions = 10-10_000_000_000             // OK: Long으로 타입이 추론됨
val tooBigForLong = 10_000_000_000_000_000_000  // Error: too big for Long


val hundredLong = 100L      // OK: Long으로 타입이 추론됨
val hundredInt: Int = 100L  // Error: assigning Long to Int


val bin = 0b10101   // 21
val hex = 0xF9      // 249


val zero = 0        // OK
val zeroOne = 01    // Error


val neg = -10
val negHex = -0xFF


Short.MIN_VALUE     // -32768
Short.MAX_VALUE     // 32767
Int.MAX_VALUE + 1   // -2147483648(정수 오버플로(OVERFLOW))