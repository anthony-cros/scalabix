package scalabix

import aptus.Anything_

// ===========================================================================
object ScalabixUtils {

  def combinations[A](coll: Seq[A]): Seq[(A, A)] =
    coll // TODO: use .combinations from stdlib instead? test first
      .flatMap{ v1 =>
        coll
          .dropWhile(v2 => v2 != v1)
          .map      (v2 => (v1, v2) ) }

  // ===========================================================================
  def expandRange(pair: (Long, Long)): Seq[Long] = expandRange(fromInclusive = pair._1, toInclusive = pair._2)

  /** can't use Range directly with Longs */
  def expandRange(fromInclusive: Long, toInclusive: Long): Seq[Long] =
    Range(0, (toInclusive - fromInclusive).toInt + 1)
      .map(fromInclusive + _)
      .assert(_.nonEmpty)

}

// ===========================================================================