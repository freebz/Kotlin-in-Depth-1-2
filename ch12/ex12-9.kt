// 12.2.3 객체와 정적 멤버

object Application {
  val name = "My Application"
  fun exit() { }
}


public class Main {
  public static void main(String[] args) {
    System.out.println(Application.INSTANCE.getName());
    Application.INSTANCE.exit();
  }
}


import java.io.InputStream

object Application {
  @JvmStatic var stdin: InputStream = System.`in`
  @JvmStatic fun exit() { }
}


import java.io.ByteArrayInputStream;

public class Main {
  public static void main(String[] args) {
    Application.setStdin(new ByteArrayInputStream("hello".getBytes()));
    Application.exit();
  }
}