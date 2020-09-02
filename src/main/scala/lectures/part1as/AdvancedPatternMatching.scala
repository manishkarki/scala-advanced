package lectures.part1as

/**
 * @author mkarki
 */
object AdvancedPatternMatching extends App {
  val numbers = List(1)

  val desc = numbers match {
    case head :: Nil => s"the only element is $head"
    case _ =>
  }

  /*
      - constants
      - wildcards
      - case classes
      - tuples

   */
  class Person(val name: String, val age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))

    def unapply(age: Int): Option[String] = Some(if(age > 21) "major" else "minor")
  }

  val bob = new Person("Bob", 23)
  val greet = bob match {
    case Person(name, age) => s"Hi, my name is $name and I'm $age y.o"
  }

  val legalStatus = bob.age match {
    case Person(status) => s"My legal status is : $status"
  }
  /*
      Exercise.
   */
  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }

  object singleDigit {
    def unapply(arg: Int): Boolean = arg > -10 && arg < 10
  }

  val n: Int = 8
  val mathProperty = n match {
    case singleDigit() => "Single digit"
    case even() => "even number"
    case _ => "no property"
  }

  // infix patterns
  case class Or[A, B](a: A, b: B)
  val either = Or(2, "two")

  val humanDescription = either match {
    case num Or str => s"$num is written as $str"
  }

  // decomposing a sequence
  val vararg = numbers match {
    case List(1, _*) => "starting with 1"
  }

  abstract class MyList[+A] {
    def head: A = ???
    def tail: MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] = {
      if(list == Empty) Some(Seq.empty)
      unapplySeq(list.tail).map(list.head +: _)
    }
  }

}
