object week64 {
  
  case class Person(name: String, age: Int)
  val persons = List(Person("a", 1), Person("b", 21))
                                                  //> persons  : List[week64.Person] = List(Person(a,1), Person(b,21))
  for (p <- persons if p.age > 20) yield p.name   //> res0: List[String] = List(b)
  
  persons filter (p => p.age > 20) map (_.name)   //> res1: List[String] = List(b)
   def isPrime(n: Int) : Boolean =
 if (n <= 2) true
 else (2 until n) forall (n % _ != 0)             //> isPrime: (n: Int)Boolean
 
  for {
    i <- 1 until 7
    j <- 1 until i
    if isPrime(i+j)
  } yield (i, j)                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
 ( (List(1) zip List(2)) map (x => x._1+x._2)) sum//> res3: Int = 3

  //def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
   // (for (x <- (xs zip ys)) yield x._1+x._2) sum
   
  ( "Epersonalized".toLowerCase groupBy( x => x) toList) map (x => (x._1, x._2.length))
                                                  //> res4: List[(Char, Int)] = List((e,3), (s,1), (n,1), (a,1), (i,1), (l,1), (p,
                                                  //| 1), (r,1), (o,1), (z,1), (d,1))
     
  List(List()) map (println _)                    //> List()
                                                  //| res5: List[Unit] = List(())
                                                  
   for (i <- List("1","3","5")) yield (
      for (j <- List(List())) yield (i :: j)      //> res6: List[List[List[String]]] = List(List(List(1)), List(List(3)), List(Lis
                                                  //| t(5)))
   )
  
    List("1","3","5").foldLeft ("") ( _ + _)      //> res7: String = 135
  val engToDeu = Map(("dog","Hund"), ("cat","Katze"), ("rhinoceros","Nashorn"))
                                                  //> engToDeu  : scala.collection.immutable.Map[String,String] = Map(dog -> Hund,
                                                  //|  cat -> Katze, rhinoceros -> Nashorn)
  engToDeu("cat")                                 //> res8: String = Katze
  
  val list1=  List(('a', 1), ('b', 2))            //> list1  : List[(Char, Int)] = List((a,1), (b,2))
  val list2 = List(list1)                         //> list2  : List[List[(Char, Int)]] = List(List((a,1), (b,2)))
  for (l <- list1) yield ( for (r <- list2) yield (l::r)) flatten
                                                  //> res9: List[List[(Char, Int)]] = List(List((a,1), (a,1), (b,2)), List((b,2),
                                                  //|  (a,1), (b,2)))
                                                  
	 List(('a', 1), ('b', 2)) foreach print _
}