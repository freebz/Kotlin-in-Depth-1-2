// 14.2.5 속성 기반 테스트

infix fun Int.min(n: Int) = if (this < n) this else n


import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.and
import io.kotest.matchers.ints.beLessThanOrEqualTo
import io.kotest.matchers.should
import io.kotest.property.checkAll

class NumberTestWithAssertAll : StringSpec({
  "min" {
    checkAll { a: Int, b: Int ->
      (a min b).let {
        it should (beLessThanOrEqualTo(a) and beLessThanOrEqualTo(b))
      }
    }
  }
})


import io.kotest.core.spec.style.StringSpec
import io.kotest.property.forAll

class NumberTestWithAssertAll : StringSpec({
  "min (단언문 대신 식 사용)" {
    forAll{ a: Int, b: Int ->
      (a min b).let { it <= a && it <= b }
    }
  }
})


class RationalTest : StringSpec {
  "Subtraction (Arb 사용)"{
    forAll(
      // 첫 번째 인자로 Arb<Rational> 인스턴스를 넘김
      object : Arb<Rational>() {
        override fun edgecase(rs: RandomSource): Rational? = null // 에지케이스 없음
        override fun sample(rs: RandomSource): Sample<Rational> =
          Sample(Rational.of(rs.random.nextInt(), rs.random.nextInt(0, Int.MAX_VALUE)))
      }
    ){ a: Rational ->
      (a - a).num == 0
    }
  }
}


import io.kotest.core.spec.style.StringSpec
import io.kotest.property.*
import io.kotest.property.arbitrary.bind
import io.kotest.property.arbitrary.int

class RationalTest : StringSpec({
  val rationalArb = Arb.bind(Arb.int(),Arb.int(0,Int.MAX_VALUE)){x,y->Rational.of(x,y)}

  "Subtraction (Arb.int()와 Arb.bind() 사용)" {
    forAll(rationalArb){ a: Rational ->
      (a - a).num == 0
    }
  }
})


import io.kotest.core.style.StringSpec
import io.kotest.property.*
import io.kotest.property.arbitrary.bind
import io.kotest.property.arbitrary.int

class RationalTest : StringSpec({
  val rationalArb2 = arbitrary { Rational.of(it.random.nextInt(), it.random.nextInt(0,Int.MAX_VALUE)) }

  "Subtraction (arbitrary() 사용)" {
    forAll(rationalArb2){ a: Rational ->
      (a - a).num == 0
    }
  }
})


import io.kotest.core.spec.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class DataDrivenTest : StringSpec({
  "Minimum" {
    forAll(
      row(1, 1),
      row(1, 2),
      row(2, 1)
    ) { a: Int, b: Int ->
      (a min b).let { it <= a && it <= b }
    }
  }
})


import io.kotest.core.spec.style.StringSpec
import io.kotest.data.*
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual

class DataDrivenTest2 : StringSpec({
  "Minimum" {
    forAll(
      table(
        headers("name", "age"),
        row("John", 20),
        row("Harry", 25),
        row("Bob", 16)
      )
    ) { name, age ->
      age shouldBeGreaterThanOrEqual 18
    }
  }
})

// Test failed for (name, "Bob"), (age, 16) with error 16 should be >= 18