// 17.3.2 암호 생성 서비스 구현하기

val url = "http://localhost:8080/random/int/from/0/to/10/quantity/5"
val restTemplate = RestTemplate()
val result = restTemplate.getForObject(url, GeneratorResult::class.java)
               as GeneratorResult<Int>


package com.example.passwordGen

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

private val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')

@Suppress("unused")
@RestController
@RequestMapping("/password")
class PasswordGeneratorController {
  @RequestMapping("/length/{length}/quantity/{quantity}")
  fun genPasswords(
    @PathVariable("length") lengthStr: String,
    @PathVariable("quantity") quantityStr: String
  ): GeneratorResult<String> {
    val length = lengthStr.toIntOrNull()
      ?: return errorResult("Length must be an integer")
    val quantity = quantityStr.toIntOrNull()
      ?: return errorResult("Quantity must be an integer")
    if (quantity <= 0) return errorResult("Quantity must be positive")

    val prefix = "http://localhost:8080/random/int"
    val url = "$prefix/from/0/to/${chars.lastIndex}/quantity/$length"
    val restTemplate = RestTemplate()
    val passwords = (1..quantity).map {
      val result = restTemplate.getForObject(
        url, GeneratorResult::class.java
      ) as GeneratorResult<Int>
      String(result.values.map { chars[it] }.toCharArray())
    }
    return successResult(passwords)
  }
}


// application.properties
server.port=8081


val passwords = (1..quantity).map {
  val result = restTemplate.getForObject(
    url,GeneratorResult::class.java
  ) as GeneratorResult<Int>
  String(result.values.map { chars[it] }.toCharArray())
}