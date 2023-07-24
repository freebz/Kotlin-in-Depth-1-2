// 16.2.4 세션 지원

install(Sessions) {
  cookie<MyData>("my_data")
}


data class Stat(val viewCount: Int)
private const val STAT_KEY = "STAT"


private suspend fun ApplicationCall.rootPage() {
  val stat = sessions.getOrSet { Stat(0) }
  sessions.set(stat.copy(viewCount = stat.viewCount + 1 ))
  respondHtml {
    body {
      h2 { +"이 페이지에 ${stat.viewCount} 번 방문하셨습니다." }
      a("/clearStat") { +"방문 횟수 재설정하기" }
    }
  }
}


fun Application.configureRouting() {
  routing {
    get("/") {
      call.rootPage()
    }
  }
}


data class Stat(val viewCount: Int)  // 앞에서 보여줬던 상태 클래스 정의
private const val STAT_KEY = "STAT"  // 최상위 변수를 private으로 정의하면 같은 파일 안에서만 사용 가능함

fun Application.configureSecurity() {
  install(Sessions) {
    cookie<Stat>(STAT_KEY)
  }
  routing {
    get("/clearStat") {
      call.sessions.clear(STAT_KEY)
      call.respondRedirect("/")
    }
  }
}


install(Sessions) {
  header<MyData>("my_data")
}


install(Sessions) {
  cookie<Stat>(STAT_KEY, SessionStorageMemory()) {
    // 실제로는 SecureRandom 등 암호학적으로 안전한 난수 함수를 써야 한다
    val key = Random.nextBytes(16)
    transform(SessionTransportTransformerMessageAuthentication(key))
  }
}


install(Sessions) {
  cookie<Stat>(STAT_KEY, SessionStorageMemory()) {
    // 실제로는 secureRandom 등 암호학적으로 안전한 난수 함수를 써야 한다
    val encryptionKey = Random.nextBytes(16)
    val signKey = Random.nextBytes(16)
    transform(SessionTransportTransformerEncrypt(encryptionKey, signKey))
  }
}


install(Sessions) {
  cookie<Stat>(STAT_KEY, SessionStorageMemory())
}