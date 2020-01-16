package edu.training.fun

object _3_Functors extends App with GatoAPerrorTransformer {

  /** A Constructor */
  val anotherEmptyList: List[Nothing] = List()
  val stringEmptyList: List[String] = List[String]()

  // String List Type Constructor
  val listaDeGatos = List(Gato("Tom"), Gato("Mauri"), Gato("Suller"))

  listaDeGatos.foreach{ animalito => println(s"${animalito.nombre}: ${animalito.haceTuGracia}") }

  //operacion map

  val resultList = listaDeGatos.map(gato => hacetePerro(gato))

  resultList.foreach{ animalito => println(s"${animalito.nombre}: ${animalito.haceTuGracia}") }  //improvement DRY

}

trait GatoAPerrorTransformer {
  def hacetePerro(gato: Gato): Perro = Perro(gato.nombre)
}

case class Gato(nombre: String, haceTuGracia: String = "Miau soy un gato") extends Gracia
case class Perro(nombre: String, haceTuGracia: String = "Guau soy un perro") extends Gracia

trait Gracia {
  def haceTuGracia: String
}