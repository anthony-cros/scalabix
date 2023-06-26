package scalabix
package genomics

import aptus.Option_
import aptus.Prefix

// ===========================================================================
sealed trait Chromosome extends enumeratum.EnumEntry {
    def isMitochondrial = this == Chromosome.M

    def isY             = this == Chromosome.Y
    def isNotY          = this != Chromosome.Y }

  // ===========================================================================
  object Chromosome extends enumeratum.Enum[Chromosome] {
    val values = findValues

    // ---------------------------------------------------------------------------
    private object Synonym {
      val MT = "MT"
      val mt = "mt"
      val m  = "m" }

    // ---------------------------------------------------------------------------
    private object Prefix {

      // valid ones
      val NW_ = "NW_" // eg NW_003315947.1 in clinvar data
      val NT_ = "NT_" // eg NT_010783 from ?
      val GL  = "GL"  // eg GL000226.1 from roberts data

      // ---------------------------------------------------------------------------
      // invalid ones
      val chr = "chr" /* eg in gencode */ }

    // ---------------------------------------------------------------------------
    private val MitochondrialChromosomeNames: Set[ChromosomeName] =
      Set(
        Synonym.MT,
        Synonym.mt,
        Synonym.m,
        M.entryName)

    // ---------------------------------------------------------------------------
    private val ValidCorePrefices: Set[Prefix] =
      Set(
        Prefix.NW_,
        Prefix.NT_,
        Prefix.GL )

    // ===========================================================================
    def isMitochondrial(value: ChromosomeName): Boolean = MitochondrialChromosomeNames.contains(value)

    // ---------------------------------------------------------------------------
    /** don't normalize if not */
    def potentiallyNormalizeMitochondrialChromosome(value: ChromosomeName): ChromosomeName =
      if (isMitochondrial(value)) Chromosome.M.entryName
      else                        value

    // ---------------------------------------------------------------------------
    /** eg in gencode */
    def   tryRemoveChrPrefix(value: ChromosomeName): Option[ChromosomeName] = if (value. startsWith(Prefix.chr)) Some(value.drop(3)) else None

    def forceRemoveChrPrefix(value: ChromosomeName): ChromosomeName = tryRemoveChrPrefix(value).force

    // ===========================================================================
    def isValidCore(value: String): Boolean =
      ValidCorePrefices.exists(value.startsWith) ||
      Chromosome.withNameOption(value).nonEmpty

    // ===========================================================================
    case object  `1` extends Chromosome
    case object  `2` extends Chromosome
    case object  `3` extends Chromosome
    case object  `4` extends Chromosome
    case object  `5` extends Chromosome
    case object  `6` extends Chromosome
    case object  `7` extends Chromosome
    case object  `8` extends Chromosome
    case object  `9` extends Chromosome
    case object `10` extends Chromosome
    case object `11` extends Chromosome
    case object `12` extends Chromosome
    case object `13` extends Chromosome
    case object `14` extends Chromosome
    case object `15` extends Chromosome
    case object `16` extends Chromosome
    case object `17` extends Chromosome
    case object `18` extends Chromosome
    case object `19` extends Chromosome
    case object `20` extends Chromosome
    case object `21` extends Chromosome
    case object `22` extends Chromosome
    case object  `X` extends Chromosome
    case object  `Y` extends Chromosome
    case object  `M` extends Chromosome }

// ===========================================================================
