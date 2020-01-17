package edu.training.fun

/**
 * Una monada tiene 1 constructor y un metodo flatMap
 */
object _4_Monads extends App {


  val stringList: List[String] = List("monoids","in","the", "category", "of", "endofunctors", "wtf!")

  val intList: List[Int] = List(1, 1, 2, 3, 4, 4, 5)

  val optionsList: List[Option[Int]] = List(Some(1), Some(2), None, None, Some(2))

  val someList: List[Int] = optionsList.flatMap { x =>
    x
  }



  /** flatMap aplica una funcion al objeto de la caja y el resultado se retorna dentro de la caja **/
  println( intList.flatMap(x => List( x + 1 )) )

  /** El for comprehension (syntactic sugar) utiliza flat map para poder iterar por los elementos */
  val tuples: List[(String, Int)] = for {
    string <- stringList
    integers <- intList
    option <- optionsList
  } yield {
    (string, integers)
  }

  println( tuples )

  //Si le quitamos el syntactic sugar quedaria así
  stringList
    .flatMap( string =>
      intList.map( integers => (string, integers))
    )


  println( tuples )



}
