// 12.2.5 오버로딩한 메서드 생성하기

// util.kt
fun restrictToRange(
  what: Int,
  from: Int = Int.MIN_VALUE,
  to: Int = Int.MAX_VALUE
): Int {
  return Math.max(from, Math.min(to, what))
}

fun main() {
  println(restrictToRange(100, 1, 10)) // 10
  println(restrictToRange(100, 1))     // 100
  println(restrictToRange(100))        // 100
}


public int restrictToRange(int what, int from, int to) {...}


public class Main {
  public static void main(String[] args) {
    System.out.println(UtilKt.restrictToRange(100, 1, 10));
    System.out.println(UtilKt.restrictToRange(100, 1)); // Error
    System.out.println(UtilKt.restrictToRange(100));    // Error
  }
}


@JvmOverloads
fun restrictToRange(
  what: Int,
  from: Int = Int.MIN_VALUE,
  to: Int = Int.MAX_VALUE
): Int {
  return Math.max(from, Math.min(to, what))
}


public int restrictToRange(int what, int from, int to) {...}
public int restrictToRange(int what, int from) {...}
public int restrictToRange(int what) {...}


public class Main {
  public static void main(String[] args) {
    System.out.println(UtilKt.restrictToRange(100, 1, 10)); // 10
    System.out.println(UtilKt.restrictToRange(100, 1));     // 100
    System.out.println(UtilKt.restrictToRange(100));        // 100
  }
}