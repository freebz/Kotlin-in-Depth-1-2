// 16.2.2 HTTP 요청 처리

routing {
  get("/") { call.respondText("This is root page") }
}


call.respondText("<h2>HTML Text</h2>", ContentType.Text.Html


call.respondText(ContentType.Text.CSS) { "p { color: red; }" }


call.respondTextWriter(ContentType.Text.Html) {
  write("<head><title>Sample page</title><head>")
  write("<body><h2>Sample page</h2></body>")
}


get("/") {
  val data = "<h2>HTML Text</h2>".toByteArray() // 디폴트인 UTF-8로 인코딩됨
  call.respondBytes(data, ContentType.Text.Html)
}


get("/download/{fileName}") {
  val rootDir = File("contentDir")
  val fileName = call.parameters["fileName"]!!
  call.respondFile(rootDir, fileName)
}


routing {
  get("/") {
    call.respondRedirect("index") // 302 Found
  }
  get("index") {
    call.respondText("Main page")
  }
}


routing {
  // 예: /sum?left=2&right=3 responds with 5
  get("/sum") {
    val left = call.request.queryParameters["left"]?.toIntOrNull()
    val right = call.request.queryParameters["right"]?.toIntOrNull()
    if (left != null && right != null) {
      call.respondText("${left + right}")
    } else {
      call.respondText("Invalid arguments")
    }
  }
}


routing {
  // 예: /sum?arg=1&arg=2&arg=3 responds with 6
  get("/sum") {
    val args = call.request.queryParameters.getAll("arg")
    if (args == null) {
      call.respondText("No data")
      return@get
    }
    var sum = 0
    for (arg in args) {
      val num = arg.toIntOrNull()
      if (num == null) {
        call.respondText("Invalid arguments")
        return@get
      }
      sum += num
    }
    call.respondText("$sum")
  }
}