package exercises

/**
 * @author mkarki
 */
trait MySet[A] extends (A => Boolean){
  def apply(elem: A): Boolean = contains(elem)
  /*
    EXERCISE -
    implement a functional set
   */

  def contains(elem: A): Boolean
  def +(elem: A): MySet[A]
  def ++(anotherSet: MySet[A]): MySet[A]

  def map[B](f: A => B): MySet[B]
  def flatMap[B](f: A => MySet[B]): MySet[B]
  def filter(predicate: A => Boolean): MySet[A]
  def foreach(f: A => Unit): Unit

}

class EmptySet[A] extends MySet[A] {
  override def contains(elem: A): Boolean = false

  override def +(elem: A): MySet[A] = new NonEmptySet[A](elem, this)

  override def ++(anotherSet: MySet[A]): MySet[A] = anotherSet

  override def map[B](f: A => B): MySet[B] = new EmptySet[B]

  override def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]

  override def filter(predicate: A => Boolean): MySet[A] = this

  override def foreach(f: A => Unit): Unit = ()

}

class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A] {
  override def contains(elem: A): Boolean =
    elem == head || tail.contains(elem)

  override def +(elem: A): MySet[A] =
    if(this.contains(elem))
      this
    else
      new NonEmptySet[A](elem, this)

  /*
    [1 2 3] ++ [4 5] =
    [2 3] ++ [4 5] + 1
    [3] ++ [4 5] + 1 + 2
    [] ++ [4 5] + 1 + 2 + 3
    [4 5] + 1 + 2 + 3
    [4 5 1 2 3]
   */
  override def ++(anotherSet: MySet[A]): MySet[A] =
    tail ++ anotherSet + head

  override def map[B](f: A => B): MySet[B] = (tail map f) + f(head)

  override def flatMap[B](f: A => MySet[B]): MySet[B] = (tail flatMap f) ++ f(head)

  override def filter(predicate: A => Boolean): MySet[A] = {
    val filteredTail = tail filter predicate
    if(predicate(head)) filteredTail + head
    else filteredTail
  }

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }
}
