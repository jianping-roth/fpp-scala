import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object week63 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(117); val res$0 = 


 List(1,3,5).foldLeft(0) { _ + _ };System.out.println("""res0: Int = """ + $show(res$0));$skip(40); val res$1 = 

 List(1,3,5).foldLeft(0)((r,c) => r+c);System.out.println("""res1: Int = """ + $show(res$1));$skip(43); val res$2 = 
  List("1","3","5").foldLeft ("") ( _ + _);System.out.println("""res2: String = """ + $show(res$2));$skip(47); val res$3 = 
  List("1","3","5").foldLeft("")((l,c) => c+l);System.out.println("""res3: String = """ + $show(res$3));$skip(47); val res$4 = 
  List("1","3","5").foldLeft("")((l,c) => l+c);System.out.println("""res4: String = """ + $show(res$4));$skip(48); val res$5 = 
  List("1","3","5").foldRight("")((r,c) => r+c);System.out.println("""res5: String = """ + $show(res$5));$skip(48); val res$6 = 
  List("1","3","5").foldRight("")((r,c) => c+r);System.out.println("""res6: String = """ + $show(res$6));$skip(33); val res$7 = 
  
  Array(1,2,3) map (x => 2*x);System.out.println("""res7: Array[Int] = """ + $show(res$7));$skip(27); val res$8 = 
  "Abc" filter (_.isUpper);System.out.println("""res8: String = """ + $show(res$8));$skip(28); 
 
 val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(24); 
  val s: Range = 1 to 5;System.out.println("""s  : Range = """ + $show(s ));$skip(15); val res$9 = 
  1 to 10 by 3;System.out.println("""res9: scala.collection.immutable.Range = """ + $show(res$9));$skip(15); val res$10 = 
  6 to 1 by -1;System.out.println("""res10: scala.collection.immutable.Range = """ + $show(res$10));$skip(29); 

  
  val ss = "Hello World";System.out.println("""ss  : String = """ + $show(ss ));$skip(32); val res$11 = 
  
  ss exists (x => x.isUpper);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(29); val res$12 = 
  ss forall (x => x.isUpper);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(36); 
  
  val pairs = List(1,2,3) zip ss;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(14); val res$13 = 
  pairs unzip;System.out.println("""res13: (List[Int], List[Char]) = """ + $show(res$13));$skip(37); val res$14 = 
  
  ss flatMap ( c => List('.', c));System.out.println("""res14: String = """ + $show(res$14));$skip(33); val res$15 = 
  r flatMap ( c => List('.', c));System.out.println("""res15: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$15));$skip(18); val res$16 = 
  List(1,2,3).sum;System.out.println("""res16: Int = """ + $show(res$16));$skip(22); val res$17 = 
  List(1,2,3).product;System.out.println("""res17: Int = """ + $show(res$17));$skip(18); val res$18 = 
  List(1,2,3).max;System.out.println("""res18: Int = """ + $show(res$18));$skip(30); val res$19 = 
  List(1,2,3) ::: List(4,2,3);System.out.println("""res19: List[Int] = """ + $show(res$19));$skip(29); val res$20 = 
  List(1,2,3) ++ List(4,2,3);System.out.println("""res20: List[Int] = """ + $show(res$20));$skip(316); 
    
  // to list all combinations of numbers x and y where x is drawn from 1..M
  // and y 1..N
 // (1 to M) flatMap (x => (1..N) map (y=> (x, y)))
 
 // To compute the scalar product of two vectors
 def scalarProduct(xs: Vector[Double], ys: Vector[Double]) : Double =
    (xs zip ys).map (xy => xy._1 * xy._2).sum;System.out.println("""scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(94); 
    
 def isPrime(n: Int) : Boolean =
 if (n <= 2) true
 else (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(12); val res$21 = 
 isPrime(7);System.out.println("""res21: Boolean = """ + $show(res$21));$skip(13); val res$22 = 
 isPrime(21);System.out.println("""res22: Boolean = """ + $show(res$22));$skip(68); 
  val xss = (1 until 7) map (i =>
   (1 until i) map (j => (i, j)));System.out.println("""xss  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[(Int, Int)]] = """ + $show(xss ));$skip(14); val res$23 = 
  xss.flatten;System.out.println("""res23: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$23));$skip(51); val res$24 = 
 // (xss foldRight List()) (_ ++ _)
 
 xss flatten;System.out.println("""res24: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$24));$skip(107); 
 
 val xss2 = (1 until 7) flatMap (i =>
   (1 until i) map (j => (i, j))) filter (x => isPrime(x._1+x._2));System.out.println("""xss2  : scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(xss2 ));$skip(89); 

  List(1,2,3) match {
    case Nil => println("empty")
    case x::xs => println(x)
  };$skip(30); val res$25 = 
 
 (1 to 2) map (k => (2, k));System.out.println("""res25: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$25));$skip(98); 
 
  val combinations = List(('a',3), ('b', 2)) map (e =>
    (1 to e._2) map (k => (e._1, k))
  );System.out.println("""combinations  : List[scala.collection.immutable.IndexedSeq[(Char, Int)]] = """ + $show(combinations ));$skip(23); 
  
  def combine (e) :;System.out.println("""combine: (e: <error>)Unit""")}
 }
