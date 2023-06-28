// 10.2 리플렉션

// 10.2.1 리플렉션 API 개요

public val annotations: List<Annotation>


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


fun main() {
  val component = Main::class.annotations
    .filterIsInstance<Component>()
    .firstOrNull() ?: return

  println("Component name: ${component.name}")

  val depText = component.dependency.componentClasses
    .joinToString { it.simpleName ?: "" }

  println("Dependencies: $depText")
}

// Component name: Core
// Dependencies: IO, Logger