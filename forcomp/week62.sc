object week62 {
     List(1,2,3).length / 2
     
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
    }
    
    val nums1 = List(2,-4, 5, 7, 1)
    val fruits2 = List("pear", "apple","orange")
    msort(nums1: List[Int])
    msort(fruits2: List[String])
    
    def concat[T](xs: List[T], ys: List[T]) : List[T] = (xs foldRight ys)(_ :: _)
    concat(List(2,-4, 5, 7, 1), List(2,-4, 5, 7, 1))
   
    def mapFun[T, U](xs: List[T], f: T => U) : List[U] =
      (xs foldRight List[U]()) (f(_) :: _)
          
    def lengthFun[T] (xs: List[T])  : Int =
      (xs foldRight 0) (1 + _)
      
    (xs ++ ys) map f = xs map f ++ ys map f
    
    //need to proof
    Nil map f = Nil
    (x::xs) map f = f(x) :: (xs map f)
}