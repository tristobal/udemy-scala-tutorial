package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)

  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Isaac", "Asimov", 1920)
  println(writer.fullName)

  val writer2 = new Writer("lorem", "ipsum", 2000)

  val novel = new Novel("Foundation", 1951, writer)
  println(novel.authorAge)
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(writer2))

  val novel2 = novel.copy(2021)
  println(s"${novel2.name}, ${novel2.yearRelease}, ${novel2.author.fullName}")

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

// Constructor
class Person(name: String, val age: Int = 0) {
  // this value is a class member
  val x = 2
  println("This is printed in every instantiation")

  def greet(name: String): Unit = println(s"${this.name} says: Hi $name")

  def greet(): Unit = println(s"Hi, I am $name")

  //Multiple constructors or overloading constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameters are NOT FIELDS
// class parameters: Constructor parameters without "val"

/*
  Writer: firstName, surName, year
    method:
      fullName

  Novel: name, yearRelease, author
    methods:
      authorAge (year of the author at the year of release)
      isWrittenBy(author)
      copy(new year of release) = new instance of novel
*/

class Writer(firstName: String, surName: String, val birthYear: Int) {

  def fullName: String = s"$firstName $surName"

  def canEqual(a: Any) = a.isInstanceOf[Writer]

//  override def equals(that: Any): Boolean = {
//    that match {
//      case Writer => this.canEqual(that) && this.fullName().equals(that.fullName()) && this.birthYear == that.birthYear
//      case _ => false
//    }
//  }
//
//  override def hashCode: Int = {
//    val prime = 31
//    var result = 1
//    result = prime * result + ;
//    result = prime * result + (if (name == null) 0 else name.hashCode)
//    return result
//  }
}


class Novel(val name: String, val yearRelease: Int, val author: Writer) {

  def authorAge: Int = yearRelease - this.author.birthYear

  def isWrittenBy(author: Writer): Boolean = {
    return this.author.fullName.equals(author.fullName) && this.author.birthYear == author.birthYear
  }

  def copy(yearRelease: Int): Novel = new Novel(this.name, yearRelease, this.author)
}


/*
  Counter class
    - recieves an int value
    - method current count
    - method increment/decrement by one => new Counter
    - overload increment/decrement to receive an amount => new Counter
*/

class Counter(val count: Int = 0) {

  def inc: Counter = {
    println("incrementing")
    new Counter(this.count + 1) // Inmutability
  }

  def dec: Counter = {
    println("decrementing")
    new Counter(this.count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n -1)
  }

  def print = println(count)
}