// 12.2 코틀린 코드를 자바에서 사용하기

// 12.2.1 프로퍼티 접근

class Person(var name: String, val age: Int)


public class Person {
  @NotNull
  public String getName() {...}
  public void setName(@NotNull String value) {...}
  public int getAge() {...}
}


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", 25);
    System.out.println(person.getAge()); // 25

    person.setName("Harry");
    System.out.println(person.getName()); // Harry
  }
}


class Person(var name: String, val age: Int, var isEmployed: Boolean)


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", 25, false);
    person.setEmployed(true);
    System.out.println(person.isEmployed()); // true
  }
}


class Person(@JvmField var name: String, @JvmField val age: Int)


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", 25);
    System.out.println(person.age); // 25

    person.name = "Harry";
    System.out.println(person.name); // Harry
  }
}


class Person(val firstName: String, val familyName: String) {
  // Error: This annotation is not applicable to target 'member property without backing field or delegate'
  @JvmField val fullName get() = "$firstName $familyName"
}


open class Person(val firstName: String, val familyName: String) {
  // Error: JvmField can only be applied to final property
  @JvmField open var description: String = "Hello"
}


object Application {
  @JvmField val name = "My Application"
}


public class Main {
  public static void main(String[] args) {
    System.out.println(Application.name);
  }
}


object Application {
  const val name = "My Application"
}


class Person(val firstName: String, val familyName: String) {
  lateinit var fullName: String

  fun init() {
    fullName = "$firstName $familyName"
  }
}


public class Main {
  public static void main(String[] args) {
    Person person = new Person("John", "Doe");
    person.init();

    // 필드에 직접 접근
    System.out.println(person.fullName); // John Doe

    // 접근자 호출
    System.out.println(person.getFullName()); // John Doe
  }
}


object Application {
  lateinit var name: String
}


public class Main {
  public static void main(String[] args) {
    // 직접 프로퍼티 접근(정적 접근). 초기화하기 전이라서 null이 출력됨
    println(Application.name) // null
    // 접근자 호출(정적 접근이 아님)
    Application.INSTANCE.setName("Application1");

    // 직접 프로퍼티 접근(정적 접근)
    Application.name = "Application2"
  }
}