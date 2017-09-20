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
  val b = Interval.above(Instant.now())

  println(b)

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

  val at = IntervalTrie(a)
  val bt = IntervalTrie(b)

  val t0 = Instant.now()
  val tom = (0 until 100000).map(i => IntervalTrie(Interval(Instant.now().plus(i * 24 * 3600, ChronoUnit.SECONDS), Instant.now().plus(i * 24 * 3600 + 3600 * 10, ChronoUnit.SECONDS))))
  val tim = (0 until 100000).map(i => IntervalTrie(Interval(Instant.now().plus(i * 24 * 3600 + 3600, ChronoUnit.SECONDS), Instant.now().plus(i * 24 * 3600 + 3600 * 11, ChronoUnit.SECONDS))))

  val toms = tom.foldLeft(IntervalTrie.empty[Instant])(_ | _)
  val tims = tim.foldLeft(IntervalTrie.empty[Instant])(_ | _)

  val et0 = System.nanoTime()
  val res = toms & tims
  val et1 = System.nanoTime()
  val edt = (et1 - et0) / 1e9
  println(edt)

  println(at)
  println(bt)
}
