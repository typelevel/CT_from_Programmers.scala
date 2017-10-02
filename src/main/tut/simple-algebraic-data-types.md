```Haskell
swap :: (a, b) -> (b, a)
swap (x, y) = (y, x)
```
```tut:silent
def swap[A, B](x: A, y: B): (B, A) = (y, x)
```
................
```Haskell
((a, b), c)
```
```scala
((A, B), C)
```
...............
```Haskell
(a, (b, c))
```
```scala
(A, (B, C))
```
...............
```Haskell
alpha :: ((a, b), c) -> (a, (b, c))
alpha ((x, y), z) = (x, (y, z))
```
```tut:silent
def alpha[A, B, C]: ((A, B), C) => (A, (B, C)) =
  { case ((x, y), z) => (x, (y, z)) }
```
...............
```Haskell
alpha_inv :: (a, (b, c)) -> ((a, b), c)
alpha_inv  (x, (y, z)) = ((x, y), z)
```
```tut:silent
def alpha_inv[A, B, C]: (A, (B, C)) => ((A, B), C) =
  { case (x, (y, z)) => ((x, y), z) }
```
...............
```Haskell
(a, ())
```
```scala
(A, Unit)
```
...............
```Haskell
rho :: (a, ()) -> a
rho (x, ()) = x
```
```tut:silent
def rho[A](x: A, u: Unit): A = x
```
...............
```Haskell
rho_inv :: a -> (a, ())
rho_inv x = (x, ())
```
```tut:silent
def rho_inv[A](x: A): (A, Unit) = (x, ())
```
...............
```Haskell
data Pair a b = P a b
```
```tut:silent
sealed trait Pair[A, B]
case class P[A, B](a: A, b: B) extends Pair[A, B]
```
...............
```Haskell
stmt :: Pair String Bool
stmt = P "This statements is" False
```
```tut:silent
val stmt: Pair[String, Boolean] =
  P("This statements is", false)
```
...............
```Haskell
data Pair a b = Pair a b
```
```tut:silent
case class Pair[A, B](a: A, b: B)
```
...............
```Haskell
stmt = (,) "This statement is" False
```
```tut:silent
val stmt = ("This statement is", false)
```
...............
```Haskell
data Stmt = Stmt String Bool
```
```tut:silent
case class Stmt(s: String, b: Boolean)
```
...............
```Haskell
startsWithSymbol :: (String, String, Int) -> Bool
startsWithSymbol (name, symbol, _) = isPrefixOf symbol name
```
```tut:silent
val startsWithSymbol: (String, String, Int) => Boolean =
  (name, symbol, _) => name.startsWith(symbol)
```
...............
```Haskell
data Element = Element { name         :: String
                       , symbol       :: String
                       , atomicNumber :: Int }
```
```tut:silent
case class Element(
  name: String,
  symbol: String,
  atomicNumber: Int
)
```
...............
```Haskell
tupleToElem :: (String, String, Int) -> Element
tupleToElem (n, s, a) = Element { name = n
                                , symbol = s
                                , atomicNumber = a }
```
```tut:silent
val tupleToElem: (String, String, Int) => Element =
  (n, s, a) => Element(n, s, a)
```
...............
```Haskell
elemToTuple :: Element -> (String, String, Int)
elemToTuple e = (name e, symbol e, atomicNumber e)
```
```tut:silent
val elemToTuple: Element => (String, String, Int) =
  e => (e.name, e.symbol, e.atomicNumber)
```
...............
```Haskell
atomicNumber :: Element -> Int
```
```scala
val atomicNumber: Element => Int
```
...............
```Haskell
startsWithSymbol :: Element -> Bool
startsWithSymbol e = isPrefixOf (symbol e) (name e)
```
```tut:silent
val startsWithSymbol: Element => Boolean =
  e => e.name startsWith e.symbol
```
...............
```Haskell
startsWithSymbol e = symbol e `isPrefixOf` name e
```
```tut:silent
val startsWithSymbol: Element => Boolean =
  e => e.name startsWith e.symbol
```
...............
```Haskell
data Either a b = Left a | Right b
```
```tut:silent
sealed trait Either[+A, +B]
case class Left[+A](a: A) extends Either[A, Nothing]
case class Right[+B](b: B) extends Either[Nothing, B]
```
...............
```Haskell
data OneOfThree a b c = Sinistral a | Medial b | Dextral c
```
```tut:silent
sealed trait OneOfThree[A, B, C]
case class Sinistral[A](a: A) extends OneOfThree[A, Nothing, Nothing]
case class Medial[B](b: B) extends OneOfThree[Nothing, B, Nothing]
case class Dextral[C](c: C) extends OneOfThree[Nothing, Nothing, C]
```
...............
```Haskell
Either a Void
```
```scala
Either[A, Nothing]
```
...............
```Haskell
data Color = Red | Green | Blue
```
```tut:silent
sealed trait Color
case object Red extends Color
case object Green extends Color
case object Blue extends Color
```
...............
```Haskell
data Bool = True | False
```
```tut:silent
sealed trait Bool
case object True extends Bool
case object False extends Bool
```
...............
```Haskell
data Maybe a = Nothing | Just a
```
```tut:silent
sealed trait Maybe[+A]
case object Nothin extends Maybe[Nothing]
case class Just[+A](a: A) extends Maybe[A]
```
...............
```Haskell
data NothingType = Nothing
```
```tut:silent
trait NothingType[Nothing]
```
...............
```Haskell
data JustType a = Just a
```
```scala
sealed trait JustType[A]
case class Just[A](a: A) extends JustType[A]
```
...............
```Haskell
data Maybe a = Either () a
```
```scala
sealed trait Maybe[A]
case class Either[A](u: Unit, a: A) extends Maybe[A]
```
...............
```Haskell
List a = Nil | Cons a (List a)
```
```tut:silent
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](h: A, t: List[A]) extends List[A]
```
...............
```Haskell
maybeTail :: List a -> Maybe (List a)
maybeTail Nil = Nothing
maybeTail (Cons _ t) = Just t
```
```tut:silent
def maybeTail[A](l: List[A]): Maybe[List[A]] =
  l match {
    case Nil => Nothin
    case Cons(_, t) => Just(t)
  }
```
...............
```Haskell
(a, Either b c)
```
```scala
(A, Either[B, C])
```
...............
```Haskell
Either (a, b) (a, c)
```
```scala
Either[(A, B), (A, C)]
```
...............
```Haskell
prodToSum :: (a, Either b c) -> Either (a, b) (a, c)
prodToSum (x, e) = 
    case e of
      Left  y -> Left  (x, y)
      Right z -> Right (x, z)
```
```tut:silent
def prodToSum[A, B, C]:
  (A, Either[B, C]) =>
  Either[(A, B), (A, C)] = { case (x, e) =>
    e match {
      case Left(y) => Left(x, y)
      case Right(z) => Right(x, z)
    }
}
```
...............
```Haskell
sumToProd :: Either (a, b) (a, c) -> (a, Either b c)
sumToProd e = 
    case e of
      Left  (x, y) -> (x, Left  y)
      Right (x, z) -> (x, Right z)
```
```tut:silent
def sumToProd[A, B, C](
  e: Either[(A, B), (A, C)]
): (A, Either[B, C]) = e match {
  case Left((x, y)) => (x, Left(y))
  case Right((x, z)) => (x, Right(z))
}
```
...............
```Haskell
prod1 :: (Int, Either String Float)
prod1 = (2, Left "Hi!")
```
```tut:silent
val prod1: (Int, Either[String, Float]) =
  (2, Left("Hi!"))
```
...............
```Haskell
prod1 :: (Int, Either String Float)
prod1 = (2, Left "Hi!")
```
```tut:silent
val prod1: (Int, Either[String, Float]) =
  (2, Left("Hi!"))
```
...............
```Haskell
List a = Nil | Cons a (List a)
```
```tut:silent
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](h: A, t: List[A]) extends List[A]
```
...............
```Haskell
data Shape = Circle Float
           | Rect Float Float
```
```tut:silent
sealed trait Shape
case class Circle(r: Float) extends Shape
case class Rect(d: Float, h: Float) extends Shape
```
...............
```Haskell
area :: Shape -> Float
area (Circle r) = pi * r * r
area (Rect d h) = d * h
```
```tut:silent
def area(s: Shape): Float = s match {
  case Circle(r) => (math.Pi * r * r).toFloat
  case Rect(d, h) => d * h
}
```
...............
```Haskell
circ :: Shape -> Float
circ (Circle r) = 2.0 * pi * r
circ (Rect d h) = 2.0 * (d + h)
```
```tut:silent
def circ(s: Shape): Float = (s match {
  case Circle(r) => 2.0 * math.Pi * r
  case Rect(d, h) => 2.0 * (d + h)
}).toFloat
```
...............
