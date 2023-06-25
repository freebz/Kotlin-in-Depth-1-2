// 8.2.2 인터페이스

interface Vehicle {
  val currentSpeed: Int
  fun move()
  fun stop()
}


interface FlyingVehicle : Vehicle {
  val currentHeight: Int
  fun takeOff()
  fun land()
}

class Car : Vehicle {
  override var currentSpeed = 0
      private set
  
  override fun move() {
    println("Riding...")
    currentSpeed = 50
  }

  override fun stop() {
    println("Stopped")
    currentSpeed = 0
  }
}

class Aircraft :FlyingVehicle {
  override var currentSpeed = 0
      private set

  override var currentHeight = 0
      private set

  override fun move() {
    println("Taxiing...")
    currentSpeed = 50
  }

  override fun stop() {
    println("Stopped")
    currentSpeed = 0
  }

  override fun takeOff() {
    println("Takinig off...")
    currentSpeed = 500
    currentHeight = 5000
  }

  override fun land() {
    println("Landed")
    currentSpeed = 50
    currentHeight = 0
  }
}


interface Vehicle {
  val currentSpeed: Int

  val isMoving get() = currentSpeed != 0

  fun move()

  fun stop()

  fun report() {
    println(if (isMoving) "Moving at $currentSpeed" else "Still")
  }
}


interface Vehicle {
  // error: modifier 'final' is not applicable inside 'interface'
  final fun move() {}
}


fun Vehicle.relativeSpeed(vehicle: Vehicle) =
  currentSpeed - vehicle.currentSpeed


interface Vehicle {
  fun move() {
    println("I'm moving")
  }
}

interface Car : Vehicle {
  override fun move() {
    println("I'm riding")
  }
}


interface Vehicle {
  val currentSpeed = 0          // Error
  val maxSpeed by lazy { 100 }  // Error
}


// error: property initializers are not allowed in interfaces
interface Person(val name: String)

interface Vehicle {
  // error: delegated properties are not allowed in interfaces
  constructor(name: String)
}


interface Car {
  fun ride()
}

interface Aircraft {
  fun fly()
}

interface Ship {
  fun sail()
}

interface FlyingCar : Car, Aircraft

class Transformer :FlyingCar, Ship {
  override fun ride() {
    println("I'm riding")
  }
  override fun fly() {
    println("I'm flying")
  }
  override fun sail() {
    println("I'm sailing")
  }
}


interface Car {
  fun move()
}

interface Ship {
  fun move()
}

class Amphibia : Car, Ship {
  override fun move() {
    println("I'm moving")
  }
}


interface Car {
  fun move(){
    println("I'm riding")
  }
}

interface Ship {
  fun move()
}

class Amphibia : Car, Ship {
  override fun move() {
    super.move() // Car에서 상속받은 메서드를 호출
  }
}

fun main() {
  Amphibia().move() // I'm riding
}


interface Car {
  fun move(){
    println("I'm riding")
  }
}

interface Ship {
  fun move() {
    println("I'm sailiing")
  }
}

class Amphibia : Car, Ship {
  override fun move() {
    super<Car>.move() // Car에서 상속받은 메서드를 호출
    super<Ship>.move() // Ship에서 상속받은 메서드를 호출
  }
}

fun main() {
  /*
      I'm riding
      I'm sailing
  */
  Amphibia().move()
}


interface Vehicle {
  val currentSpeed: Int
}

interface Car : Vehicle

interface Ship : Vehicle

class Amphibia : Car, Ship {
  override var currentSpeed = 0
  private set
}