package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c < 0 || r < 0) throw new IllegalAccessException()
    else if (c == 0 || c == r || r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var total = 0

    def doBalance(chars: List[Char]): Boolean = {
      if (chars.isEmpty) return true
      else if (chars.head == '(') total = total + 1;
      else if (chars.head == ')') {
        total = total - 1
        if (total < 0) return false
      }
      doBalance(chars.tail)
    }

    doBalance(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def compute(money: Int, coins: List[Int]): Int = {
      if (money < 0) 0 
      else if (money == 0) 1
      else if (coins.isEmpty) 0
      else {
        var total = 0
        for (count <- 0 to money / coins.head) {
          total = total + compute(money - coins.head * count, coins.tail)
        }
        total
      }
    }
    if (money == 0) 0 else if (coins.isEmpty) 0 else {
    	compute(money, coins)
    }
  }
}
