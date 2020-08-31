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

  println(mathProperty)
}
