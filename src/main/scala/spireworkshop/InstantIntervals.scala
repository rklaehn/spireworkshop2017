package spireworkshop

import java.time.temporal.{ChronoUnit, TemporalUnit}
import java.time.{Duration, Instant}

import algebra.ring.AdditiveSemigroup
import spire.implicits._
import spire.math.extras.interval._
import spire.algebra.{AdditiveGroup, Order}
import spire.math.Interval

object InstantIntervals extends App {

  implicit val instantOrder: Order[Instant] = Order.by[Instant, Long](_.toEpochMilli)

  val a = Interval(Instant.now(), Instant.now().plus(10, ChronoUnit.SECONDS))

  println(a)

  implicit val instantElement: IntervalTrie.Element[Instant] = new IntervalTrie.Element[Instant] {
    override implicit def order: Order[Instant] = instantOrder

    override def toLong(value: Instant): Long = value.toEpochMilli

    override def fromLong(key: Long): Instant = Instant.ofEpochMilli(key)
  }

  implicit val durationAdditiveGroup: AdditiveGroup[Duration] = new AdditiveGroup[Duration] {

    override def negate(x: Duration) = x.negated()

    override def zero = Duration.ZERO

    override def plus(x: Duration, y: Duration) = x.plus(y)
  }
}
