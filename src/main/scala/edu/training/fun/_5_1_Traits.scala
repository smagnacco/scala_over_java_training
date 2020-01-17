package edu.training.fun

object _5_1_Traits extends App {
  trait Seniority {
      def add(x: Int): Int
  }

  trait Junior extends Seniority {
    override def add(x: Int): Int = x
  }

  trait SemiSenior extends Seniority {
    override def add(x: Int): Int = x + x
  }

  trait Senior extends Seniority {
    override def add(x: Int): Int = x * x
  }

  class Developer(n: String) extends Junior

  val jr = new Developer("jr")

  println(s"junior es ${jr.add(10)}")

  val ssr = new Developer("b") with SemiSenior

  println(s"junior es ${ssr.add(10)}")

  val sr = new Developer("sr") with Senior

  println(s"junior es ${ssr.add(10)}")

  val developerWithAnonimousTrait = new Developer("m") with Seniority {
    override def add(x: Int): Int = -9999
  }

  println(s"junior es ${developerWithAnonimousTrait.add(10)}")

}
