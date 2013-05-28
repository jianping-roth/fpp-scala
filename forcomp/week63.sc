import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object week63 {


 List(1,3,5).foldLeft(0) { _ + _ }

 List(1,3,5).foldLeft(0)((r,c) => r+c)
  List("1","3","5").foldLeft ("") ( _ + _)
  List("1","3","5").foldLeft("")((l,c) => c+l)
  List("1","3","5").foldLeft("")((l,c) => l+c)
  List("1","3","5").foldRight("")((r,c) => r+c)
  List("1","3","5").foldRight("")((r,c) => c+r)
  
  Array(1,2,3) map (x => 2*x)
  "Abc" filter (_.isUpper)
 
 val r: Range = 1 until 5
  val s: Range = 1 to 5
  1 to 10 by 3
  6 to 1 by -1

  
  val ss = "Hello World"
  
  ss exists (x => x.isUpper)
  ss forall (x => x.isUpper)
  
  val pairs = List(1,2,3) zip ss
  pairs unzip
  
  ss flatMap ( c => List('.', c))
  r flatMap ( c => List('.', c))
  List(1,2,3).sum
  List(1,2,3).product
  List(1,2,3).max
  List(1,2,3) ::: List(4,2,3)
  List(1,2,3) ++ List(4,2,3)
    
  // to list all combinations of numbers x and y where x is drawn from 1..M
  // and y 1..N
 // (1 to M) flatMap (x => (1..N) map (y=> (x, y)))
 
 // To compute the scalar product of two vectors
 def scalarProduct(xs: Vector[Double], ys: Vector[Double]) : Double =
    (xs zip ys).map (xy => xy._1 * xy._2).sum
    
 def isPrime(n: Int) : Boolean =
 if (n <= 2) true
 else (2 until n) forall (n % _ != 0)
 isPrime(7)
 isPrime(21)
  val xss = (1 until 7) map (i =>
   (1 until i) map (j => (i, j)))
  xss.flatten
 // (xss foldRight List()) (_ ++ _)
 
 xss flatten
 
 val xss2 = (1 until 7) flatMap (i =>
   (1 until i) map (j => (i, j))) filter (x => isPrime(x._1+x._2))

  List(1,2,3) match {
    case Nil => println("empty")
    case x::xs => println(x)
  }
 
 (1 to 2) map (k => (2, k))
 }