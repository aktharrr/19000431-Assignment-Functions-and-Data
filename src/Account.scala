class Account ( x:String , y: Int , z : Double){

  val NIC : String = x
  val accNumber : Int = y
  var bal : Double = z

  def withdraw( amount : Double ) = this.bal -= amount
  def deposit ( amount : Double ) = this.bal += amount

  def transfer( amount : Double , that : Account ): Unit = {
    this.bal =  this.bal - amount
    that.bal = that.bal + amount
  }


  @Override
  override def toString() : String = "NIC: " + this.NIC + "\n Account Number: " + this.accNumber + "\n Balance: " + this.bal

}