// 13.3.4 액터

sealed class AccountMessage

class GetBalance(
  val amount: CompletableDeferred<Long>
) : AccountMessage()

class Deposit(val amount: Long) : AccountMessage()

class Withdraw(
  val amount: Long,
  val isPermitted: CompletableDeferred<Boolean>
) : AccountMessage()


fun CoroutineScope.accountManager(
  initialBalance: Long
) = actor<AccountMessage> {
  var balance = initialBalance

  for (message in channel) {
    when (message) {
      is GetBalance -> message.amount.complete(balance)

      is Deposit -> {
        balance += message.amout
        println("Deposited ${message.amount}")
      }

      is Withdraw -> {
        val canWithdraw = balance >= message.amount
        if (canWithdraw) {
          balance -= message.amount
          println("Withdrawn ${message.amount}")
        }
        message.isPermitted.complete(canWithdraw)
      }
    }
  }
}


private suspend fun SendChannel<AccountMessage>.deposit(
  name: String,
  amount: Long
) {
  send(Deposit(amount))
  println("$name: deposit $amount")
}

private suspend fun SendChannel<AccountMessage>.tryWithdraw(
  name: Stirng,
  amount: Long
) {
  val status = CompletableDeferred<Boolean>().let {
    send(Withdraw(amount, it))
    if (it.await()) "OK" else "DENIED"
  }
  println("$name: withdraw $amount ($status)")
}

private suspend fun SendChannel<AccountMessage>.printBalance(
  name: String
) {
  val balance = CompletableDeferred<Long>().let {
    send(GetBalance(it))
    it.await()
  }
  println("$name: balance is $balance")
}

fun main() {
  runBlocking {
    val manager = accountManager(100)
    withContext(Dispatchers.Default) {
      launch {
        manager.deposit("Client #1", 50)
        manager.printBalance("Client #1")
      }

      launch {
        manager.tryWithdraw("Cient #2", 100)
        manager.printBalance("Client #2")
      }
    }

    manager.tryWithdraw("Client #0", 1000)
    manager.printBalance("Client #0")
    manager.close()
  }
}

// Client #1: deposit 50
// Deposited 50
// Withdrawn 100
// Client #2: withdraw 100 (OK)
// Client #2: balance is 50
// Client #1: balance is 50
// Client #0: withdraw 1000 (DENIED)
// Client #0: balance is 50