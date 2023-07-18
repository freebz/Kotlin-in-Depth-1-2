// 12.1.4 플랫폼 타입

public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
}


fun main() {
  val person = Person("John", 25)
  println(person.name.length) // 4
}


fun main() {
  val person = Person(null, 25)
  println(person.name.length) // Exception: java.lang.NullPointerException
}


import java.math.BigInteger

// BigInteger! 반환 타입
fun Int.toBigInt() = BigInteger.valueOf(toLong())

val num = 123.toBigInt() // BigInteger! 타입