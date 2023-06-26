package scalabix
package genomics

// ===========================================================================
object GenomicsEnums {
  
	sealed trait strand extends enumeratum.EnumEntry
  	object strand extends enumeratum.Enum[strand] {
  	  val values = findValues 
  	  
      case object `+` extends strand
      case object `-` extends strand    
      
      /*        
        match {
        
          case `+` => ??? 
          case `-` => ??? 
        }         
      */
  	}
  
}

// ===========================================================================
