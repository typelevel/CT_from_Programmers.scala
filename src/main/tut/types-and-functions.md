```Haskell
x :: Integer
```
```scala
val x: BigInt
```
................
```Haskell
f :: Bool -> Bool
```
```scala
val f: Boolean => Boolean
```
................
```Haskell
f :: Bool -> Bool
f x = undefined
```
```tut:silent
val f: Boolean => Boolean = x => ???
```
................
```Haskell
f :: Bool -> Bool
f = undefined
```
```tut:silent
def f: Boolean => Boolean = ???
```
................
```Haskell
fact n = product [1..n]
```
```tut:silent
val fact = (n: Int) => (1 to n).toList.product
```
................
```Haskell
absurd :: Void -> a
```
```scala
def absurd[A]: Nothing => A
```
................
```Haskell
f44 :: () -> Integer
f44 () = 44
```
```tut:silent
val f44: Unit => BigInt = _ => 44
```
................
```Haskell
fInt :: Integer -> ()
fInt x = ()
```
```tut:silent
val fInt: BigInt => Unit = x => ()
```
................
```Haskell
fInt :: Integer -> ()
fInt _ = ()
```
```tut:silent
val fInt: BigInt => Unit = _ => ()
```
................
```Haskell
unit :: a -> ()
unit _ = ()
```
```tut:silent
def unit[A]: A => Unit = _ => ()
```
................
```Haskell
data Bool = True | False
```
```tut:silent
sealed trait Bool
case object True extends Bool
case object False extends Bool
```
