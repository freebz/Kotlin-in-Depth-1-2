// 16.2.1 라우팅

fun Application.configureRouting() {

  routing {
    get("/") {
      call.respondText("Hello World!")
    }
  }
}


@ContextDsl
public fun Application.routing(configuration: Routing.() -> Unit): Routing =
    featureOrNull(Routing)?.apply(configuration) ?: install(Routing, configuration)


fun Application.configureRouting() {
  install(Routing) {
    get("/") {
      call.respondText("Hello World!")
    }
  }
}


routing {
  get("hello/{userName}") {
    call.respondHtml {
      body {
        h1 {+"Hello, ${call.parameters["userName"]}"}
      }
    }
  }
}


routing {
  get("/hello/*") {
    call.respondHtml {
      body {
        h1 { +"Hello, World" }
      }
    }
  }
}


routing {
  get("/hello/{userName?}") {
    val userName = call.parameters["userName"] ?: "모르는 분"
    call.respondHtml {
      body {
        h1 { +"Hello, $userName" }
      }
    }
  }
}


routing {
  get("/calc/{data...}") {
    val data = call.parameters.getAll("data") ?: emptyList()
    call.respondHtml {
      body {
        h1 {
          if (data.size != 3) {
            +"Invalid data"
            return@h1
          }
          val (op, argStr1, argStr2) = data
          val arg1 = argStr1.toBigIntegerOrNull()
          var arg2 = argStr2.toBigIntegerOrNull()
          if (arg1 == null || arg2 == null) {
            +"Integer numbers expected"
            return@h1
          }
          val result = when (op) {
            "+" -> arg1 + arg2
            "-" -> arg1 - arg2
            "*" -> arg1 * arg2
            "/" -> arg1 / arg2
            else -> null
          }
          +(result?.toStriong() ?: "Invalid operation")
        }
      }
    }
  }
}


routing {
  method(HttpMethod.Get) {
    route("user/{name}") {
      route("sayHello") {
        handle {
          call.respondText("Hello, ${call.parameters["name"]}")
        }
      }
      route("sayBye") {
        handle {
          call.respondText("Bye, ${call.parameters["name"]}")
        }
      }
    }
  }
}


routing {
  get("/hello/{userName}") {
    call.respondText("Hello, ${call.parameters["userName"]}")
  }
}


routing {
  route("/hello/{userName}", HttpMethod.Get) {
    handle {
      call.respondText("Hello, ${call.parameters["userName"]}")
    }
  }
}


routing {
  route("/user/{name}", HttpMethod.Get) {
    param("action", "sayHello") {
      handle {
        call.respondHtml {
          body { h2 { +"Hello, ${call.parameters["name"]}" } }
        }
      }
    }
    param("action", "sayBye") {
      handle {
        call.respondHtml {
          body { h2 { +"Bye, ${call.parameters["name"]}" } }
        }
      }
    }
  }
}