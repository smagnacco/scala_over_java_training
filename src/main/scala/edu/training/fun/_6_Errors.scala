package edu.training.fun

import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._


object _6_Errors extends App with BombDeactivator {

  val bomb = new Bomb(false)

  pray(bomb.explotion())


  val tryingResult = try {
    pray(bomb.explotion())
  } catch {
    case e: Exception => println(s"ERROR $e")
      0
  }

  // Try
  val betterTryingResult: Try[Int] = tryingBetter(bomb.explotion())

  //Either
  val another: Either[Int, Int] = eitherIsRight(bomb.explotion())

}

class Bomb(explote: Boolean) {
  def explotion(): Int = if(!explote) 0 else throw new NullPointerException()
}

trait BombDeactivator {

  def pray[T](thunk: => T): T = thunk

  def tryingBetter[T](thunk: => T): Try[T] = Try { thunk }

  def eitherIsRight[T](thunk: => T): Either[Int, T] = Try {
    thunk
  } match {
    case Failure(exception) => println(exception); Left(0)
    case Success(r) => Right(r)
  }
}