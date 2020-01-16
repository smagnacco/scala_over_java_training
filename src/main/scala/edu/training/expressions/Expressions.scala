package edu.training.expressions

object Expressions extends Utils {

  val ten = 10

  val x: Int = if (isBiggerThan(ten)) {
    10
  } else {
    20
  }

  val y: Int = if (isSmallerThan(ten)) 20 else 10

  val z = (x + y) + (x + y)

  val thunk = {
    val m = z + z
    m + x + y
  }

  val _for_como_expression = for {
    i <- Range(0, 3)
    j <- Range(0, 3)
    if i != 0
  } yield {
    (i, j)
  }

  val multiplicationExpression: Int => Int = x => x * x

  def main(args: Array[String]): Unit = {
    println(s"El valor de z: $z")
    println("El valor de j:" + thunk)
    println(s"El valor de la expression del for es : ${_for_como_expression}")
    println(s"El valor de la expression del for es : ${_for_como_expression}")
    println(s"El valor de la expression del for es : ${multiplicationExpression(2)}")
    println(s"El valor de la expression del for es : ${multiplicationExpression _}")
  }

}


trait Utils {
  def isBiggerThan(x: Int): Boolean = true
  def isSmallerThan(x: Int): Boolean = false
}