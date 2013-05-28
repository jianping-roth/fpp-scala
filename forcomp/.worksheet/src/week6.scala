import math.Ordering

object week6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(193); 
 	def scaleList(xs: List[Double], factor: Double) : List[Double] = xs match {
 		case Nil => xs
 		case x :: rest => x*factor :: scaleList(rest, factor)
 	};System.out.println("""scaleList: (xs: List[Double], factor: Double)List[Double]""");$skip(31); val res$0 = 
 	
 	scaleList(List(1,2,3), 3);System.out.println("""res0: <error> = """ + $show(res$0));$skip(92); 
 	def scaleList2(xs: List[Double], factor: Double) : List[Double] = xs map(x => x * factor);System.out.println("""scaleList2: (xs: List[Double], factor: Double)List[Double]""");$skip(128); 
  def squareList(xs: List[Double]) : List[Double] = xs match {
 		case Nil => xs
 		case x::rest => x*x :: squareList(rest)
 	};System.out.println("""squareList: (xs: List[Double])List[Double]""");$skip(30); val res$1 = 

  	 	squareList(List(1,2,3));System.out.println("""res1: <error> = """ + $show(res$1));$skip(72); 
 	def squareList2(xs: List[Double]) : List[Double] = xs map(x => x * x);System.out.println("""squareList2: (xs: List[Double])List[Double]""");$skip(28); val res$2 = 
  	squareList2(List(1,2,3));System.out.println("""res2: <error> = """ + $show(res$2));$skip(169); 


  	  	
  	def posElems(xs: List[Int]) : List[Int] = xs match {
  	 case Nil => xs
  	 case y :: ys => {
  	 if (y > 0) y :: posElems(ys)  else posElems(ys)
  	 }
  	};System.out.println("""posElems: (xs: List[Int])List[Int]""");$skip(32); val res$3 = 
  	
  	posElems(List(-1, 0, 1));System.out.println("""res3: <error> = """ + $show(res$3));$skip(74); 
  	
  	def postElems2(xs: List[Int]) : List[Int] = xs filter (x => x > 0);System.out.println("""postElems2: (xs: List[Int])List[Int]""");$skip(39); 
  	
  	val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(62); 
  	val fruits = List("apple", "pinapple", "orange", "banana");System.out.println("""fruits  : List[String] = """ + $show(fruits ));$skip(32); val res$4 = 
  	
  	nums filter (x => x > 0);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(30); val res$5 = 
  	nums filterNot(x => x > 0);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(29); val res$6 = 
		nums partition(x => x > 0);System.out.println("""res6: (List[Int], List[Int]) = """ + $show(res$6));$skip(29); val res$7 = 
		nums takeWhile(x => x > 0);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(29); val res$8 = 
		nums dropWhile(x => x > 0);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(25); val res$9 = 
		nums span (x => x > 0);System.out.println("""res9: (List[Int], List[Int]) = """ + $show(res$9));$skip(256); 
		
		def pack[T](xs : List[T]) : List[List[T]] = xs match {
			case Nil => Nil
			//case y :: ys => y :: ys filter(x => x == y) :: pack(ys filterNot(x => x == y))
			case y::ys =>
			  val (first, rest) = xs span (x => x == y)
			  first :: pack(rest)
		};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(262); 
		
	 def pack2[T](xs : List[T]) : List[List[T]] = xs match {
			case Nil => Nil
			//case y :: ys => y :: ys filter(x => x == y) :: pack(ys filterNot(x => x == y))
			case y::ys =>
			  val (first, rest) = xs partition (x => x == y)
			  first :: pack(rest)
		};System.out.println("""pack2: [T](xs: List[T])List[List[T]]""");$skip(52); val res$10 = 
		
		pack2(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res10: <error> = """ + $show(res$10));$skip(143); 
                                                  
    def encode[T](xs: List[T]) : List[(T, Int)] = pack(xs) map (ys => (ys.head, ys.length));System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(55); val res$11 = 
    
		encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res11: <error> = """ + $show(res$11));$skip(35); val res$12 = 
        
    List(1,2,3,4).take(2);System.out.println("""res12: List[Int] = """ + $show(res$12));$skip(31); val res$13 = 
    
    List(1,2,3,4).drop(2);System.out.println("""res13: List[Int] = """ + $show(res$13))}

}
