// ===========================================================================
package object scalabix {
  private[scalabix] implicit class ScalabixAnything_[A](value: A) { // so as to not import chaining._ everywhere
    private[scalabix] def pipe[B](f: A => B)   : B =   f(value)
    private[scalabix] def tap    (f: A => Unit): A = { f(value); value } } }

// ===========================================================================