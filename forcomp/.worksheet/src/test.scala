 abstract class List[T] {
	def map[U](f: T=>U) : List[U] = this match {
		case Nil => this
		case x::xs  => f(x) :: xs.map(f)
	}
	
	def filter(p:T=>Boolean) : List[T] = this match {
			case Nil => this
		  case x::xs  => if (p(x)) x :: xs.filter(p) else xs.filter(p)
	}
}

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(304); val res$0 = 
  "abcdce".toList;System.out.println("""res0: List[Char] = """ + $show(res$0))}
}
