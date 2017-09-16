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
```scala
val f: Boolean => Boolean = x => ???
```
................
```Haskell
f :: Bool -> Bool
f = undefined
```
```scala
def f: Boolean => Boolean = ???
```
................
```Haskell
fact n = product [1..n]
```
```scala
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
```scala
val f44: Unit => BigInt = _ => 44
```
................
```Haskell
fInt :: Integer -> ()
fInt x = ()
```
```scala
val fInt: BigInt => Unit = x => ()
```
................
```Haskell
fInt :: Integer -> ()
fInt _ = ()
```
```scala
val fInt: BigInt => Unit = _ => ()
```
................
```Haskell
unit :: a -> ()
unit _ = ()
```
```scala
def unit[A]: A => Unit = _ => ()
```
................
```Haskell
data Bool = True | False
```
```scala
sealed trait Bool
case object True extends Bool
case object False extends Bool
```
