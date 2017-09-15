```Haskell
f :: A -> B
```
```scala
val f: A => B
```

```Haskell
g :: B -> C
```
```scala
val g: B => C
```

```Haskell
g . f
```
```scala
g compose f
```

```Haskell
f :: A -> B
g :: B -> C
h :: C -> D
h . (g . f) == (h . g) . f == h . g . f
```
```scala
val f: A => B
val g: B => C
val h: C => D

h compose (g compose f) === (h compose g) compose f == h compose g compose f
```
