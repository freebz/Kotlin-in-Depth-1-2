// 17.3 서비스 API 결정하기

// 17.3.1 난수 생성기 서비스 구현하기

package com.example.randomGen

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RandomGenerator

fun main(args: Array<String>) {
  runApplication<RandomGenerator>(*args)
}


package com.example.randomGen

data class GenerationResult<T>(
  val status: String?,
  val values: List<T>
)

fun <T> errorResult(status: String) =
  GeneratorResult<T>(status, emptyList())
fun <T> successResult(values: List<T>) =
  GeneratorResult<T>(null, values)


package com.example.randomGen

import org.springframework.web.bind.annotation.RestController

@RestController
class RandomGeneratorController


@RequestMapping("/hello")
fun hello() = "Hello, World"


@RequestMapping("/hello/{user}")
fun hello(@PathVariable user: String) = "Hello, $user"


@RequestMapping("/sum/{op1}/{op2}")
fun hello(
  @PathVariable("op1") op1Str: String,
  @PathVariable("op2") op2Str: String
): Any {
  val op1 = op1Str.toIntOrNull() ?: return "Invalid input"
  val op2 = op2Str.toIntOrNull() ?: return "Invalid input"
  return op1 + op2
}


@RestController
class SampleController {
  @RequestMapping("/say/hello/{user}")
  fun hello(@PathVariable user: String) = "Hello, $user"

  @RequestMapping("/say/goodbye/{user}")
  fun goodbye(@PathVariable user: String) = "Goodbye, $user"
}


@RestController
@RequestMapping("/say")
class RandomGeneratorController {
  @RequestMapping("hello/{user}")
  fun hello(@PathVariable user: String) = "Hello, $user"

  @RequestMapping("goodbye/{user}")
  fun goodbye(@PathVariable user: String) = "Goodbye, $user"
}


@RequestMapping("/int/from/{from}/to/{to}/quantity/{ruantity}")
fun genIntegers(
  @PathVariable("from") fromStr: String,
  @PathVariable("to") toStr: String,
  @PathVariable("quantity") quantityStr: String
): GeneratorResult<Int> {
  val from = fromStr.toIntOrNull()
    ?: return errorResult("Range start must be an integer")
  val to = toStr.toIntOrNull()
    ?: return errorResult("Range end must be an integer")
  val quantity = quantityStr.toIntOrNull()
    ?: return errorResult("Quantity must be an integer")
  
  if (quantity <= 0) return errorResult("Quantity must be positive")
  if (from > to) return errorResult("Range may not be empty")

  val values = (1..quantity).map { Random.nextInt(from, to + 1) }
  return successResult(values)
}