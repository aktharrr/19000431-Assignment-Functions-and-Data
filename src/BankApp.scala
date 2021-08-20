object BankApp extends App {

  var bank : List[Account] = List( new Account("991773339v" , 1001239 , -59995) , new Account("990000009v" , 1001245 , 26700) )

  val overdraft = ( b : List[Account] ) => b.filter( x => x.bal < 0)
  val balance = ( b: List[Account] ) => b.map( x => (x,x.bal) ).reduce( (a , c) => ( c._1 , a._2 + c._2) )

  val interest = ( b : List[Account] ) => b.map( x => {
    x.bal match {
      case a if a >= 0 => x deposit x.bal * 0.05
      case _ => x withdraw Math.abs(x.bal) * 0.01

    }
    x
  })


  println("Overdraft Accounts " + overdraft( bank ) )
  println()
  println("Total Balance " + balance( bank )._2 )
  println()

  bank = interest( bank )

  println("All Accounts " + bank )
  println()
  println("Total Balance " + balance( bank )._2 )
  println()

}