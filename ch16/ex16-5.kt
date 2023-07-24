// 16.2.3 HTML DSL

body {
  h1 { +"난수 생성" }
  fm(action = "/", method = FormMethod.get) {
    p { +"시작(생성되는 난수에 포함): " }
    p {
      numberInput(name = FROM_KEY) {
        value = from?.toString() ?: "1"
      }
      appendError(FROM_KEY)
    }
    p { +"끝(생성되는 난수에 미포함): " }
    p {
      numberInput(name = TO_KEY) {
        value = to?.toString() ?: "100"
      }
      appendError(TO_KEY)
    }
    p { +"생성할 난수 개수: " }
    p {
      numberInput(name = COUNT_KEY) {
        value = count?.toString() ?: "10"
      }
      appendError(COUNT_KEY)
    }
    p { submitInput { value = "Generate" } }
  }
  ...
}


<!DOCTYPE html>
<html>
  <body>
    <h1>난수 생성</h1>
    <form action="/" method="get">
      <p>시작(생성되는 난수에 포함): </p>
      <p><input type="number" name="from" value="1111"><strong>시작 끝 값보다 더 작아야 합니다.</strong></p>
      <p>끝(생성되는 난수에 미포함): </p>
      <p><input type="number" name="to" value="100"></p>
      <p>생성할 난수 개수: </p>
      <p><input type="number" name="count" value="-10"><strong>생성할 난수 개수는 0보다 커야 합니다.</strong></p>
      <p><input type="submit" value="Generate"></p>
    </form>
  </body>
</html>


// 서버 측(자바 버전)
implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:${kotlivx_html_version}")

// 클라이언트 측(js 버전)
implementation("org.jetbrains.kotlinx:kotlinx-html-js:${kotlinx_html_version}")