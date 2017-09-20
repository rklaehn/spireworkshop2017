package spireworkshop

import spire.implicits._
import spire.math._
import org.scalatest.FunSuite
import org.typelevel.discipline.scalatest.Discipline
import spire.laws._
import spire.laws.arb._

class FloatsAreNotLawful extends FunSuite with Discipline {

  checkAll("RingLaws[Double].ring", RingLaws[Double].ring)
}

class RationalsAreLawful extends FunSuite with Discipline {

  checkAll("RingLaws[Rational].ring", RingLaws[Rational].ring)
}
