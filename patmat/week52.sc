object week52 {
  val fruit = List("applies", "oranges", "pears") //> fruit  : List[String] = List(applies, oranges, pears)
  val nums = List(1, 2, 3)                        //> nums  : List[Int] = List(1, 2, 3)
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
  val empty = List()                              //> empty  : List[Nothing] = List()
  
  
	 def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
	 
  val pair = ("answer", 42)                       //> pair  : (String, Int) = (answer,42)
  
  List(('a', 1), ('b', 2) ,('c', 3)).find {e  => e._1 == 4} != None
                                                  //> res0: Boolean = false
 
}