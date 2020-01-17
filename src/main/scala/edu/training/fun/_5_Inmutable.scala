package edu.training.fun

import edu.training.fun._5_Inmutable.{Filosofo, Heraclito, Parmenides, heraclito}


object _5_Inmutable extends App with DejenHablar with HablarSinPolimorfismos {

  trait Filosofo {
    def nombre: String
    def frase: String
    def show(): Unit = println(s"$nombre dice $frase")
  }

  case class Parmenides(nombre: String = "Parmenides", frase: String = "El ser es inmutable") extends Filosofo
  case class Heraclito(nombre: String = "Heraclito", frase: String = "El eterno devenir del ser") extends Filosofo

  val parmenides: Parmenides = Parmenides()
  val heraclito: Heraclito = Heraclito()

  parmenides.show()

  heraclito.show()

  val otroParmenides = parmenides.copy(frase = "Heraclito te conviene ser inmutable")

  otroParmenides.show()

  println(s"Dejen al filosofo ${heraclito.nombre} hablar...")

  asiHablabaEl(heraclito)

  asiHablabaEl(parmenides)

  hablablaSinPolimorfismos(heraclito)

  hablablaSinPolimorfismos(parmenides)

}

trait DejenHablar {
  def asiHablabaEl(filosofo: Filosofo): Unit = {
    filosofo match {
      case Heraclito(nombre, _) => println(s"Parmenides no entiende nada. $nombre dixit")
      case Parmenides(nombre, _) => println(s"Heraclito no entiende nada. $nombre dixit")
    }
  }
}

trait HablarSinPolimorfismos {
  def hablablaSinPolimorfismos[T](filosofo: T): Unit = {
    filosofo match {
      case Heraclito(nombre, _) => println(s"Parmenides polimorfismo para que. $nombre dixit")
      case Parmenides(nombre, _) => println(s"Heraclito polimorfismo para que. $nombre dixit")
      case a => println(s"esto no debería pasar: $a")
    }
  }
}