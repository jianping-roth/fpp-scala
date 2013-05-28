import math.Ordering

object week6 {
 	def scaleList(xs: List[Double], factor: Double) : List[Double] = xs match {
 		case Nil => xs
 		case x :: rest => x*factor :: scaleList(rest, factor)
 	}
 	
 	scaleList(List(1,2,3), 3)
 	def scaleList2(xs: List[Double], factor: Double) : List[Double] = xs map(x => x * factor)
  def squareList(xs: List[Double]) : List[Double] = xs match {
 		case Nil => xs
 		case x::rest => x*x :: squareList(rest)
 	}

  	 	squareList(List(1,2,3))
 	def squareList2(xs: List[Double]) : List[Double] = xs map(x => x * x)
  	squareList2(List(1,2,3))


  	  	
  	def posElems(xs: List[Int]) : List[Int] = xs match {
  	 case Nil => xs
  	 case y :: ys => {
  	 if (y > 0) y :: posElems(ys)  else posElems(ys)
  	 }
  	}
  	
  	posElems(List(-1, 0, 1))
  	
  	def postElems2(xs: List[Int]) : List[Int] = xs filter (x => x > 0)
  	
  	val nums = List(2, -4, 5, 7, 1)
  	val fruits = List("apple", "pinapple", "orange", "banana")
  	
  	nums filter (x => x > 0)
  	nums filterNot(x => x > 0)
		nums partition(x => x > 0)
		nums takeWhile(x => x > 0)
		nums dropWhile(x => x > 0)
		nums span (x => x > 0)
		
		def pack[T](xs : List[T]) : List[List[T]] = xs match {
			case Nil => Nil
			//case y :: ys => y :: ys filter(x => x == y) :: pack(ys filterNot(x => x == y))
			case y::ys =>
			  val (first, rest) = xs span (x => x == y)
			  first :: pack(rest)
		}
		
	 def pack2[T](xs : List[T]) : List[List[T]] = xs match {
			case Nil => Nil
			//case y :: ys => y :: ys filter(x => x == y) :: pack(ys filterNot(x => x == y))
			case y::ys =>
			  val (first, rest) = xs partition (x => x == y)
			  first :: pack(rest)
		}
		
		pack2(List("a", "a", "a", "b", "c", "c", "a"))
                                                  
    def encode[T](xs: List[T]) : List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length))
    
		encode(List("a", "a", "a", "b", "c", "c", "a"))
        
    List(1,2,3,4).take(2)
    
    List(1,2,3,4).drop(2)

}