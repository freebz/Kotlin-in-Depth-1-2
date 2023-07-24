// 16.3.2 쿠키

import io.ktor.client.*
import io.ktor.client.request.get
import io.ktor.client.features.cookies.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private const val H2 = "<h2>"
private const val H2_CLOSE = "</h2>"

fun main() {
  HttpClient(){
    install(HttpCookies)
  }.use { client ->
    runBlocking {
      repeat(5) {
        val htmlText = client.get<String>("http://localhost:8080")
        val from = htmlText.indexOf(H2)
        val to = htmlText.indexOf(H2_CLOSE)
        if(from < 0 || to < 0) return@runBlocking
        val message = htmlText.substring(from+H2.length, to)
        println(message)
        delay(500)
      }
    }
  }
}

// 이 페이지에 0 번 방문하셨습니다.
// 이 페이지에 1 번 방문하셨습니다.
// 이 페이지에 2 번 방문하셨습니다.
// 이 페이지에 3 번 방문하셨습니다.
// 이 페이지에 4 번 방문하셨습니다.


val client = HttpClient() {
  install(HttpCookies) {
    storage = ConstantCookiesStorage(Cookie("STAT", "viewCount=%23i2"))
  }
}

// 이 페이지에 2 번 방문하셨습니다.
// 이 페이지에 2 번 방문하셨습니다.
// 이 페이지에 2 번 방문하셨습니다.
// 이 페이지에 2 번 방문하셨습니다.
// 이 페이지에 2 번 방문하셨습니다.