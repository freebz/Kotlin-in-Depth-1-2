// 2.4.2 배열 사용하기

val squares = arrayOf(1, 4, 9, 16)
squares.size       // 4
squares.lastIndex  // 3
squares[3]         // 16
squares[1]         // 4


squares[2] = 100 // squares: 1, 4, 100, 16
squares[3] += 9  // squares: 1, 4, 100, 25
squares[0]--     // squares: 0, 4, 100, 25


val numbers = squares.copyOf()
numbers[0] = 100    // squares에는 영향이 없다
squares.copyOf(2)   // 뒤가 잘림: 1, 4
squares.copyOf(5)   // 부족한 부분에 0이 채워짐: 1, 4, 9, 16, 0


var a = arrayOf(1, 4, 9, 16)
a = arrayOf("one", "two") // Error: can't assign Array<String> to Array<Int>


Object[] objects = new String[] { "one", "two", "three" };
objects[0] = new Object(); // ArrayStoreException 예외가 발생함


val strings = arrayOf("one", "two", "three")
val objects: Array<Any> = strings // 예외


val b = intArrayOf(1, 2, 3) + 4                 // 원소를 하나만 추가: 1, 2, 3, 4
val c = intArrayOf(1, 2, 3) + intArrayOf(5, 6)  // 다른 배열을 추가: 1, 2, 3, 5, 6


intArrayOf(1, 2, 3) == intArrayOf(1, 2, 3) // false


intArrayOf(1, 2, 3).contentEquals(intArrayOf(1, 2, 3)) // true