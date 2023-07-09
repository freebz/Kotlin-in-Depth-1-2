// 11.3.3 @DslMarker

val myPanel = panel {
  borderLayout {
    borderLayout {
    }
  }
}


val myPanel = panel {
  this@panel.borderLayout {
    this@panel.borderLayout {
    }
  }
}


@DslMarker
annotation class LayoutDsl


@LayoutDsl
class ContainerBuilder(private val container: Container) {...}

@LayoutDsl
class BorderLayoutBuilder(container: Container) {...}

@LayoutDsl
class BoxLayoutBuilder(private val container: Container, direction: Int) {...}


val myPanel = panel {
  borderLayout {
    borderLayout{ // Error: DSL 영역 위반
    }
  }
}


val myPanel = panel {
  borderLayout {
    this@panel.borderLayout{ // 문제없이 컴파일됨
    }
  }
}