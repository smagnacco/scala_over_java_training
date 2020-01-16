package edu.training.fun

import scala.util.Try
import scala.util.control.Exception._

object _6_Errors extends App with BombDeactivator {

  val bomb = new Bomb(false)

  pray(bomb.explotion())

  // try
  val tryingResult = trying(bomb.explotion())

  // Try
  val betterTryingResult = tryingBetter(bomb.explotion())

  //Either
  eitherIsRight(bomb.explotion())

}

class Bomb(explote: Boolean) {
  def explotion(): Int = if(!explote) 0 else throw NullPointerException
}

trait BombDeactivator {

  def pray[T](thunk: => T): T = thunk

  def trying[T](thunk: => T): T = thunk

  def tryingBetter[T](thunk: => T): Try[T] = Try { thunk }

  def eitherIsRight[T](thunk: => T): Either[Exception, Int] = allCatch.either(thunk)
}