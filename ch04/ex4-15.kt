// 4.4.1 객체 선언

object Application {
  val name = "My Application"
  override fun toString() = name

  fun exit() { }
}


fun describe(app: Application) = app.name // Application은 타입임

fun main() {
  println(Application)                    // Application은 값임
}


public final class Application {
  private static final String name = "My Application";

  public static final Application INSTANCE;

  private Application() { }

  public final String getName() {
    return name;
  }

  public final void exit() { }

  static {
    INSTANCE = new Application();
    name = "My Application"
  }
}


import Application.exit

fun main() {
  println(Application.name) // 전체 이름을 사용
  exit()                    // 간단한 이름을 사용
}


import Application.* // Error