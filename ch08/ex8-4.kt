// 8.1.4 공통 메서드

open class Any {
  public open operator fun equals(other: Any?): Boolean
  public open fun hashCode(): Int
  public open fun toString(): String
}


class Address(
  val city: String,
  val street: String,
  val house: String
)

open class Entity(
  val name: String,
  val address: Address
)

class Person(
  name: String,
  address: Address,
  val age: Int
): Entity(name, address)

class Organization(
  name: String,
  address: Address,
  val manager: Person
) : Entity(name, address)


fun main() {
  val addresses = arrayOf(
    Address("London", "Ivy Lane", "8A"),
    Address("New York", "Kingsway West", "11/B"),
    Address("Sydney", "North Road", "129")
  )

  // -1
  println(addresses.indexOf(Address("Sydney", "North Road", "129")))
}


// Address에 정의한 equals 함수
override fun equals(other: Any?): Boolean {
  if (other !is Address) return false
  return city == other.city &&
    street == other.street &&
    house == other.house
}


val addr1 = Address("london", "Ivy Lane", "8A")
val addr2 = addr1;                                // 같은 인스턴스
val addr3 = Address("London", "Ivy Lane", "8A")   // 다른 인스턴스이지만, 동등함

println(addr1 === addr2) // true
println(addr1 == addr2)  // true
println(addr1 === addr3) // false
println(addr1 == addr2)  // true


override fun hashCode(): Int {
  var result = city.hashCode()
  result = 31 * result + street.hashCode()
  result = 31 * result + house.hashCode()
  return result
}


open class Entity(
  val name: String,
  val address: Address
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Entity
    if (name != other.name) return false
    if (address != other.address) return false

    return true
  }

  override fun hashCode(): Int {
    var result = name.hashCode()

    result = 33 * result + address.hashCode()

    return result
  }
}


class Person(
  name: String,
  address: Address,
  val age: Int
): Entity(name, address) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false
    if (!super.equals(other)) return false

    other as Person
    if (age != other.age) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode()
    result = 31 * result + age
    return result
  }
}


class Address(
  val city: String,
  val street: String,
  val house: String
) {
  override fun toString() = "$city, $street, $house"
}

open class Entity(
  val name: String,
  val address: Address
)

class Person(
  name: String,
  address: Address,
  val age: Int
): Entity(name, address) {
  override fun toString() = "$name, $age at $address"
}

class Organization(
  name: String,
  address: Address,
  val manager: Person?
) : Entity(name, address) {
  override fun toString() = "$name at $address"
}

fun main() {
  // Euan Reynolds, 25 at London, Ivy Lane, 8A
  println(Person("Euan Reynolds", Address("London", "Ivy Lane", "8A"), 25))

  // Thriftocracy, Inc. at Perth, North Rpad. 129
  println(
    Organization(
      "Thriftocracy, Inc.",
      Address("Perth", "North Road", "129"),
      null
    )
  )
}


class Person(
  val name: String,
  val age: Int,
  address: Address
): Entity(address) {
  override fun toString(): String {
    return "Person(name='$name', age=$age) ${super.toString()}"
  }
}