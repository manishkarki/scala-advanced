package lectures.part1as

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
}
