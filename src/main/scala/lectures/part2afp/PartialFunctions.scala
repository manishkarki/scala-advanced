package lectures.part2afp

/**
 * @author mkarki
 */
object PartialFunctions extends App {
  val aFunction = (x: Int) => x + 2 // Function[Int, Int] === Int => Int

  val aFussyFunction = (x: Int) =>
    if(x == 1) 42
    else if(x ==2) 56
    else if (x == 5) 999
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  }
  // {1, 2, 5} => Int

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  } // partial function value, equivalent of above

  println(aPartialFunction(2))
//  println(aPartialFunction(57000)) // this will fail coz we don't have any case
  // PF utilities
  println(aPartialFunction.isDefinedAt(65))

  // lift
  val lifted = aPartialFunction.lift // Int => Option[Int]
  println(lifted(2))
  println(lifted(98)) // this will print an optional

  // we can just add chaining
  val pfChain = aPartialFunction.orElse[Int, Int] {
    case 45 => 67
  }

  println(pfChain(2)) // this'll print the value from aPartialFunction
  println(pfChain(45)) // this'll get it from orElse part of pfChain

  // PF extends normal functions

  val aTotalFunction: Int => Int = {
    case 1 => 99
  }

  /*
    Note: PF can only have one parameter type
   */

  /**
   * Exercises:
   *
   * 1 - Construct a PF instance (anonymous class)
   * 2 - dumb chatbot
   */

  val pfInstance: PartialFunction[String, String] = {
    case "same" => "its same"
    case _ => "not same"
  }
}
