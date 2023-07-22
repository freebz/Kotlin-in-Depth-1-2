// 14.1 코테스트 명세

// 14.1.1 코테스트 시작하기

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class NumbersTest : StringSpec({
  "2 + 2 should be 4" { (2 + 2) shouldBe 4 }
  "2 * 2 should be 4" { (2 * 2) shouldBe 4 }
})