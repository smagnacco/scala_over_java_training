package edu.training.fun

object _2_1_FunLazyness extends App {

  def identity(x: Int): Int = {
    println("Manu no confia")
    x
  }

  def method_that_receives_a_lazy_expression(thunk: => Int, callThunk: Boolean): Unit =
    if (callThunk) {
      println(s"Thunk will be called right now: ${thunk}")
    } else {
      println("Thunk has not been evaluated")
    }

  val resultNotCallingThunk = method_that_receives_a_lazy_expression(identity(10), callThunk = false)

  val resultCallingThunk = method_that_receives_a_lazy_expression(identity(10), callThunk = true)


}
