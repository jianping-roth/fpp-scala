
object funcset {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  import funsets.FunSets._
  singletonSet(1)                                 //> res0: Int => Boolean = <function1>
    println(contains(singletonSet(1), 1))         //> true
    
    contains(union(singletonSet(1), singletonSet(1)), 3)
                                                  //> res1: Boolean = false
    contains(intersect(singletonSet(1), singletonSet(1)), 1)
                                                  //> res2: Boolean = true
    contains(intersect(singletonSet(2), singletonSet(1)), 1)
                                                  //> res3: Boolean = false
    diff(singletonSet(2), singletonSet(1))        //> res4: Int => Boolean = <function1>
                                                  
    diff(diff(singletonSet(2), singletonSet(1)), singletonSet(2))
                                                  //> res5: Int => Boolean = <function1>
                                                  
    contains(diff(diff(singletonSet(2), singletonSet(1)), singletonSet(2)), 5)
                                                  //> res6: Boolean = false
                                                  
    filter(union(union(singletonSet(2), singletonSet(1)), singletonSet(2)), x => x >=2)
                                                  //> res7: Int => Boolean = <function1>
    filter(union(union(singletonSet(2), singletonSet(1)), singletonSet(2)), x => x >=2) (3)
                                                  //> res8: Boolean = false
    val s1 = singletonSet(1)                      //> s1  : Int => Boolean = <function1>
    val s2 = singletonSet(2)                      //> s2  : Int => Boolean = <function1>
    val s3 = singletonSet(3)                      //> s3  : Int => Boolean = <function1>
    val s4 = singletonSet(4)                      //> s4  : Int => Boolean = <function1>
    val s5 = singletonSet(5)                      //> s5  : Int => Boolean = <function1>
    val s7 = singletonSet(7)                      //> s7  : Int => Boolean = <function1>
    val s1000 = singletonSet(1000)                //> s1000  : Int => Boolean = <function1>
    val all = union(union(s1, s2), union(s3, s4)) //> all  : Int => Boolean = <function1>
    val test = union(union(union(s1, s3), union(s4, s5)), union(s7, s1000))
                                                  //> test  : Int => Boolean = <function1>
    printSet(test)                                //> {1,3,4,5,7,1000}
    printSet(map(test, (x => x - 1)))             //> {0,2,3,4,6,999}
    printSet(map(test, (x => x * 2)))             //> {2,6,8,10,14}
                                                  
}