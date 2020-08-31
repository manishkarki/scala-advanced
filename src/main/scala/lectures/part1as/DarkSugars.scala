package lectures.part1as

/**
 * @author mkarki
 */
object DarkSugars extends App {

  // syntax sugar #1: methods with single param
  def singleArgMethod(arg: Int): String = s"$arg little ducks.."

  val description = singleArgMethod {
    // write something and then return the result
    42
  }
}
