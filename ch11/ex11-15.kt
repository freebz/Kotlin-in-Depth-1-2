// 11.3.2 타입 안전한 빌더 사용하기

fun main() {
  val form = dialog("Send a message") {
    borderLayout {
      south = panel {
        +button("Send")
        +button("Cancel")
      }
      center = panel {
        verticalBoxLayout {
          +filter(0, 10)
          +panel {
            horizontalBoxLayout {
              +filter(5, 0)
              +label("Message: ")
              +filter(10, 0)
              +textArea("")
              +filter(5, 0)
            }
          }
          +filter(0, 10)
        }
      }
    }
  }
  from.size = Dimension(300, 200)
  form.isVisible = true
}


fun label(text: String) = JLabel(text)
fun button(text: String) = JButton(text)
fun textArea(text: String) = JTextArea(text)


class ContainerBuilder(private val container: Container) {
  operator fun Component.unaryPlus() = apply { container.add(this) }

  fun borderLayout(body: BorderLayoutBuilder.() -> Unit) {
    BorderLayoutBuilder(container).body()
  }

  fun horizontalBoxLayout(body: BoxLayoutBuilder.() -> Unit) {
    BoxLayoutBuilder(container, BoxLayout.LINE_AXIS).body()
  }

  fun verticalBoxLayout(body: BoxLayoutBuilder.() -> Unit) {
    BoxLayoutBuilder(container, BoxLayout.PAGE_AXIS).body()
  }
}


fun panel(body: ContainerBuilder.() -> Unit) = JPanel().apply {
  ContainerBuilder(this).body()
}

fun dialog(
  title: String,
  body: ContainerBuilder.() -> Unit
): JDialog = JDialog().apply {
  this.title = title
  pack()
  defaultCloseOperation = JDialog.DISPOSE_ON_CLOSE
  ContainerBuilder(contentPane).body()
}


panel {
  horizontalBoxLayout {
    +filter(5, 0)
    ...
  }
}


panel {
  this.horizontalBoxLayout {
    // BoxLayoutBuilder 타입의 디스패치 수신 객체를암시적으로 가정한다
    filter(5, 0).unaryPlus()
    ...
  }
}


class BoxLayoutBuilder(private val container: Container, direction: Int) {
  init {
    container.layout = BoxLayout(container, direction)
  }

  operator fun Component.unaryPlus() = apply { container.add(this) }

  fun filter(width: Int, height: Int) =
    Box.createRigidArea(Dimension(width, height))
}


fun constrained(
  container: Container,
  constraint: Any?
) = observable<Component?>(null) { _, _, value ->
  container.add(value, constraint)
}

class BorderLayoutBuilder(container: Container) {
  init {
    container.layout = BorderLayout()
  }

  var north by constrained(container, BorderLayout.NORTH)
  var south by constrained(container, BorderLayout.SOUTH)
  var west by constrained(container, BorderLayout.WEST)
  var east by constrained(container, BorderLayout.EAST)
  var center by constrained(container, BorderLayout.CENTER)
}