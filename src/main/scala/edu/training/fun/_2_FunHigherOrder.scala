package edu.training.fun

object _2_FunHigherOrder extends App {

  val identity: Int => Int = x => x

  def identity_as_method(x: Int): Int = x

  val sum_as_higher_order_fun: (Int => Int) => Int => Int = thunk1 => x => thunk1(x)

  val higherOrderFunToBeApplied: Int => Int = sum_as_higher_order_fun(identity)

  val higherOrderFunToBeAppliedUsingAMethod: Int => Int = sum_as_higher_order_fun(identity_as_method)

  higherOrderFunToBeApplied(1)

  higherOrderFunToBeAppliedUsingAMethod(1)

  println(
    s"""Pasando funciones por parametro:
        identity(1) = ${identity(1)}

        sum_as_higher_order_fun(identity, identity) = ${sum_as_higher_order_fun(identity)} only defined!

        defining a function that use identity function as parameter higherOrderFunToBeApplied(identity) = ${higherOrderFunToBeApplied}

        applying higherOrderFunToBeApplied(1) = ${higherOrderFunToBeApplied(1)}

        using a method as parameter sum_as_higher_order_fun(identity_as_method) = ${higherOrderFunToBeAppliedUsingAMethod(1)}

       """)

}
