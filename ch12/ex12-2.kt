// 12.1.3 합성 프로퍼티

public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}


fun main() {
  val person = Person("John", 25)
  person.name = "Harry"
  person.age = 30

  println("${person.name}, ${person.age}") // Harry, 30
}


public class Person {
  ...

  private boolean isEmployed;

  public boolean isEmployed() {
    return isEmployed;
  }
  public void setEmployed(boolean employed) {
    isEmployed = employed;
  }
}