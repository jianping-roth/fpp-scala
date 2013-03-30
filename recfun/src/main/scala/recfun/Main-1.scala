package recfun
import common._

object ABC {
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
    def doBalance(numOpens: Int, chars: List[Char]): Boolean = {
      if (numOpens < 0) false
      else if (chars.isEmpty) true
      else if (chars.head == '(') doBalance(numOpens + 1, chars.tail)
      else if (chars.head == ')') doBalance(numOpens - 1, chars.tail)
      else doBalance(numOpens, chars.tail)
    }

    doBalance(0, chars)
  }

  /**
   * Exercise 3
   */
//  def countChange1(money: Int, coins: List[Int]): Int = {
//    def compute(money: Int, coins: List[Int]): Int = {
//      if (money < 0) 0
//      else if (money == 0) 1
//      else if (coins.isEmpty) 0
//      else {
//        var total = 0
//        for (count <- 0 to money / coins.head) {
//          total = total + compute(money - coins.head * count, coins.tail)
//        }
//        total
//      }
//    }
//
//    if (money == 0) 0 else if (coins.isEmpty) 0 else {
//      compute(money, coins)
//    }
//  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def compute(total: Int, money: Int, coins: List[Int]): Int = {
      if (money < 0) total
      else if (money == 0) total+1
      else if (coins.isEmpty) total
      else compute(total, money - coins.head, coins) + compute(total, money, coins.tail)
    }

    if (money == 0) 0 else if (coins.isEmpty) 0 else compute(0, money, coins)
  }
  
//  def factLoop (total : Int, n : Int) : Int = {
//    if (n == 0) total
//    else factLoop(total*n, n-1)
//  }
//  
//  def fact(n: Int) = factLoop(1, n)
}
