package lectures.part1basics

import scala.annotation.tailrec

// Video 3
object Functions extends App {

  def aFunction(firstParam: String, secondParam: Int): String = {
    firstParam + " " + secondParam
  }
  println(aFunction("One", 1))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())

  def aRepeatedFuntion(text: String, n: Int): String = {
    if (n == 1) text
    else text + aRepeatedFuntion(text, n-1)
  }
  println(aRepeatedFuntion("hello", 3))

  // When you need loops, use recursion!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
   Exercises
    1.- A greeting function (name, age) -> "Hi my name is $name and I am $age years old"
    2.- Factorial function 1*2*3*...*n
    3.- Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n-1) + f(n-2)
    4.- Test if a number is prime.
  */

  def greeting(name: String, age: Int): Unit = s"Hi mi name is $name and I am $age years old"
  println(greeting("Cris", 40))

  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }
  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  println(fibonacci(8))

  def isPrimeWhileEdition(n: Int): Boolean = {
    var i:Int = 2
    var isPrime:Boolean = true
    while (i < n/2) {
      if (n % i == 0) {
        isPrime = false
      }
      i = i + 1
    }
    isPrime
  }
  println(isPrimeWhileEdition(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t !=0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(8))
}
