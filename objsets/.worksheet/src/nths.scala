import week4._
import java.lang.IndexOutOfBoundsException

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object nths {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(489); 
  def singleton[T](elem: T) = new Cons[T](elem: T, new Nil[T]);System.out.println("""singleton: [T](elem: T)Cons[T]""");$skip(15); val res$0 = 
  singleton(1);System.out.println("""res0: Cons[Int] = """ + $show(res$0));$skip(18); val res$1 = 
  singleton(true);System.out.println("""res1: Cons[Boolean] = """ + $show(res$1));$skip(177); 

  def nth[T](n: Int, list: List[T]) : T = {
    if (n == 0)
      if (list.isEmpty) throw new IndexOutOfBoundsException
      else list.head
    else nth(n - 1, list.tail)
  };System.out.println("""nth: [T](n: Int, list: List[T])T""");$skip(26); val res$2 = 
  
  nth(0, singleton(1));System.out.println("""res2: Int = """ + $show(res$2));$skip(44); val res$3 = 
  nth(1, new Cons(1, new Cons(2, new Nil)));System.out.println("""res3: Int = """ + $show(res$3))}
}
