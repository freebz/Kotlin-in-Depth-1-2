// 6.1 이넘 클래스

enum class WeekDay {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

fun WeekDay.isWorkDay() =
  this == WeekDay.SATURDAY || this == WeekDay.SUNDAY

fun main() {
  println(WeekDay.MONDAY.isWorkDay())   // false
  println(WeekDay.SATURDAY.isWorkDay()) // true
}


fun main() {
  enum class Direction { NORTH, SOUTH, WEST, EAST } // Error
}