package lectures.part1as

/**
 * @author mkarki
 */
object AdvancedPatternMatching extends App {
  val numbers = List(1)

  val desc = numbers match {
    case head :: Nil => println(s"the only element is $head")
    case _ =>
  }

  /*
      - constants
      - wildcards
      - case classes
      - tuples

   */

}
