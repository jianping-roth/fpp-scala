package idealized.scala

object week5 {
}

abstract class Boolean {
	def ifThanElse[T](t: T, f: T) : T
	def && (x: Boolean => Boolean) : Boolean = ifThanElse(x, false)
	def || (x: Boolean => Boolean) : Boolean = ifThanElse(true, x)
	def unary_! : Boolean = ifThanElse(false, true)
	def == (x: Boolean=> Boolean) :Boolean = ifThanElse(x, x.unary_!)
  def != (x:Boolean  => Boolean) :Boolean = ifThanElse(x.unary_!, x)
  def < (x : Boolean => Boolean) : Boolean = ifThanElse(false , x)
		
}

object true extends Boolean {
   def ifThanElse[T](t: T, f: T) : T = t
}

object false extends Boolean {
   def ifThanElse[T](t: T, f: T) : T = f
}

class Int {
	def + (that : Double) : Double
  def + (that : Float) : Float
  def + (that : Long) : Long
  def + (that : Int) : Int
  
  def << (cnt: Int) : Int
  
  def & (that: Long) : Long
  def & (that: Int) : Int
  
  def == (that: Double) : Boolean
  def == (that: Float) : Boolean
  def == (that: Long) : Boolean
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat) : Nat
  def - (that: Nat) : Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new Error()
  def successor: Nat = new Succ(this)
  def + (that: Nat) : Nat = that
  def - (that: Nat) : Nat = if (that.isZero) this else throw new Error()
}

class Succ(n : Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def successor: Nat = new Succ(this)
  def + (that: Nat) : Nat = new Succ(n + that)
  def - (that: Nat) : Nat = if (that.isZero) this else n - that.predecessor
}
