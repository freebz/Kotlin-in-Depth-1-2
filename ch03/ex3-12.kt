// 3.4.2 for 루프와 이터러블

fun main() {
  val a = IntArray(10) { it*it } // 0, 1, 4, 9, 16, ...
  var sum = 0

  for (x in a) {
    sum += x
  }

  println("Sum: $sum") // Sum: 285
}


for (x: Int in a) {
  sum += x
}


fun parseIntNumber(s: String, fallback: Int = -1): Int {
  var num = 0

  if (s.length !in 1..31) return fallback

  for (c in s) {
    if (c !in '0'..'1') return fallback
    num = num*2 + (c - '0')
  }
  return num
}


val a = IntArray(10) { it*it } // 0, 1, 4, 9, 16, ...

for (i in 0..a.lastIndex) {    // 0, 1, 2, 3, ...
  if (i % 2 == 0) {            // 0, 2, 4, 6, ...
    a[i] *= 2
  }
}


for (i in 0..a.lastIndex step 2) { // 0, 2, 4, 6, ...
  a[i] *= 2
}


val a = IntArray(10) { it*it } // 0, 1, 4, 9, 16, ...
for (i in a.indices step 2) {  // 0, 2, 4, 6, ...
  a[i] *= 2
}