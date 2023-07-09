// 11.1.2 증가와 감소

enum class RainbowColor {
  RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;
}


enum class RainbowColor {
  RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;
  operator fun inc() = values[(ordinal + 1) % values.size]
  operator fun dec() = values[(ordinal + values.size -1) % values.size]
  companion object {
    private val values = enumValues<RainbowColor>()
  }
}


var color = RainbowColor.INDIGO
println(color++)


var color = RainbowColor.INDIGO
val _oldColor = color
color = color.inc()
println(_oldColor) // INDIGO


var color = RainbowColor.INDIGO
println(++color)


var color = RainbowColor.INDIGO
color = color.inc()
println(color) // VIOLET