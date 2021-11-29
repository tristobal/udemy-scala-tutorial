package lectures.part1basics

// Video 2
object Expressions extends App {
  // Expression
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)
  println(!(1 == x))

  var aVariable = 2
  aVariable +=1 // also works with -= *= /= // side effects
  println(aVariable)

  // Instructions (are executed) vs Expressions (are evaluated)

  //If expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // If expression NOT if instruction
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  // Not recommended
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println("aWeirdValue: " + aWeirdValue)

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "bye"
  }

  // 1.- Difference between "hello world" vs println("hello world").
  // Resp: Hello world is a value of type String. println() is an expression
  // 2.- What's the value of...
  // Boolean -> false
  val someValue = {
    2 < 3
  }
  println(someValue)
  // Int
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
