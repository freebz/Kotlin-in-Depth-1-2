// 4.3.3 커스텀 접근자 사용하기

class Person(val firstName: String, val familyName: String) {
  val fullName: String
    get(): String {
      return "$firstName $familyName"
    }
}


fun main() {
  var person = Person("John", "Doe")
  println(person.fullName) // John Doe
}


val fullName: String
  get() = "$firstName $familyName"


val fullName: Any
  get(): String {
    // error: getter return type must be equal to the type of the property, i.e. 'Any'
    return "$firstName $familyName"
  }


val fullName
  get() = "$firstName $familyName" // 타입이 String으로 추론된다


class Person(val firstName: String, val familyName: String, age: Int) {
  val age: Int = age
    get(): Int {
      println("Accessing age")
      return field
    }
}


class Person(val firstName: String, val familyName: String) {
  var age: Int? = null
    set(value) {
      if (value != null && value <= 0) {
        throw IllegalArgumentException("Invalid age: $value")
      }
      field = value
    }
}

fun main() {
  val person = Person("John", "Doe")
  person.age = 20     // 커스텀 세터를 호출
  println(person.age) // 20 (커스텀 게터를 호출)
}


class Person(var firstName: String, var familyName: String) {

  var fullName: String
    get(): String = "$firstName $familyName"
    set(value) {
      val names = value.split(" ") // 공백으로 구분해 단어를 분리한다
      if (names.size != 2) {
        throw IllegalArgumentException("Invalid full name: '$value'")
      }
      firstName = names[0]
      familyName = names[1]
    }
}


import java.util.Date

class Person(name: String) {
  var lastChanged: Date? = null
    private set // Person 클래스 밖에서는 변경할 수 없다

  var name: String = name
    set(value) {
      lastChanged = Date()
      field = value
    }
}