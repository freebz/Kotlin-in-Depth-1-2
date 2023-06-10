// 6.3.2 부호 없는 정수

val uByte: UByte = 1u     // 명시적으로 UByte
val uShort: UShort = 100u // 명시적으로 UShort
val uInt = 1000u          // 자동으로 UInt로 추론
val uLong: ULong = 1000u  // 명시적으로 ULong
val uLong2 = 1000uL       // L 접미사가 붙었기 때문에 명시적으로 ULong


// error: the integer literal does not conform to the expected type Long
val long: Long = 1000uL // Error


println(1.toByte())         // 1, Int -> UByte
println((-100).toUShort())  // 65436, Int -> UShort
println(200u.toByte())      // -56, UInt -> Byte
println(1000uL.toInt())     // 1000, ULong -> Int


println(1u + 2u) // 3
println(1u - 2u) // 4294967295
println(3u * 2u) // 6
println(5u / 2u) // 2
println(7u % 3u) // 1


//error: conversion of signed constants to unsigned ones is prohibited
//error: none of the following functions can called with the arguments supplied
println(1u + 2)
println(1 + 2u)


// error: unresolved reference. None of the following candidates is applicable because of receiver type mismatch:
println(-1u)


var uInt: UInt = 1u
++uInt
uInt -= 3u


val ua: UByte = 67u   // 01000011
val ub: UByte = 139u  // 10001011
println(ua.inv())     // 10111100: 188
println(ua or ub)     // 11001011: 203
println(ua xor ub)    // 11001000: 200
println(ua and ub)    // 00000011: 3


val ua = 67u        // 0..0001000011
println(ua shr 2)   // 0..0000010000: 16
println(ua shl 2)   // 0..0100001100: 268


println(1u < 2u)            // true
println(2u >= 3u)           // false
println(2u + 2u == 1u + 3u) // true


val uBytes = ubyteArrayOf(1u, 2u, 3u)
val squares = UIntArray(10) { it.toUInt()*it.toUInt() }


1u .. 10u             // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
1u .. 10u step 2      // 1, 3, 5, 7, 9
1u until 10u          // 1, 2, 3, 4, 5, 6, 7, 8, 9
10u downTo 1u         // 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
10u downTo 1u step 3  // 10, 7, 4, 13