```Haskell
class Monoid m where
    mempty  :: m
    mappend :: m -> m -> m
```
```scala
trait Monoid[M] {
  def mempty: M
  def mappend(m1: M)(m2: M): M
}
```
................
```Haskell
instance Monoid String where
    mempty = ""
    mappend = (++)
```
```scala
object Monoid {
  implicit object stringMonoid extends Monoid[String] {
    def mempty = ""
    def mappend(m1: String)(m2: String): String = m1 + m2
  }
}
```
................