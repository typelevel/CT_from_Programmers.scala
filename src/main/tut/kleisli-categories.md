```Haskell
type Writer a = (a, String)
```
```tut:silent
type Writer[A] = (A, String)
```
................
```Haskell
a -> Writer b
```
```scala
A => Writer[B]
```
................
```Haskell
(>=>) :: (a -> Writer b) -> (b -> Writer c) -> (a -> Writer c)
```
```scala
def >=>[A, B, C](m1: A => Writer[B], m2: B => Writer[C]): A => Writer[C]
```
................
```Haskell
m1 >=> m2 = \x -> 
    let (y, s1) = m1 x
        (z, s2) = m2 y
    in (z, s1 ++ s2)
```
```tut:silent
object kleisli {
  //allows us to use >=> as an infix operator
  implicit class KleisliOps[A, B](m1: A => Writer[B]) {
   def >=>[C](m2: B => Writer[C]): A => Writer[C] =
    x => {
      val (y, s1) = m1(x)
      val (z, s2) = m2(y)
      (z, s1 + s2)
    }
  }
}
```
................
```Haskell
return :: a -> Writer a
return x = (x, "")
```
```tut:silent
def pure[A](x: A): Writer[A] = (x, "")
```
................
```Haskell
upCase :: String -> Writer String
upCase s = (map toUpper s, "upCase ")
```
```tut:silent
val upCase: String => Writer[String] =
  s => (s.toUpperCase, "upCase ")
```
................
```Haskell
toWords :: String -> Writer [String]
toWords s = (words s, "toWords ")
```
```tut:silent
val toWords: String => Writer[List[String]] =
  s => (s.split(' ').toList, "toWords ")
```
................
```Haskell
process :: String -> Writer [String]
process = upCase >=> toWords
```
```tut:silent
val process: String => Writer[List[String]] = {
  import kleisli._
  upCase >=> toWords
}
```
