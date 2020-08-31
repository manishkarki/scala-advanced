package lectures.part1as

import scala.annotation.tailrec

/**
 * @author mkarki
 */
object Recap extends App {
  val condition = false
  val aCodeBlock = {
    if(true) 54 // value of codeBlock is last line so this block is almost unused
    72
  }
  print(aCodeBlock)

  // functions
  def aFunction(i: Int): Int = i + 1

  def gcd(a: Int, b: Int): Int = {
    if(b == 0)
      a
    else
      gcd(b, b % a)
  }

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0)
        result
      else iter(x - 1, result * x)

    iter(n, 0)
  }

  println(factorial(6))

  // functional programming
  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementer(3)

  // the above can be replaced with syntactic sugar that'll resolve to type of Function1
  val anonymousIncrementer = (x: Int) => x + 1

  // applying incrementer to the list
  List(1, 2, 3)
    .map(anonymousIncrementer)

  // for comprehensions
  val pairs = for {
    num <- List(1, 2, 3)
    char <- List('a', 'b', 'c')
  } yield num + '-' + char

}
