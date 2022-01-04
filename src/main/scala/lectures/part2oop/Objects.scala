package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("Java static")
  object Person { // type + its only instance
    // "static"/"class" evel functionalit
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // Instance level functionality
  }
  // This pattern is called: COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance
  val mary = new Person("Mary")
  val john = new Person("John")
  println("Person class: " + (mary == john))

  val person1 = Person
  val person2 = Person
  println("Person object: " + (person1 == person2))

  val bobbie = Person(mary, john)


  // Scala Applications = Scala object with:
  //  def main(args: Array[String]): Unit

}
