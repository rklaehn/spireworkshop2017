package spireworkshop
import scala.specialized
import spire.implicits._
import spire.math._
import spire.algebra._

object GenericSumAndAverage {

  def sumAndAverageGeneric[@specialized T: Field](xs: Array[T]): (T, T) = {
    def sum0(i: Int, sum: T): (T, T) = {
      if(i == xs.length)
        (sum, sum / xs.length)
      else
        sum0(i + 1, sum + xs(i))
    }
    sum0(0, Field[T].zero)
  }

  def sumAndAverageDouble(xs: Array[Double]): (Double, Double) = {
    var sum = 0.0
    var i = 0
    while(i < xs.length) {
      sum += xs(i)
      i += 1
    }
    (sum, sum / xs.length)
  }
}
