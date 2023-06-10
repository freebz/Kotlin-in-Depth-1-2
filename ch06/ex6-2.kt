// 6.1.1 빠뜨린 부분이 없는 when 식

enum class Direction {
  NORTH, SOUTH, WEST, EAST
}

fun rotateClockWise(direction: Direction) = when (direction) {
  Direction.NORTH -> Direction.EAST
  Direction.EAST -> Direction.SOUTH
  Direction.SOUTH -> Direction.WEST
  Direction.WEST -> Direction.NORTH
}


fun rotateClockWise(direction: Direction) = when (direction) {
  Direction.NORTH -> Direction.EAST
  Direction.EAST -> Direction.SOUTH
  Direction.SOUTH -> Direction.WEST
  Direction.WEST -> Direction.NORTH
  else ->
    throw IllegalArgumentException("Invalid direction: $direction")
}


enum class Direction {
  NORTH, SOUTH, WEST, EAST,
  NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST
}


public Direction rotateclockWise(Direction d) {
  switch (d) {
    case NORTH: return Direction.EAST;
    case EAST: return Direction.SOUTH;
    case SOUTH: return Direction.WEST;
    case WEST: return Direction.NORTH;
  }
  throw new IllegalArgumentException("Unknown value: " + d);
}


import Direction.*

enum class Direction {
  NORTH, SOUTH, WEST, EAST
}

fun rotateClockWise(direction: Direction) = when (direction) {
  NORTH -> EAST
  EAST -> SOUTH
  SOUTH -> WEST
  WEST -> NORTH
}