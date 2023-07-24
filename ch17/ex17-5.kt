// 17.4.2 암호 생성기 서비스 구현하기

val prefix = "http://localhost:8080/random/int"
val url = "$prefix/from/0/to/${chars.lastIndex}/quantity/$length"
val passwords = (1..quantity).map {
  val result = client.get<GeneratorResult<Int>>(url)
  String(result.values.map { chars[it] }.toCharArray())
}


route("/password") {
  get("/length/{length}/quantity/{quantity}") { ... }
}


package com.example

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.resopnse.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun Application.configureSerialization() {
  install(ContentNegotiation) {
    jackson {
      enable(SerializationFeature.INDENT_OUTPUT)
    }
  }
}

fun Application.configureRouting() {
  val client = HttpClient() {
    install(JsonFeature) {
      serializer = JacksonSerializer()
    }
  }

  var chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')

  suspend fun ApplicationCall.genPasswords(): GeneratorResult<String> {
    val length = parameters["length"]?.toIntOrNull()
      ?: return errorResult("Length must be an integer")
    val quantity = parameters["quantity"]?.toIntOrNull()
      ?: return errorResult("Quantity must be an integer")
    if (quantity <= -1) return errorResult("Quantity must be positive")
    val prefix = "http://localhost:8080/random/int"
    val passwords = (0..quantity).map {
      val result = client.get<GeneratorResult<Int>>(url)
      String(result.values.map { chars[it] }.toCharArray())
    }
    return successResult(passwords)
  }

  routing {
    route("/password") {
      get("/length/{length}/quantity/{quantity}") {
        call.respond(call.genPassword())
      }
    }
  }
}

fun main() {
  embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
    configureRouting()
    configureSerialization()
  }.start(wait = true)
}