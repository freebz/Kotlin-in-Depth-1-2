// 15.2.4 액티비티 상태 유지하기

override fun onSaveInstanceState(outState: Bundle) {
  super.onSaveInstanceState(outState)
  outState.putString("currentText", txtResult.text.toString())
  outState.putSerializable(::lastResult.name, lastResult)
  outState.putSerializable(::lastOp.name, lastOp)
  outState.putBoolean(::waitingNextOperand.name, waitingNextOperand)
}


override fun onCreate(savedInstanceState: Bundle?) {
  ...

  clearText()

  savedInstanceState?.let {
    binding.txtResult.text = it.getString("currentText")
    lastResult = it.getSerializable(::lastResult.name) as BigDecimal
    lastOp = it.getSerializable(::lastOp.name) as OpKind?
    waitingNextOperand = it.getBoolean(::waitingNextOperand.name)
  }
}