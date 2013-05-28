
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

object List {
	//def List(x: Int, y: Int) = List.apply(1, 2)
	def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
}

object nths {
  def singleton[T](elem: T) = new Cons[T](elem: T, new Nil[T])
  singleton(1)
  singleton(true)

  def nth[T](n: Int, list: List[T]) : T = {
    if (n == 0)
      if (list.isEmpty) throw new IndexOutOfBoundsException
      else list.head
    else nth(n - 1, list.tail)
  }
  
  nth(0, singleton(1))
  nth(1, new Cons(1, new Cons(2, new Nil)))
}