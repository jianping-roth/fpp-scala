package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)

    val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
    val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

    lazy val googleTweets: TweetSet = TweetReader.allTweets.filter { tweet =>
      google.exists { listElement => tweet.text.contains(listElement) }
    }

    lazy val appleTweets: TweetSet = TweetReader.allTweets.filter { tweet =>
      apple.exists { listElement => tweet.text.contains(listElement) }
    }
    
      lazy val trending: TweetList = googleTweets.union(appleTweets).descendingByRetweet
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }

  test("most tweeted empty: set1") {
    new TestSets {
      val most = set1.mostRetweeted
      assert(most.retweets < 0)
    }
  }
  
  test("most tweeted google: google") {
    new TestSets {
      val most = googleTweets.mostRetweeted
      assert(most.retweets == 290)
    }
  } 
  
    test("most tweeted apple: apple") {
    new TestSets {
      val most = appleTweets.mostRetweeted
      assert(most.retweets == 321)
    }
  } 
    
  test("apple trending: apple") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      assert (counting(appleTweets.descendingByRetweet, 0) == 150)
    }
  } 
  
  test("google descendingByRetweet: google") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting(googleTweets.descendingByRetweet, 0) == 38)
    }
  } 
  
    test("google trending: google") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      assert (counting(trending, 0) == 179)
    }
  }
    
  test("google union google") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting(googleTweets.union(googleTweets).descendingByRetweet, 0) == 38)
    }
  } 
  
    test("apple union apple") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting(appleTweets.union(appleTweets).descendingByRetweet, 0) == 150)
    }
  } 
    
  test("apple union empty") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting(appleTweets.union(new Empty).descendingByRetweet, 0) == 150)
    }
  } 
  
    test("empty union apple") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting((new Empty).union(appleTweets).descendingByRetweet, 0) == 150)
    }
  }
    
   test("empty union google") {
    new TestSets {
      def counting (list : TweetList, count : Int) : Int = {
         if (list.isEmpty) count
         else counting(list.tail, count+1)
      }
      
      assert (counting((new Empty).union(googleTweets).descendingByRetweet, 0) == 38)
    }
  }
}
