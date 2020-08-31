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

  // syntactic sugar $2: Single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

  // identically above two things are same

  // Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello, scala")
  })

  val nicerThread = new Thread(() => println("Hello scala thread using lambda/anonymous"))

  abstract  class AnAbstractType {
    def implementedMethod: Int = 25
    def f(a: Int = 2): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("done")

  // syntax sugar #3: th ::
  val prependedList = 2 :: List(3, 4)

  // scala spec: last char decides associativity of method
  // i.e if char is : right associative
  println(1 :: 2 :: 3 :: List(5, 6, 7))

}
