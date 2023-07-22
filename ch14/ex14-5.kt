// 14.2.3 예외 처리

import io.kotest.matchers.string.shouldEndWith
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class ParseTest : StringSpec({
  "invalid string" {
    val e = shouldThrow<NumberFormatException>{ "abc".toInt() }
    e.message shouldEndWith "\"abc\""
  }
})


import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan

class NumberTestWithForAll : StringSpec({
  val numbers = Array(10) { it + 1 }
  "invalid numbers" {
    assertSoftly {
      numbers.forAll { it shouldBeLessThan 5 }
      numbers.forAll { it shouldBeGreaterThan 3 }
    }
  }
})

// io.kotlintest.tables.MultiAssertionError:
// The following 9 assertions failed
// ...