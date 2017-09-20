package spireworkshop
import spire.math._
import spire.implicits._

object Intervals extends App {
  val a = Interval(9.5, 10.5)
  val b = Interval(-0.5, 0.5)
  val c = a + b
  val d = a * b
  println(c)
  println(d)
}
