object week52 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  val fruit = List("applies", "oranges", "pears");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(27); 
  val nums = List(1, 2, 3);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(64); 
  val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1));System.out.println("""diag3  : List[List[Int]] = """ + $show(diag3 ));$skip(21); 
  val empty = List();System.out.println("""empty  : List[Nothing] = """ + $show(empty ));$skip(77); 
  
  
	 def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(31); 
	 
  val pair = ("answer", 42);System.out.println("""pair  : (String, Int) = """ + $show(pair ));$skip(71); val res$0 = 
  
  List(('a', 1), ('b', 2) ,('c', 3)).find {e  => e._1 == 4} != None;System.out.println("""res0: Boolean = """ + $show(res$0))}
 
}
