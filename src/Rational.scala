class Rational( x:Int , y:Int ) {

  require(y>0 , "Denominator > 0")

  private def gcd( a:Int , b:Int ):Int = {
    if ( b == 0 ) a
    else if ( b > a ) gcd( b , a )
    else gcd( b, a%b )
  }


  private val g = gcd(Math.abs(x) , y)

  val numerator = x/g
  val denominator = y/g

  def this ( x : Int ) = this( x , 1 )
  def + ( that : Rational ) :Rational = new Rational( this.numerator * that.denominator + that.numerator * this.denominator  , this.denominator * that.denominator )
  def neg : Rational = new Rational( -this.numerator , this.denominator )
  def - ( that : Rational ) : Rational = this + that.neg
  def * ( that : Rational ) : Rational = new Rational( this.numerator * that.numerator , this.denominator * that.denominator )
  def / ( that : Rational ) : Rational = new Rational( this.numerator * that.denominator , this.denominator * that.numerator )

  @Override
  override def toString() : String = {

    denominator match {
      case x if x==1 => numerator.toString
      case _ => numerator + "/" + denominator
    }

  }
}