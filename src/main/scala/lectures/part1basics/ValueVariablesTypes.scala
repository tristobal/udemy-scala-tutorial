package lectures.part1basics

// Video 1
object ValueVariablesTypes extends App {

  // val is immutable
  // compiler can infer types.
  // val x = 42
  val anInt: Int = 42
  println(anInt)

  // semicolon are optional, unless exists another sentence in the same line. Unrecommended
  val aString: String = "hello";

  val aBoolean: Boolean = true

  val aChar: Char = 'a'

  // 2 bytes
  val aShort: Short = 12345
  // 8 bytes. L use is the same as Java
  val aLong: Long = 1234567890123456789L
  // f use is the same as Java
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //Variables
  var aVariable: Int = 1
  aVariable = 2 // side effect
}
