// 3.4.5 꼬리 재귀 함수

tailrec fun binIndexOf(
  x: Int,
  array: IntArray,
  from: Int = 0,
  to: Int = array.size
): Int {
  if (from == to) return -1
  val midIndex = (from + to - 1) / 2
  return when {
    mid < x ->binIndexOf(x, array, midIndex + 1, to)
    mid > x ->binIndexOf(x, array, from, midIndex)
    else ->midIndex
  }
}


// 앞의 binIndexOf 함수를 코틀린 컴파일러가 컴파일한 결과는 이런 식으로 루프로 작동한다
fun binIndexOf(
  x: Int,
  array: IntArray,
  from: Int = 0,
  to: Int = array.size
): Int {
  var fromIndex = from
  var toIndex = to

  while (true) {
    if (fromIndex == toIndex) return -1
    val midIndex = (fromIndex + toIndex - 1) / 2
    val mid = array[midIndex]

    when {
      mid < x ->fromIndex = midIndex + 1
      mid > x ->toIndex = midIndex
      else -> return midIndex
    }
  }
}


tailrec fun sum(array: IntArray, from: Int = 0, to: Int = array.size): Int {
  // warning: a function is marked as tail-recursive but no tail calls are found
  // warning: recursive call is not a tail call
  return if (from < to) return array[from] + sum(array, from + 1, to) else 0
}


tailrec fun sum(a: Int, b: Int): Int {
  return a + b // warning: a function is marked as tail-recursive but no tail calls are found
}