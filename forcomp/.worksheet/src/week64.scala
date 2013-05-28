object week64 {
  
  case class Person(name: String, age: Int);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(116); 
  val persons = List(Person("a", 1), Person("b", 21));System.out.println("""persons  : List[week64.Person] = """ + $show(persons ));$skip(48); val res$0 = 
  for (p <- persons if p.age > 20) yield p.name;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(51); val res$1 = 
  
  persons filter (p => p.age > 20) map (_.name);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(91); 
   def isPrime(n: Int) : Boolean =
 if (n <= 2) true
 else (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(85); val res$2 = 
 
  for {
    i <- 1 until 7
    j <- 1 until i
    if isPrime(i+j)
  } yield (i, j);System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(54); val res$3 = 
  
 ( (List(1) zip List(2)) map (x => x._1+x._2)) sum;System.out.println("""res3: Int = """ + $show(res$3));$skip(213); val res$4 = 

  //def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
   // (for (x <- (xs zip ys)) yield x._1+x._2) sum
   
  ( "Epersonalized".toLowerCase groupBy( x => x) toList) map (x => (x._1, x._2.length));System.out.println("""res4: List[(Char, Int)] = """ + $show(res$4));$skip(37); val res$5 = 
     
  List(List()) map (println _);System.out.println("""res5: List[Unit] = """ + $show(res$5));$skip(136); val res$6 = 
                                                  
   for (i <- List("1","3","5")) yield (
      for (j <- List(List())) yield (i :: j)
   );System.out.println("""res6: List[List[List[String]]] = """ + $show(res$6));$skip(53); val res$7 = 
  
    List("1","3","5").foldLeft ("") ( _ + _);System.out.println("""res7: String = """ + $show(res$7));$skip(80); 
  val engToDeu = Map(("dog","Hund"), ("cat","Katze"), ("rhinoceros","Nashorn"));System.out.println("""engToDeu  : scala.collection.immutable.Map[String,String] = """ + $show(engToDeu ));$skip(18); val res$8 = 
  engToDeu("cat");System.out.println("""res8: String = """ + $show(res$8));$skip(42); 
  
  val list1=  List(('a', 1), ('b', 2));System.out.println("""list1  : List[(Char, Int)] = """ + $show(list1 ));$skip(26); 
  val list2 = List(list1);System.out.println("""list2  : List[List[(Char, Int)]] = """ + $show(list2 ));$skip(66); val res$9 = 
  for (l <- list1) yield ( for (r <- list2) yield (l::r)) flatten;System.out.println("""res9: List[List[(Char, Int)]] = """ + $show(res$9));$skip(94); 
                                                  
	 List(('a', 1), ('b', 2)) foreach print _}
}
