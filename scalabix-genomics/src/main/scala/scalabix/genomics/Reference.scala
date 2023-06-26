package scalabix
package genomics

import aptus.Anything_

// ===========================================================================
final class Reference(private val data: Map[ChromosomeName, Array[Byte]]) extends CanLookupReference { // TODO: try bitset instead?
    def size = data.size

    // ===========================================================================
    def lookup(
          chromosome: ChromosomeName,
          position:   Position,
          length:     Length)
        : Nucleotides = {

      val position2 = position.toInt // TODO: t190418171519 - should it be Int everywhere?

      val _chromosome: ChromosomeName = if (chromosome == "MT") "M" else chromosome // TODO: accept enum rather
      
      val bytes: Array[Byte] = data.apply(_chromosome)
      
      // ---------------------------------------------------------------------------
      require(
        length + position < bytes.length,
        (length, position,  bytes.length)) // TODO: check OBOE  
  
      // ---------------------------------------------------------------------------
      bytes
        .slice(
          position2 - 1,
          position2 - 1 + length)
        .assert(
          bytes =>  bytes.size == length,
          bytes => (bytes.size,   length))
        .pipe(new String(_, java.nio.charset.StandardCharsets.US_ASCII))
    } }

  // ===========================================================================
  object Reference {
    /** needs at least -Xmx4g -Xms4g */
    def parse(): Reference = ReferenceParser.parse("/in/ucsc/hgdownload") }

// ===========================================================================
