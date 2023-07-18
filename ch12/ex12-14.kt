// 12.2.8 타입 별명

typealias Name = String
class Person(val firstName: Name, val familyName: Name)


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", "Doe");
    System.out.println(person.getFamilyName()); // Doe
  }
}