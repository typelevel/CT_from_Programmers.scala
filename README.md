### Scala sample code for Bartosz Milewski's [Category Theory for Programmers](https://bartoszmilewski.com/2014/10/28/category-theory-for-programmers-the-preface/)

## WIP
Any contribution (PR, review, issues) will be more than welcome!

[![Build Status](https://travis-ci.org/typelevel/CT_from_Programmers.scala.svg)](https://travis-ci.org/typelevel/CT_from_Programmers.scala)

To compile

```
sbt tut
```

## Style guide

Use **\`\`\`tut:silent\`\`\`** for code that is compilable, use **\`\`\`scala\`\`\`** otherwise.

Use a line of `.............` to separate between code examples. 


There are multiple ways to translate haskell code into scala. For scala syntax, generally speaking we follow the common styles in FP scala codebase (e.g. typelevel/cats)

### functions vs. methods

If it's a "standalone" function, use the function syntax, i.e.
```scala
val f: A => B = ???
```
If it is inside a trait or class, use the method, i.e.

```scala
def f(a: A) : B = ???
```

### Currying

Follow the common strategies in FP codebases, roughly

* if there is one function parameter, create a dedicated parameter list for it and make it the last parameter list. 
* if there are multple function parameters, group them togeher, and put them in a dedicated last paramater list. 
* if the haskell code acutally use the curry application of the function, we curry the scala version to the point to that such application is mirrored in the scala code. 
* of course, implicit parameters have to go in a separate parameter list
* everything else go to a single parameter list. 


## License 

![CC image](https://i.creativecommons.org/l/by/4.0/88x31.png)


This work is licensed under a [Creative Commons Attribution 4.0 International License.](https://creativecommons.org/licenses/by/4.0/)


