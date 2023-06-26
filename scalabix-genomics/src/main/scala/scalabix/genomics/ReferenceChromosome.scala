package scalabix
package genomics

import aptus.Anything_
import aptus.FilePath

// ===========================================================================
private object ReferenceChromosome {
  
  // TODO: t190412101903 - handle gz rather (eg gzip -l knows both sizes - beware of known debian bug though)
  def parse(in: FilePath): Array[Byte] = parse(file = new java.io.File(in))

  // ---------------------------------------------------------------------------
  def parse(file: java.io.File): Array[Byte] = {
    val longLength = file.length
    val  intLength = file.length.toInt.ensuring(_.toLong == longLength) // TODO: forceInt

    val fileInputStream = new java.io.FileInputStream(file)
    
    val bytes = Array.ofDim[Byte](intLength) // mutable

    fileInputStream.read(bytes)
    fileInputStream.close()    
    
    bytes } }

// ===========================================================================
