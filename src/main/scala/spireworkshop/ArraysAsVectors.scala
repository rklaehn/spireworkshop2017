package spireworkshop

import spire.math._
import spire.implicits._
import spire.algebra._
import cats.instances.all._
import cats.syntax.all._

object ArraysAsVectors extends App {
  val a: Array[Double] = Array(1.0, 2.0, 3.0)
  val b: Array[Double] = Array(3.0, 4.0, 5.0)
  val sum = a + b
  val productWithScalar = a :* 2.0
  val innerProduct = a dot b
  println(sum.toSeq)
  println(productWithScalar.toSeq)
  println(innerProduct)

  val ar = Array(Rational(1,3), Rational(2,3))
  val br = Array(Rational(3,5), Rational(7,9))
  val rr = ar + br
}
