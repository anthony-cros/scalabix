package scalabix
package genomics

import aptus.String_
import aptus.DirPath

// ===========================================================================
object ReferenceParser {

  /** needs at least -Xmx4g -Xms4g for full version */
  def parse(in: DirPath): Reference =
    Chromosome
      .values
      .map(_.entryName)
      .map { chromosome =>
        chromosome ->
          ReferenceChromosome.parse(in.slash(chromosome).dot("tsv")) }
      .toMap
      .pipe(new Reference(_)) }

// ===========================================================================