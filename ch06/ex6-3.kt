// 6.1.2 커스텀 멤버가 있는 이넘 정의하기

enum class WeekDay {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

  val lowerCaseName get() = name.lowercase()
  fun isWorkDay() = this == SATURDAY || this == SUNDAY
}

fun main() {
  println(WeekDay.MONDAY.isWorkDay())       // false
  println(WeekDay.WEDNESDAY.lowerCaseName) // wednesday
}


enum class RainbowColor(val isCold: Boolean) {
  RED(false), ORANGE(false), YELLOW(false),
  GREEN(true), BLUE(true), INDIGO(true), VIOLET(true);

  val isWarm get() = !isCold
}

fun main() {
  println(RainbowColor.BLUE.isCold)  // true
  println(RainbowColor.RED.isWarm)   // true
}


enum class WeekDay {
  MONDAY { fun startWork() = println("Work week started") },
  TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

fun main() = WeekDay.MONDAY.startWork() // Error