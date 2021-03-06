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

  val nicerThread = new Thread(
    () => println("Hello scala thread using lambda/anonymous"))

  abstract class AnAbstractType {
    def implementedMethod: Int = 25
    def f(a: Int = 2): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("done")

  // syntax sugar #3: th ::
  val prependedList = 2 :: List(3, 4)

  // scala spec: last char decides associativity of method
  // i.e if char is : right associative
  1 :: 2 :: 3 :: List(4, 5)
  List(4, 5).::(3).::(2).::(1) // equivalent

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this // actual impl
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // syntax sugar #4: multi-word method naming
  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is nice"

  // syntax sugar $5: infix types
  class Composite[A, B]
  val composite: Composite[Int, String] = ???
  val compositeInfix: Int Composite String = ??? // identicals

  class -->[A, B]
  val towards: Int --> String = ???

  // syntax sugar $6: update, much like apply
  val anArray = Array(1, 2, 3)
  anArray(2) = 7 // rewritten to anArray.update(2, 7)
  // update is used in mutable collections

  // // syntax sugar $7: setters for mutable container
  class Mutable {
    private var internalMember: Int = 0 // private for oo encapsulation
    def member: Int = internalMember
    def member_=(value: Int): Unit =
      internalMember = value // setter
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritten as aMutable.member_= 42
}
