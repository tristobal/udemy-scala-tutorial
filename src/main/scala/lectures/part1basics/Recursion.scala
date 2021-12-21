package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of: " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n - 1)
      println("Computed factorial of: " + n)
      result
    }

  //println(factorial(5000))

  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // Tail recursion = use recursive call as the LAST expression

    factorialHelper(n, 1)
  }

  /*
    anotherFactorial(10) =>
    = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factorialHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
    = factorialHelper(1, 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10)
    = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
  */

  // When you need loops use tail recursion.

  /*
    1.- Concatenate a String n times
    2.- isPrime function, tail recursive
    3.- Fibonaci function, tail recursive
  */

  def concatenateString(text: String, n: Int): String = {
    @tailrec
    def concatHelper(text: String, n: Int, accumulator: String): String = {
      if (n <= 1) accumulator
      else concatHelper(text, n - 1, text + accumulator)
    }
    concatHelper(text, n, text)
  }
  println(concatenateString("X", 6))

  def isPrime(n: Int) = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(fibonacci(6))
}
