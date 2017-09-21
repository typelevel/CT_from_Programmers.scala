```Haskell
class Monoid m where
    mempty  :: m
    mappend :: m -> m -> m
```
```tut:silent
trait Monoid[M] {
  def mempty: M
  def mappend(m1: M, m2: M): M
}
```
................
```Haskell
instance Monoid String where
    mempty = ""
    mappend = (++)
```
```tut:silent
object Monoid {
  implicit def stringMonoid: Monoid[String] = new Monoid[String] {
    def mempty: String = ""
    def mappend(m1: String, m2: String): String = m1 + m2
  }
}
```
................
