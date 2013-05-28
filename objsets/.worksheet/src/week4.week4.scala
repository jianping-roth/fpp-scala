

package week4

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
    def head : Nothing = throw new NoSuchElementException("Nil.head")
    def tail : Nothing = throw new NoSuchElementException("Nil.tail")
}

object week4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(455); 
	def singleton[T](elem :T) = new Cons[T](elem: T, new Nil[T]);System.out.println("""singleton: [T](elem: T)week4.Cons[T]""");$skip(14); val res$0 = 
	singleton(1);System.out.println("""res0: week4.Cons[Int] = """ + $show(res$0));$skip(17); val res$1 = 
	singleton(true);System.out.println("""res1: week4.Cons[Boolean] = """ + $show(res$1))}
}
