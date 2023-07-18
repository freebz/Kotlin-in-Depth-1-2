// 12.1.5 널 가능성 애너테이션

import org.jetbrains.annotations.NotNull;

public class Person {
  @NotNull private String name;
  private int age;

  public Person(@NotNull String name, int age) {
    this.name = name;
    this.age = age;
  }

  @NotNull public String getName() { return name; }
  public void setName(@NotNull String name) { this.name = name; }
  public int getAge() { return age; }
  public void setAge(int age) { this.age = age; }
}


public class Person {
  ...
  @NotNull private Set<@NotNull Person> friends = new HashSet<>();
  @NotNull public Set<@NotNull Person>getFriends() { return friends; }
}


public class Person {
  ...
  @NotNull private Set<Person> friends = new HashSet<>();
  @NotNull public Set<Person>getFriends() { return friends; }
}