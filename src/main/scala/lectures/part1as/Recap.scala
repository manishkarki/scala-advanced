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
  val incrementer = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementer(3)
}
