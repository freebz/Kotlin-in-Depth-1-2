// 6.1.3 이넘 클래스의 공통 멤버 사용하기

enum class Direction {
  NORTH, SOUTH, WEST, EAST
}

fun main() {
  println(Direction.WEST.name)    // WEST
  println(Direction.WEST.ordinal) // 2
}


fun main() {
  println(Direction.WEST == Direction.NORTH)  // false
  println(Direction.WEST != Direction.EAST)   // true
  println(Direction.EAST < Direction.NORTH)   // false
  println(Direction.SOUTH >= Direction.NORTH) // true
}


fun main() {
  println(Direction.valueOf("NORTH"))   // NORTH
  // java.lang.IllegalArgumentException: No enum constant NORTH_EAST
  println(Direction.valueOf("NORTH_EAST"))
}


enum class WeekDay {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

private val weekDays = WeekDay.values()

val WeekDay.nextDay get() = weekDays[(ordinal + 1) % weekDays.size]


fun main() {
  val weekDays = enumValues<WeekDay>()

  println(weekDays[2])                          // WEDNESDAY
  println(enumValueOf<WeekDay>("THURSDAY"))     // THURSDAY
}