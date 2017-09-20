package spireworkshop

import ichi.bench.Thyme
import GenericSumAndAverage._
import spire.implicits._

object GenericVsDoubleBench extends App {

  val th: Thyme = Thyme.warmed(warmth = Thyme.HowWarm.BenchOff)
  val xs: Array[Double] = (0 until 100).map(_.toDouble).toArray

  th.pbenchOffWarm("generic vs. double sumandaverage")(th.Warm(sumAndAverageDouble(xs)))(th.Warm(sumAndAverageGeneric(xs)))
}
