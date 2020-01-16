package edu.training.fun

/**
 * Las funciones son como el átomo en la programación funcional
 *
 * Se pueden meter dentro de Objects que serian como las clases estaticas de java
 * o si queremos ser organizados podemos organizar el código como ya sabemos en la
 * programación orientada a objetos
 *
 */
object _1_Functions extends App {
  def sum(a: Int, b: Int) = a + b

  val one_param_like_square: Int => Int = a => a * a

  val two_param_like_sum_as_expression: (Int, Int) => Int = (a, b) => a + b

  val two_param_arrow_style: Int => Int => Int = a => b => a + b

  def curry_style_method(a: Int)(b:Int) = a + b

  println( s"""Llamando a un metodo: def sum(10, 10 ): ${sum(10, 10)}

  Llamando como expresiones es similar a llamar a un metodo

  Llamando con un parametro sin pasarles parametros nos muestra el tipo de one_param_like_square ${one_param_like_square}

  Si ven el tipo, te das cuenta que una funcion es un objeto

  Llamando con un parametro one_param_like_square(10) = ${ one_param_like_square(10) }

  el truco esta en que la funcion tiene un metodo def apply(param) donde aplica los parametros a la funcion

   asi es como funciona el compilador detras del las cortinas conocido como azucar sintactico

 *   new Function1[Int, Int] {
 *      def apply(x: Int): Int = x + 1
 *    }

  Llamando con dos parametros sin pasarles parametros nos muestra el tipo ${ one_param_like_square } y asi hay hasta 32 params posibles

  Llamando con dos parametros two_param_like_sum_as_expression(10, 10) ${ two_param_like_sum_as_expression(10, 10) }

  Llamando con dos parametros pero con la notación de 2 arrows a => b => c ${ two_param_arrow_style }

  Esta notacion presenta algo llamado funciones partidas o parciales (currificación) que permite definir una funcion
  con un parametro inicial y despues ir aplicando la funcion cuando llegue en otro momento el segundo parametro

  Tambien se puede escribir como un metodo por ejemplo curry_style_method: ${curry_style_method _} que si le pasamos los parametros
    seria por ejemplo si le paso solo el primer parametro curry_style_method(10) _ ${curry_style_method(10) _}
    y si le paso los dos parametros curry_style_method(10)(20) ${curry_style_method(10)(20)}


    Disclaimer: Ninguna de estas herramientas se debe usar a la ligera, pensar que detras de toda esta magia
     se crean clases y tambien cuando definis una funcion como val cuando estas viendo stack traces no se sabe bien
     que esta haciendo porque no tiene nombres definidos como los metodos. Siempre se ve Function1.apply(bla bla bla)
     Hay que usar con criterio.
    """)


}



