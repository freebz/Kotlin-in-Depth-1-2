// 8.2.3 봉인된 클래스와 인터페이스

enum class Result {
  SUCCESS, ERROR
}

fun runComputation(): Result {
  try {
    val a = readLine()?.toInt() ?: return Result.ERROR
    val b = readLine()?.toInt() ?: return Result.ERROR

    println("Sum: ${a + b}")

    return Result.SUCCESS
  } catch (e: NumberFormatException) {
    return Result.ERROR
  }
}

fun main() {
  val message = when (runComputation()) {
    Result.SUCCESS -> "Completed successfully"
    Result.ERROR -> "Error"
  }
  println(message)
}


abstract class Result {
  class Success(val value: Any) : Result() {
    fun showResult() {
      println(value)
    }
  }

  class Error(val message: String) : Result() {
    fun throwException() {
      throw Exception(message)
    }
  }
}

fun runComputation(): Result {
  try {
    val a = readLine()?.toInt()
        ?: return Result.Error("Missing first argument")
    val b = readLine()?.toInt()
        ?: return Result.Error("Missing second argument")
    
    return Result.Success(a + b)
  } catch (e: NumberFormatException) {
    return Result.Error(e.message ?: "Invalid input")
  }
}

fun main() {
  val message = when (val result = runComputation()) {
    is Result.Success -> "Completed successfully: ${result.value}"
    is Result.Error -> "Error: ${result.message}"
    else -> return
  }
  println(message)
}


class MyStatus: Result()


sealed class Result {
  class Success(val value: Any) : Result() {...}
  class Error(val message: String) : Result() {...}
}


// error: sealed types cannot be instantiated
val result = Result()


val message = when (val result = runComputation()) {
  is Result.Success -> "Completed successfully: ${result.value}"
  is Result.Error -> "Error: ${result.message}"
}


// Result.kt
sealed class Result {
  class Success(val value: Any) : Result()
  open class Error(val message: String) : Result()
}

// util.kt
class FatalError(message: String): Result.Error(message)


sealed class Result

class Success(val value: Any) : Result()

sealed class Error : Result() {
  abstract val message: String
}

class ErrorWithException(val exception: Exception): Error() {
  override val message: String get() = exception.message ?: ""
}

class ErrorWithMessage(override val message: String): Error()


sealed class Expr

data class Const(val num: Int): Expr()
data class Neg(val operand: Expr): Expr()
data class Plus(val op1: Expr, val op2: Expr): Expr()
data class Mul(val op1: Expr, val op2: Expr): Expr()

fun Expr.eval(): Int = when (this) {
  is Const -> num
  is Neg -> -operand.eval()
  is Plus -> op1.eval() + op2.eval()
  is Mul -> op1.eval() * op2.eval()  
}

fun main() {
  // (1 + 2) * 3
  val expr = Mul(Plus(Const(1), Const(2)), Const(3))

  // Mul(op1=Plus(op1=Const(num=1), op2=Const(num=2)), op2=Const(num=3))
  println(expr)
  println(expr.eval()) // 9

  // 2 * 3
  val expr2 = expr.copy(op1 = Const(2))

  // Mul(op1=Const(num=2), op2=Const(num=3))
  println(expr2)
  println(expr2.eval()) // 6
}


sealed class Result {
  object Completed : Result()
  class ValueProduced(val value: Any) : Result()
  class Error(val message: String) : Result()
}