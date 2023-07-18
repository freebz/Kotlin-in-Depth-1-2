// 12.2.7 인라인 함수

inline fun <reified T : Any> Any.cast(): T? = this as? T


public class Main {
  public static void main(String[] args) {
    UtilKt.<Integer>cast(""); // error: Cannot resolve method 'cast'
  }
}