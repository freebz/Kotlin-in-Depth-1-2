// 14.2 단언문

// 14.2.1 매처

abstract fun test(value: T): MatcherResult


import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult

fun beOdd() = object : Matcher<Int> {
  override fun test(value: Int): MatcherResult {
    return MatcherResult(
      value % 2 != 0,
      "$value should be odd",
      "$value should not be odd"
    )
  }
}


import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.*

class NumbersTestWithOddMatcher : StringSpec({
  "5 is odd" { 5 should beOdd() }
  "4 is not odd" { 4 shouldNot beOdd() }
})


"5 is positive odd" { 5 should (beOdd() and positive()) }


fun beOddLength() = beOdd().compose<Collection<*>> { it.size }


5 should beLessThan(10)
5 shouldBeLessThan(10)