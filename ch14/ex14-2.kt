// 14.1.2 명세 스타일

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class NumbersTest : StringSpec({
  "2 + 2 should be 4" { (2 + 2) shouldBe 4 }
  "2 * 2 should be 8" { (2 * 2) shouldBe 4 }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec

class NumbersTest2 : WordSpec({
  "1 + 2" should {
    "be equal to 3" { (1 + 2) shouldBe 3 }
    "be equal to 2 + 1" { (1 + 2) shouldBe (2 + 1) }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec

class NumbersTest2 : WordSpec({
  "Addition" When {
    "1 + 2" should {
      "be equal to 3" { (1 + 2) shouldBe 3 }
      "be equal to 2 + 1" { (1 + 2) shouldBe (2 + 1) }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FunSpec

class NumbersTest3 : FunSpec({
  test("0 should be equal to 0") { 0 shouldBe 0 }
  context("Arithmetic") {
    context("Addition") {
      test("2 + 2 should be 4") { (2 + 2) shouldBe 4 }
    }
    context("Multiplication") {
      test("2 * 2 should be 4") { (2 * 2) shouldBe 4 }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.DescribeSpec

class NumbersTest4 : DescribeSpec({
  describe("Addition") {
    context("1 + 2") {
      it("should give 3") { (1 + 2) shouldBe 3 }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.ShouldSpec

class NumbersTest5 : ShouldSpec({
  should("be equal to 0") { 0 shouldBe 0 }
  context("Addition") {
    context("1 + 2") {
      should("be equal to 3") { (1 + 2) shouldBe 3 }
      should("be equal to 2 + 1") { (1 + 2) shouldBe (2 + 1) }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

class NumbersTest6 : FreeSpec({
  "0 should be equal to 0" { 0 shouldBe 0 }
  "Addition" - {
    "1 + 2" - {
      "1 + 2 should be equal to 3" { (1 + 2) shouldBe 3 }
      "1 + 2 should be equal to 2 + 1" { (1 + 2) shouldBe (2 + 1) }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FeatureSpec

class NumbersTest7 : FeatureSpec({
  feature("Arithmetic") {
    val x = 1
    scenario("x is 1 at first") { x shouldBe 1 }
    feature("increasing by") {
      scenario("1 gives 2") { (x + 1) shouldBe 2 }
      scenario("2 gives 3") { (x + 2) shouldBe 3 }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.BehaviorSpec

class NumbersTest8 : BehaviorSpec({
  Given("Arithmetic") {
    When("x is 1") {
      val x = 1
      And("increased by 1") {
        Then("result is 2") { (x + 1) shouldBe 2 }
      }
    }
  }
})


import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.AnnotationSpec

class NumbersTest9 : AnnotationSpec() {
  @Test fun `2 + 2 should be 4`() { (2 + 2) shouldBe 4 }
  @Test fun `2 * 2 should be 4`() { (2 * 2) shouldBe 4 }
}