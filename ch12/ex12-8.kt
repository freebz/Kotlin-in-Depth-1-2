// 12.2.2 파일 퍼사드와 최상위 선언

// util.kt
class Person(val firstName: String, val familyName: String)

val Person.fullName
  get() = "$firstName $familyName"

fun readPerson(): Person? {
  val fullName = readLine() ?: return null
  val p = fullName.indexOf(' ')
  return if (p >= 0) {
    Person(fullName.substring(0, p), fullName.substring(p + 1))
  } else {
    Person(fullName, "")
  }
}


public class UtilKt {
  @NotNull
  public static String getFullName(@NotNull Person person) {...}

  @Nullable
  public static Person readPerson() {...}
}


public class Main {
  public static void main(String[] args) {
    Person person = UtilKt.readPerson();
    if (person == null) return;
    System.out.println(UtilKt.getFullName(person));
  }
}


@file:JvmName("MyUtils")
class Person(val firstName: String, val familyName: String)

val Person.fullName
  get() = "$firstName $familyName"


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", "Doe");
    System.out.println(MyUtils.getFullName(person));
  }
}


// Person.kt
class Person(val firstName: String, val familyName: String)

// utils1.kt
@file:JvmMultifileClass
@file:JvmName("MyUtils")

val Person.fullName
  get() = "$firstName $familyName"

// utils2.kt
@file:JvmMultifileClass
@file:JvmName("MyUtils")

fun readPerson(): Person? {
  val fullName = readLine() ?: return null
  val p = fullName.indexOf(' ')

  return if (p >= 0) {
    Person(fullName.substring(0, p), fullName.substring(p + 1))
  } else {
    Person(fullName, "")
  }
}


public class Main {
  public static void main(String[] args) {
    Person person = MyUtils.readPerson();
    if (person == null) return;
    System.out.println(MyUtils.getFullName(person));
  }
}