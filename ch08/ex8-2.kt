// 8.1.2 하위 클래스 초기화

open class Vehicle {
  init {
    println("Initializing Vehicle")
  }
}

open class Car : Vehicle() {
  init {
    println("Initializing Car")
  }
}

class Truck : Car() {
  init {
    println("Initializing Truck")
  }
}

fun main() {
  Truck()
}


open class Person(val name: String, val age: Int)

class Student(name: String, age: Int, val university: String):
    Person(name, age)

fun main() {
  Student("Euan Reynolds", 25, "MIT")
}


open class Person {
  val name: String
  val age: Int

  constructor(name: String, age: Int) {
    this.name = name
    this.age = age
  }
}

class Student(name: String, age: Int, val university: String) :
    Person(name, age)


open class Person(val name: String, val age: Int)

class Student : Person {
  val university: String
  constructor(name: String, age: Int, university: String) :
    super(name, age) {
      this.university = university
  }
}


open class Person(val name: String, val age: Int)

// error: this type has a constructor, and thus must be initialized here
class Student() : Person {
  val university: String

  constructor(name: String, age: Int, university: String) :
      super(name, age) {         // error: primary constructor call expected
    this.university = university
  }
}


open class Person {
  val name: String
  val age: Int

  constructor(name: String, age: Int) {
    this.name = name
    this.age = age
  }

  constructor(firstName: String, familyName: String, age: Int) :
      this("$firstName $familyName", age) {
  }
}

class Student : Person {
  val university: String

  constructor(name: String, age: Int, university: String) :
      super(name, age) {
    this.university = university
  }

  constructor(
    firstName: String,
    familyName: String,
    age: Int,
    university: String
  ) :
      super(firstName, familyName, age) {
    this.university = university
  }
}

fun main() {
  Student("Euan", "Reynolds", 25, "MIT")
  Student("Val Watts", 22, "ETHZ")
}


open class Person(val name: String, val age: Int) {
  open fun showInfo() {
    println("$name, $age")
  }

  init {
    showInfo()
  }
}

class Student(
  name: String,
  age: Int,
  val university: String
) : Person(name, age) {
  override fun showInfo() {
    println("$name, $age (student at $university)")
  }
}

fun main() {
  Student("Euan Reynolds", 25, "MIT")
}


open class Person(val name: String, val age: Int) {
  override fun toString() = "$name, $age"

  init {
    println(this) // 잠재적인 위험 요소
  }
}

class Student(
  name: String,
  age: Int,
  val university: String
) : Person(name, age) {
  override fun toString() = super.toString() + " (student at $university)"
}

fun main() {
  // Euan Reynolds, 25 (student at null)
  Student("Euan Reynolds", 25, "MIT")
}