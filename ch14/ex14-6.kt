// 14.2.4 비결정적 코드 테스트하기

import io.kotest.assertions.timing.eventually
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

@ExperimentalTime
class StringSpecWithEventually : StringSpec({
  "10초 안에 파일의 내용이 단 한 줄인 경우가 있어야 함" {
    eventually(Duration.seconds(10)) {  // Duration.seconds(10)을 권장
      // 주어진 기간 동안 파일이 한 줄만 들어있는 순간이 올 때까지 검사(최대 10초)
      File("data.txt").readLines().size shouldBe 1      
    }
  }
})


// import는 앞의 StringSpecWithEventually 예제와 동일함

@ExperimentalTime
class StringSpecWithEventually : StringSpec({
  "10초 동안 파일의 내용이 계속 한 줄로 유지돼야 함" {
    continually(10.seconds) {
      File("data.txt").readLines().size shouldBe 1
    }
  }
})