package scalabix
package genomics

// ===========================================================================
trait CanLookupReference {
  def lookup(
      chromosome: ChromosomeName, // TODO: accept enum rather?
      position:   Position,
      length:     Length /* from position, not on each side */)
    : Nucleotides }

// ===========================================================================