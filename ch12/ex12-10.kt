// 12.2.4 노출된 선언 이름 변경하기

class Person(val firstName: String, val familyName: String)

val Person.fullName
  get() = "$firstName $familyName"

// error: Platform declaration clash: The following declarations have the same JVM signature (getFullName(LPerson;)Ljava/lang/String;);
fun getFullName(person: Person): String {
  return "${person.familyName}, ${person.firstName}"
}


@NotNull
public static String getFullName(@NotNull Person person) {...}


@JvmName("getFullNameFamilyFirst")
fun getFullName(person: Person): String { // Ok
  return "${person.familyName}, ${person.firstName}"
}


val Person.fullName
  @JvmName("getFullNameFamilyLast")
  get() = "$firstName $familyName"


@get:JvmName("getFullNameFamilyLast")
val Person.fullName
  get() = "$firstName $familyName"


class Person(@set:JvmName("changeName") var name: String, val age: Int)


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", 25);
    person.changeName("Harry");
    System.out.println(person.getName());
  }
}


class Person(val firstName: String, val familyName: String) {
  @JvmName("visit")
  fun goto(person: Person) {
    println("$this is visiting $person")
  }

  override fun toString() = "$firstName $familyName"
}