package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    val s5 = singletonSet(5)
    val s7 = singletonSet(7)
    val s1000 = singletonSet(1000)
    val all = union(union(s1, s2), union(s3, s4))
    val test = union(union(union(s1, s3), union(s4, s5)), union(s7, s1000)) 
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
   test("intersect") {
    new TestSets {
      assert(!contains(intersect(union(s1, s2), union(s3, s4)), 1), "empty 1")
      assert(!contains(intersect(union(s1, s2), union(s3, s4)), 2), "empty 2")
      assert(!contains(intersect(union(s1, s2), union(s3, s4)), 3), "empty 3")
      assert(!contains(intersect(union(s1, s2), union(s3, s4)), 4), "empty 4")
      assert(contains(intersect(union(s2, s3), union(s3, s4)), 3), "should have 3")
      assert(contains(intersect(union(s4, s3), union(s3, s4)), 4), "should have 4")
    }
   }
   
   test("diff") {
    new TestSets {
      assert(contains(diff(union(s1, s2), union(s3, s4)), 1), "contains 1")
      assert(contains(diff(union(s1, s2), union(s3, s4)), 2), "contains 2")
      assert(!contains(diff(union(s1, s2), union(s3, s4)), 3), "shoudn't contain 3")
      assert(!contains(diff(union(s1, s2), union(s1, s4)), 1), "shoudn't contain 1")
      assert(contains(diff(union(s1, s2), union(s1, s4)), 2), "contain 2")
    }
  }
   
  test("filter") {
    new TestSets {
      val greaterThan2 = filter(union(union(s1, s2), union(s3, s4)), (x => x > 2))
      assert(contains(greaterThan2, 3), "contains 3")
      assert(contains(greaterThan2, 4), "contains 4")
      assert(!contains(greaterThan2, 1), "no 1")
      assert(!contains(greaterThan2, 2), "no 2")
    }
  }
  
  test("forall") {
    new TestSets {
      assert(forall(all, (x => x>0)), "true")
      assert(!forall(all, (x => x>1)), "false")
      assert(!forall(all, (x => x>2)), "false")
      assert(!forall(all, (x => x>3)), "false")
    }
  }
  
  test("exists") {
    new TestSets {
      assert(exists(all, (x => x>0)), "true")
      assert(exists(all, (x => x>1)), "true")
      assert(exists(all, (x => x>2)), "true")
      assert(exists(all, (x => x>3)), "true")
      assert(exists(all, (x => x>=4)), "true")
      assert(exists(all, (x => x>4)) == false, "false")
    }
  }
  
  test("map") {
    new TestSets {
      assert(contains(map(s1, (x => x*2)), 2))
      assert(contains(map(s3, (x => x*2)), 6))
      assert(contains(map(s2, (x => x*2)), 4))
      assert(!contains(map(s2, (x => x*2)), 2))
      val result = map(test, (x => x-1))
      for (a <- List (0,2,3,4,6,999)) {
    	  assert(contains(result, a))
      }
        for (a <- List (-1,1,5,7,8,1000)) {
    	  assert(!contains(result, a))
      }
    }
  }
}
