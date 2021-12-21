package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(5))

  // Scala-specific: String interpolators.

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(anotherGreeting)

  //F-interpolators
  val speed = 1.2f
  // %s string | %2.2f 2 characters total, minimum with 2 decimals of precision
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  val x = 1.1f
  println(f"$x%3f")

  // raw-interpolator. Ignores escaped chars inside raw characters in the string
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
