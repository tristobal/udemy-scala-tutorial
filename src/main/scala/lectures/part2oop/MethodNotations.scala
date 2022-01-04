package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie.equals(favoriteMovie)
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"

    // Exercise 1
    def +(adj: String): Person = new Person(s"${this.name} $adj", this.favoriteMovie)

    // Exercise 2
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    // Exercise 3
    def learns(skill: String): String = s"${this.name} learns $skill"
    def learnsScala: String = this learns "Scala"

    // Exercise 4
    def apply(number: Int): String = s"${this.name} watched ${this.favoriteMovie} $number times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation = operator notation (syntactic sugar)
  // Only applies with methods with one parameter
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All operator are methods
  // Akka actors have ! ?

  // Prefix Notation
  val x = -1 // equivalent 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation. Only for methods with no parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  /*
    1.- Overload the + operator
      mary + "The rockstar" => new Persona Mary (the rockstar) // with the same favorite movie

    2.- Add an age to the Person class
        Add a unary + opeator = > new Person with the age + 1
      +mary => mary with the age incrementer

    3.- Add a "learns" method in the Person class => "<name> learns <parameter>"
        Add learnsScala method calls learns method with "Scala".
        Use it in postfix notation

    4.- Overload apply method
      mary.apply(2) => "Mary watched Inception 2 times"
  */

  println("Exercises\n")
  println((mary + "the rockstar!").apply())

  println(mary.age)
  println((+mary).age)

  println(mary learnsScala)

  println(mary.apply(2))
  println(mary(2))
}
