// 17.4 Ktor를 사용한 마이크로서비스

// 17.4.1 JSON 직렬화 사용하기

implementation "io.ktor:ktor-jackson:$ktor_version"


install(ContentNegotiation) {
  jackson()
}


call.respond(successResult(listOf("12345678")))


data class PasswordSpec(val length: Int, val quantity: Int)
...
val spec = call.receive<PasswordSpec>()


plugins {
   ...
   kotlin("plugin.serialization") version "1.5.0"
}


val client = HttpClient() {
  ...
  install(JsonFeature)
  ...
}


val client = HttpClient() {
  ...
  install(JsonFeature) {
    serializer = JacksonSerializer()
  }
  ...
}


val url = "http://localhost:8080/random/int/from/0/to/10/quantity/5"
val result = client.get<GeneratorResult<Int>>(url)