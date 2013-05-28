
object funcset {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")
  import funsets.FunSets._;$skip(45); val res$0 = 
  singletonSet(1);System.out.println("""res0: Int => Boolean = """ + $show(res$0));$skip(42); 
    println(contains(singletonSet(1), 1));$skip(62); val res$1 = 
    
    contains(union(singletonSet(1), singletonSet(1)), 3);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(61); val res$2 = 
    contains(intersect(singletonSet(1), singletonSet(1)), 1);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(61); val res$3 = 
    contains(intersect(singletonSet(2), singletonSet(1)), 1);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(43); val res$4 = 
    diff(singletonSet(2), singletonSet(1));System.out.println("""res4: Int => Boolean = """ + $show(res$4));$skip(117); val res$5 = 
                                                  
    diff(diff(singletonSet(2), singletonSet(1)), singletonSet(2));System.out.println("""res5: Int => Boolean = """ + $show(res$5));$skip(130); val res$6 = 
                                                  
    contains(diff(diff(singletonSet(2), singletonSet(1)), singletonSet(2)), 5);System.out.println("""res6: Boolean = """ + $show(res$6));$skip(139); val res$7 = 
                                                  
    filter(union(union(singletonSet(2), singletonSet(1)), singletonSet(2)), x => x >=2);System.out.println("""res7: Int => Boolean = """ + $show(res$7));$skip(92); val res$8 = 
    filter(union(union(singletonSet(2), singletonSet(1)), singletonSet(2)), x => x >=2) (3);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(29); 
    val s1 = singletonSet(1);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(29); 
    val s2 = singletonSet(2);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(29); 
    val s3 = singletonSet(3);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(29); 
    val s4 = singletonSet(4);System.out.println("""s4  : Int => Boolean = """ + $show(s4 ));$skip(29); 
    val s5 = singletonSet(5);System.out.println("""s5  : Int => Boolean = """ + $show(s5 ));$skip(29); 
    val s7 = singletonSet(7);System.out.println("""s7  : Int => Boolean = """ + $show(s7 ));$skip(35); 
    val s1000 = singletonSet(1000);System.out.println("""s1000  : Int => Boolean = """ + $show(s1000 ));$skip(50); 
    val all = union(union(s1, s2), union(s3, s4));System.out.println("""all  : Int => Boolean = """ + $show(all ));$skip(76); 
    val test = union(union(union(s1, s3), union(s4, s5)), union(s7, s1000));System.out.println("""test  : Int => Boolean = """ + $show(test ));$skip(19); 
    printSet(test);$skip(38); 
    printSet(map(test, (x => x - 1)));$skip(38); 
    printSet(map(test, (x => x * 2)))}
                                                  
}
