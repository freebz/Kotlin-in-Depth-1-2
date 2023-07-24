// 16.2 서버 관련 기능

fun main() {
  embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    configureRouting()
    configureTemplating()
    configureHTTP()
  }.start(wait = true)
}


fun Application.configureHTTP() {
  install(Compression) {
    gzip {
      priority = 1.0
    }
    deflate {
      priority = 10.0
      minimumSize(1024) // 적용 조건
    }
  }
}