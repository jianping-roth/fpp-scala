object week62 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(43); val res$0 = 
     List(1,2,3).length / 2;System.out.println("""res0: Int = """ + $show(res$0));$skip(534); 
     
     def msort[T](xs: List[T])(implicit ord: Ordering[T]) : List[T] = {
       val n = xs.length / 2
       if (n == 0) xs
       else {
           def merge(l1: List[T], l2: List[T]): List[T] = {
		        (l1, l2) match {
		           case (Nil, ys) => ys
		           case (xs, Nil) => xs
		           case (x :: xs, y :: ys) =>
		           if (ord.lt(x, y)) x :: merge(xs, l2)
		           else y :: merge(l1, ys)
		        }
       		}
        val (l1, l2) = xs splitAt n
        merge(msort(l1), msort(l2))
      }
    };System.out.println("""msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]""");$skip(41); 
    
    val nums1 = List(2,-4, 5, 7, 1);System.out.println("""nums1  : List[Int] = """ + $show(nums1 ));$skip(49); 
    val fruits2 = List("pear", "apple","orange");System.out.println("""fruits2  : List[String] = """ + $show(fruits2 ));$skip(28); val res$1 = 
    msort(nums1: List[Int]);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(33); val res$2 = 
    msort(fruits2: List[String]);System.out.println("""res2: List[String] = """ + $show(res$2));$skip(87); 
    
    def concat[T](xs: List[T], ys: List[T]) : List[T] = (xs foldRight ys)(_ :: _);System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(53); val res$3 = 
    concat(List(2,-4, 5, 7, 1), List(2,-4, 5, 7, 1));System.out.println("""res3: <error> = """ + $show(res$3));$skip(104); 
   
    def mapFun[T, U](xs: List[T], f: T => U) : List[U] =
      (xs foldRight List[U]()) (f(_) :: _);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(86); 
          
    def lengthFun[T] (xs: List[T])  : Int =
      (xs foldRight 0) (1 + _);System.out.println("""lengthFun: [T](xs: List[T])Int""");$skip(51); val res$4 = 
      
    (xs ++ ys) map f = xs map f ++ ys map f;System.out.println("""res4: <error> = """ + $show(res$4));$skip(45); val res$5 = 
    
    //need to proof
    Nil map f = Nil;System.out.println("""res5: <error> = """ + $show(res$5));$skip(39); val res$6 = 
    (x::xs) map f = f(x) :: (xs map f);System.out.println("""res6: <error> = """ + $show(res$6))}
}
