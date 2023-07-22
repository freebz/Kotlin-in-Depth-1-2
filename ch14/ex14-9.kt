// 14.3.2 테스트 설정

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringSpecWithConfig : StringSpec({
  "2 + 2 should be 4".config(invocations = 10) { (2 + 2) shouldBe 4 }
})
class ShouldSpecWithConfig : ShouldSpec({
  context("Addition") {
    context("1 + 2") {
      should("be equal to 3").config(threads = 2, invocations = 100) {
        (1 + 2) shouldBe 3
      }
      should("be equal to 2 + 1").comfig(timeout = 1.minutes) {
        (1 + 2) shouldBe (2 + 1)
      }
    }
  }
})

class BehaviorSpecWithConfig : BehaviorSpec({
  Given("Arithmetic") {
    When("x is 1") {
      val x = 1
      And("increased by 1") {
        then("result is 2").config(invocations = 100) {
          (x + 1) shouldBe 2
        }
      }
    }
  }
})


import io.kotest.core.config.AbstractProjectConfig

object ProjectConfig : AbstractProjectConfig() {
  override val parallelism = 4
}


import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCaseConfig
import io.kotest.matchers.shouldBe

class StringSpecWithConfig2 : StringSpec({
  "2 + 2 should be 4" { (2 + 2) shouldBe 4 }
}) {
  override fun defaultConfig(): TestCaseConfig =
    TestCaseConfig(invocations = 10, threads = 2)
}


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class IncTest : FunSpec() {
  var x = 0
  init {
    context("Increment") {
      println("Increment")
      test("prefix") {
        println("prefix")
        ++x shouldBe 1
      }
      test("postfix") {
        println("postfix")
        x++ shouldBe 0
      }
    }
  }
}


object IncTestProjectConfig : AbstractProjectConfig() {
  override val isolationMode = IsolationMode.InstancePerTest
}

// Increment
// Increment
// prefix
// Increment
// postfix


// InstancePerLeaf

// Increment
// prefix
// Increment
// postfix