// 4.1.1 클래스 내부 구조

class Person {
  var firstName: String = ""
  var familyName: String = ""
  var age: Int = 0
  
  fun fullName() = "$firstName $familyName"

  fun showMe() {
    println("${fullName()}: $age")
  }
}


fun showAge(p: Person) = println(p.age) // 프로퍼티 읽기
fun readAge(p: Person) {
  p.age = readLine()!!.toInt()          // 프로퍼티에 쓰기
}


fun showFullName(p: Person) = println(p.fullName()) // 메서드 호출하기


class Person {
  var firstName: String = ""
  var familyName: String = ""
  var age: Int = 0

  fun fullName() = "${this.firstName} ${this.familyName}"
  fun showMe() {
    println("${this.fullName()}: ${this.age}")
  }
}


fun main() {
  val person = Person() // Person 인스턴스 생성

  person.firstName = "John"
  person.familyName = "Doe"
  person.age = 25

  person.showMe() // John Doe: 25
}


class Person {
  // 생성자로 초기화할 방법이 없으면 모든 클래스가
  // firstName에 대해 같은 값을 사용하게 됨
  val firstName = "John"
}