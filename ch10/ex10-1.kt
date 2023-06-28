// 10.1 애너테이션

// 10.1.1 애너테이션 클래스 정의하고 사용하기

import org.junit.Test

class MyTestCase {
  @Test
  fun testOnePlusOne() {
    assert(1 + 1 == 2)
  }
}


val s = @Suppress("UNCHECKED_CAST") objects as List<String>


@[Synchronized Strictfp] // @Synchronized @Strictfp와 같은 역할을 함
fun main() { }


class A @MyAnnotation constructor ()


annotation class MyAnnotation

@MyAnnotation fun annotatedFun() { }


annotation class MyAnnotation {
  val text = "???" // Error
}


annotation class MyAnnotation {
  companion object {
    val text = "???"
  }
}


annotation class MyAnnotation(val text: String)

@MyAnnotation("Some useful info") fun annotatedFun() { }


annotation class Dependency(val arg:String, val componentNames: String="Core")
annotation class Component(val name: String = "Core")

@Component("I/O")
class IO

@Component("Log")
@Dependency("I/O")
class Logger

@Component
@Dependency("I/O", "Log")
class Main


annotation class Component(val name: String = "Core")

val ioComponent = Component("IO") // error: annotation class cannot be instantiated


annotation class Dependency(vararg val componentNames: String)

annotation class Component(
  val name: String = "Core",
  val dependency: Dependency = Dependency()
)

@Component("I/O")
class IO

@Component("Log", Dependency("I/O"))
class Logger

@Component(dependency = Dependency("I/O", "Log"))
class Main


annotation class Dependency(val componentNames: Array<String>)

@Component(dependency = Dependency(arrayOf("I/O", "Log")))
class Main


annotation class Dependency(val componentNames: Array<String>)

@Component(dependency = Dependency(["I/O", "Log"]))
class Main


import kotlin.reflect.KClass

annotation class Dependency(vararg val componentClasses: KClass<*>)

annotation class Component(
  val name: String = "Core",
  val dependency: Dependency = Dependency()
)

@Component("I/O")
class IO

@Component("Log", Dependency(IO::class))
class Logger

@Component(dependency = Dependency(IO::class, Logger::class))
class Main


class Person(val name: String)


class Person(@get:A val name: String)


class Person(@get:[A B] val name: String)


class Person(val firstName: String, val familyName: String)

fun @receiver:A Person.fullName() = "$firstName $familyName"


@file:JvmName("MyClass")        // 이 줄은 파일 맨 앞에 있어야 함
...
fun main() {
  println("main() in MyClass")
}