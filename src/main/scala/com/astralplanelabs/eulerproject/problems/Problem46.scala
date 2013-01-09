package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem46 extends MathLib {

  def main(args: Array[String]) {
    println("Smallest Odd Composite Number Not a Sum")
    if (args.length <= 0) {
      println("Please supply max range")
      exit(-1)
    }
    val max:Int = Integer.parseInt(args(0))
    var c:Int = 9
    while (c <= max) {
       var solFound = false
       if (isComposite(c)) {
         var p:Int = 2
         while (p < max) {
           if (isPrime(p)) {
             var square:Int = 1
             var res:Int = p + 2 * (square * square)
             while ((square <= max) && (res < c)) {
               square += 1
               res = p + 2 * (square * square)
             }
             if (res == c) {
               solFound = true
               p = max
             }
           } // if is prime
           p += 1
         } // while
         if (!solFound) {
           println("No solutions found for " + c)
           exit(0)
         }
       } // if Composite
      c += 2
    } // while
  } // Main
}
