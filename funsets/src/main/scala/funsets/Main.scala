package funsets

object Main extends App {
  import FunSets._
 
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    val s5 = singletonSet(5)
    val s7 = singletonSet(7)
    val s1000 = singletonSet(1000)
    val all = union(union(s1, s2), union(s3, s4))
    val test = union(union(union(s1, s3), union(s4, s5)), union(s7, s1000)) 
        
    println(exists(all, (x => x>4)))
        
}
