// 8.1 상속

// 8.1.1 하위 클래스 선언

open class Vehicle {
  var currentSpeed = 0

  fun start() {
    println("I'm moving")
  }

  fun stop() {
    println("Stopped")
  }
}

open class FlyingVehicle : Vehicle() {
  fun takeOff() {
    println("Taking off")
  }
  fun land() {
    println("Landed")
  }
}

class Aircraft(val seats: Int) : FlyingVehicle()


// error: this type is final, so it cannot be inherited from
class Airbus(seats: Int) : Aircraft(seats)


val aircraft = Aircraft(100)
val vehicle: Vehicle = aircraft // 상위 타입으로 암시적으로 변환
vehicle.start()                 // Vehicle의 메서드 호출
vehicle.stop()                  // Vehicle의 메서드 호출
aircraft.start()                // Vehicle의 메서드 호출
aircraft.takeOff()              // FlyingVehicle의 메서드 호출
aircraft.land()                 // FlyingVehicle의 메서드 호출
aircraft.stop()                 // Vehicle의 메서드 호출
println(aircraft.seats)         // Aircraft 자체 프로퍼티 접근


// error: modifier 'open' is incompatible with 'data'
open data class Person(val name: String, val age: Int)


class MyBase
// error: inline classes can be only final
open value class MyString(val value: String)
// error: inline class cannot extend classes
value class MyStringInherited(val value: String): MyBase()


open class Person(val name: String, val age: Int) {
  companion object : Person("Unknown", 0)
}

object JohnDoe : Person("John Doe", 30)


open class Vehicle {
  open fun start() {
    println("I'm moving")
  }
  fun stop() {
    println("Stopped")
  }
}

class Car : Vehicle() {
  override fun start() {
    println("I'm riding")
  }
}

class Boat : Vehicle() {
  override fun start() {
    println("I'm sailing")
  }
}


fun startAndStop(vehicle: Vehicle) {
  vehicle.start()
  vehicle.stop()
}

fun main() {
  startAndStop(Car())
  startAndStop(Boat())
}


open class Vehicle {
  open fun start() {
    println("I'm moving")
  }
}

fun Vehicle.stop() {
  println("Stopped moving")
}

class Car : Vehicle() {
  override fun start() {
    println("I'm riding")
  }
}

fun Car.stop() {
  println("Stopped riding")
}

fun main() {
  val vehicle: Vehicle = Car()
  vehicle.start() // I'm riding
  vehicle.stop() // Stopped moving
}


open class Vehicle {
  open fun start(speed: Int) {
    println("I'm moving at $speed")
  }
}

class Car : Vehicle() {
  // 시그니처가 달라서 다른 메서드를 오버라이딩하려는 것으로 인식됨
  override fun start() { // error: 'start' overrides mothing
    println("I'm riding")
  }
}


open class Vehicle {
  open fun start(): String? = null
}

open class Car : Vehicle() {
  final override fun start() = "I'm riding a car"
}


open class Vehicle {
  open fun start() {
    println("I'm moving")
  }
}

open class Car : Vehicle() {
  final override fun start() {
    println("I'm riding a car")
  }
}

class Bus : Car() {
  // error: 'start' in 'Car' is final and cannot be overridden
  override fun start() {
    println("I'm riding a bus")
  }
}


open class Entity {
  open val name: String get() = ""
}

class Person(override val name: String) : Entity()


open class Entity {
  open val name: String get() = ""
}

class Person() : Entity() {
  override var name: String = ""
}


open class Vehicle {
  protected open fun onStart() { }
  fun start() {
    println("Starting up...")
    onStart()
  }
}

class Car : Vehicle() {
  override fun onStart() {
    println("It's a car")
  }
}

fun main() {
  val car = Car()
  car.start()    // Ok
  // error: cannot access 'onStart': it is protected in 'Car'
  car.onStart()
}


open class Vehicle {
  open fun start(): String? = "I'm moving"
}

open class Car : Vehicle() {
  override fun start() = super.start() + " in a car"
}

fun main() {
  println(Car().start()) // I'm moving in a car
}