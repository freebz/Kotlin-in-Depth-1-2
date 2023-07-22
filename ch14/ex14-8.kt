// 14.3 픽스처와 설정

// 14.3.1 픽스처 제공하기

package fixture

import io.kotest.core.listeners.*
import io.kotest.core.spec.AutoScan
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe
import kotlin.reflect.KClass

object SpecLevelListener : TestListener {
  override suspend fun prepareSpec(kclass: KClass<out Spec>) {
    println("PrepareSpec(in SpecLevelListener): ${kclass.qualifiedName}")
  }

  override suspend fun beforeSpec(spec: Spec) {
    println("BeforeSpec: ${spec.materializeRootTests().joinToString { it.testCase.displayName }}")
  }

  override suspend fun beforeTest(testCase: TestCase) {
    println("BeforeTest: ${testCase.displayName}")
  }

  override suspend fun afterTest(testCase: TestCase, result: TestResult) {
    println("AfterTest: ${testCase.displayName}")
  }

  override suspend fun afterSpec(spec: Spec) {
    println("AfterSpec: ${spec.materializeRootTests().joinToString { it.testCase.displayName }}")
  }

  override suspend fun finalizeSpec(kclass: KClass<out Spec>, results: Map<TestCase, TestResult>) {
    println("FinalizeSpec(in SpecLevelListener): ${kclass.qualifiedName}")
  }
}

class NumbersTestWithFixture1 : FunSpec() {
  init {
    context("Addition") {
      test("2 + 2") {
        2 + 2 shouldBe 4
      }
      test("4 + 4") {
        4 + 4 shouldBe 8
      }
    }
  }

  override fun listeners() = listOf(SpecLevelListener)
}

class NumbersTestWithFixture2 : FunSpec() {
  init {
    context("Multiplication") {
      test("2 * 2") {
        2 * 2 shouldBe 4
      }test("4 * 4") {
        4 * 4 shouldBe 16
      }
    }
  }

  override fun listeners() = listOf(SpecLevelListener)
}

// BeforeSpec: Addition
// BeforeTest: Addition
// BeforeTest: 2 + 2
// AfterTest: 2 + 2
// BeforeTest: 4 + 4
// AfterTest: 4 + 4
// AfterTest: Addition
// AfterSpec: Addition
// BeforeSpec: Multiplication
// BeforeTest: Multiplication
// BeforeTest: 2 * 2
// AfterTest: 2 * 2
// BeforeTest: 4 * 4
// AfterTest: 4 * 4
// AfterTest: Multiplication
// AfterSpec: Multiplication


import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.listeners.*
import kotlin.reflect.KClass

object MyProjectListener : ProjectListener, TestListener {
  override val name: String = "MyProjectListener"

  suspend fun beforeProject() { println("Before project") }
  
  override suspend fun afterProject() { println("After project") }
  
  override suspend fun prepareSpec(kclass: KClass<out Spec>) {
    println("PrepareSpec: ${kclass.qualifiedName}")
  }

  override suspend fun finalizeSpec(kclass: KClass<out Spec>, results: Map<TestCase, TestResult>) {
    println("FinalizeSpec: ${kclass.qualifiedName}")
  }
}

object ProjectConfig: AbstractProjectConfig() {
  override fun listeners() = listOf(MyProjectListener)
}

// Before project
// PrepareSpec: fixture.NumbersTestWithFixture1
// (중간 생략. 이전 예제의 실행 예와 같음)
// FinalizeSpec: fixture.NumbersTestWithFixture2
// After project


import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.FileReader

class FileTest : FunSpec() {
  val reader = autoClose(FileReader("data.txt"))

  init {
    test("Line count") {
      reader.readLines().isNotEmpty() shouldBe true
    }
  }
}