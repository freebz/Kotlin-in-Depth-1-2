// 15.2.3 젯팩 뷰 바인딩

android {
  ... (나머지 생략)
  buildFeatures {
    viewBinding true
  }
}


private lateinit var binding: ActivityMainBinding


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    ...
}


binding.run{
    btn0.setOnClickListener{ appendText("0") }
    btn1.setOnClickListener{ appendText("1") }
    btn2.setOnClickListener{ appendText("2") }
    btn3.setOnClickListener{ appendText("3") }
    btn4.setOnClickListener{ appendText("4") }
    btn5.setOnClickListener{ appendText("5") }
    btn6.setOnClickListener{ appendText("6") }
    btn7.setOnClickListener{ appendText("7") }
    btn8.setOnClickListener{ appendText("8") }
    btn9.setOnClickListener{ appendText("9") }
    btnPoint.setOnClickListener{ appendText(".") }
    btnSign.setOnClickListener{
        val currentText = txtResult.text.toString()
        txtResult.text = when {
            currentText.startsWith("-") ->
                currentText.substring(1, currentText.length)
            currentText != "0" -> "-$currentText"
            else ->return@setOnClickListener
        }
    }
    btnBackspace.setOnClickListener{
        val currentText = txtResult.text.toString()
        val newText = currentText.substring(0, currentText.length - 1)
        txtResult.text =
            if (newText.isEmpty() || newText == "-") "0" else newText
    }
    btnClear.setOnClickListener{ clearText() }
    btnPlus.setOnClickListener{ calc(OpKind.ADD) }
    btnMinus.setOnClickListener{ calc(OpKind.SUBTRACT) }
    btnTimes.setOnClickListener{ calc(OpKind.MULTIPLY) }
    btnDivide.setOnClickListener{ calc(OpKind.DIVIDE) }
    btnCalc.setOnClickListener{ calc(null) }
}

clearText()


private fun clearText() {
  binding.txtResult.text = "0"
}