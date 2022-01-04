package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    //protected def eat = println("Nom, nom, nom")
    def eat = println("Nom, nom, nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch, crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("DOMESTIC")
  dog.eat
  println(dog.creatureType)

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Overriding vs Overloading

  // super

  // preventing overrrides
  //  1.- Use final on member
  //  2.- Use final on the entire class
  //  3.- seal the class (sealed) = extend classes in this file only, prevent extension in other files
}
