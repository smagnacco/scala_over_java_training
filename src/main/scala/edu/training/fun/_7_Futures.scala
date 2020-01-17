package edu.training.fun

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

object _7_Futures extends App {
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  val eventuallyCountry = Future { getCountry() }
  val eventuallySecondCountry = Future { getCountry() }

  //PARALELO
  val eventuallyCountryCodeTuple: Future[(String, String)] = for {
    countryCode <- eventuallyCountry
    secondCountry <- eventuallySecondCountry
  } yield {
    (countryCode.toLowerCase, secondCountry.toLowerCase)
  }

  //SECUENCIAL
  val eventuallyCountryCodeTuple2: Future[(String, String)] = for {
    countryCode <- Future { getCountry() }
    secondCountry <- Future { getCountry() }
  } yield {
    (countryCode.toLowerCase, secondCountry.toLowerCase)
  }

  val eventuallyCountryCodes: List[Future[(String, String)]] = List(eventuallyCountryCodeTuple, eventuallyCountryCodeTuple2)

  val eventuallyCountryCodesTuple: Future[List[(String, String)]] = Future.sequence(eventuallyCountryCodes)

  Await.result(eventuallyCountryCodeTuple, 10 seconds)

  def getCountry() = "AR"


}
