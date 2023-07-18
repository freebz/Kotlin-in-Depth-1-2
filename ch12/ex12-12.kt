// 12.2.6 예외 선언하기

// util.kt
fun loadData() = File("data.txt").readLines()


public class Main {
  public static void main(String[] args) {
    for (String line :UtilKt.loadData()) {
      System.out.println(line);
    }
  }
}


import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      for (String line :UtilKt.loadData()) {
        System.out.println(line);
      }
    } catch (IOException e) { // Error
      System.out.println("Can't load data");
    }
  }
}


@notNull
public List<String>loadData() {...}


// util.kt
@Throws(IOException::class)
fun loadData() = File("data.txt").readLines()


public class Main {
  public static void main(String[] args) {
    // Error: Unhandled IOException
    for (String line :UtilKt.loadData()) {
      System.out.println(line);
    }
  }
}


import java.io.File
import java.io.IOException

abstract class Loader {
  abstract fun loadData(): List<String>
}

class FileLoader(val path: String) : Loader() {
  @Throws(IOException::class)
  override fun loadData() = File(path).readLines()
}