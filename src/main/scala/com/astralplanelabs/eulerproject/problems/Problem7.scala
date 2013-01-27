package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem7 extends MathLib with App {
  var counter:Int = 2
  for (n <- 1 to 110000 by 2) {
    if (isPrime(n)) {
      println("[" + counter + "] = " + n)
      if (counter >= 10001) exit
      counter += 1
    }
  }
}
