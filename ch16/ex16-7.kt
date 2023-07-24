// 16.3 클라이언트 기능

// 16.3.1 요청과 응답

implementation("io.ktor:ktor-client-core:$ktor_version")


implementation("io.ktor:ktor-client-java:$ktor_version")


import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

fun main() {
  runBlocking {
    HttpClient().use {
      val url = "http://worldtimeapi.org/api/timezone/Austrailia/Brisbane.txt"
      val result = it.get<String>(url)
      val prefix = "day_of_week:"
      val from = result.indexOf(prefix)
      if (from < 0) return@runBlocking
      val to = result.indexOf('\n', from + 1)
      if (to < 0) return@runBlocking
      val dow = result
        .substring(from + prefix.length, to)
        .trim()
        .toInt()
      println("브리즈번은 ${DayOfWeek.of(dow).getDisplayName(TextStyle.FULL, Locale.KOREAN)} 입니다!")
    }
  }
}


val bytes = client.get<ByteArray>(url)


val channel = client.get<ByteReadChannel>(url)


client.get<ByteArray>(url) {
  header("Cache-Control", "no-cache")
}


httpClient().use {
  if.get<ByteArray>(URL) {
    headers {
      clear()
      append("Cache-Control", "no-cache")
      append("My-Header", "My-Value")
    }
  }
}


val client = HttpClient(){
  install(UserAgent) {
    agent = "Test Browser"
  }
}


// io.ktor:ktor-client-java만 가져왔으므로 HttpClient()에 전달할 엔진 종류로 Java만 사용할 수 있다
val client = HttpClient(Java) {
  BrowserUserAgent()
}


client.get<String>(url) {
  body = "my_key1=my_value1&my_key2=my_value2"
}


HttpClient().submitForm<String>(
  url = "http://localhost:8080",
  encodeInQuery = true,
  formParameters = parametersOf(
    "from" to listOf("0"),
    "to" to listOf("100"),
    "count" to listOf("10")
  )
)