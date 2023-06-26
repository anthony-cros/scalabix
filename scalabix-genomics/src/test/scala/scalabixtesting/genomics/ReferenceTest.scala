package scalabixtesting
package genomics

import utest._

// ===========================================================================
object ReferenceTest extends TestSuite {

  val tests = Tests {
    // TODO: support gz + use Resources rather (also see t190412101903)
    val dir = getClass().getClassLoader().getResource("truncated/").toURI().toASCIIString.replace("file:", "")
    val ref = scalabix.genomics.ReferenceParser.parse(dir)

    test(assert("GAT" == ref.lookup("M", 1,     3)))
    test(assert("GAG" == ref.lookup("M", 101,   3)))
    test(assert("NNN" == ref.lookup("1", 1,     3)))
    test(assert("taa" == ref.lookup("1", 10001, 3))) } }

// ===========================================================================
