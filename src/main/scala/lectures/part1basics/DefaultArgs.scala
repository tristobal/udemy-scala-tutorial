package lectures.part1basics

object DefaultArgs extends App {

  def tailRecFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailRecFactorial(n - 1, n * acc)
  }

  val fact10 = tailRecFactorial(10)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1980, height: Int = 1080): Unit =
    println(s"Saving $format $width x $height")

  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "bmp")
}
