package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem37 extends MathLib {

  def isTruncatablePrimeLeft(n:BigInt):Boolean = {
    val originalNum:String = "" + n
    for (i <- 0 until originalNum.length) {
      val num:Int = Integer.parseInt(originalNum.substring(0, originalNum.length() - i))
      if (!isPrime(num)) return false
    }
    true
  }

  def isTruncatablePrimeRight(n:BigInt):Boolean = {
    val originalNum:String = "" + n
    for (i <- 0 until originalNum.length) {
      val num:Int = Integer.parseInt(originalNum.substring(i))
      if (!isPrime(num)) return false
    }
    true
  }

  def isTruncatablePrime(n:BigInt):Boolean = {
    return isTruncatablePrimeLeft(n) && isTruncatablePrimeRight(n)
  }

  def main(args: Array[String]) {
    var n:Int = 11
    var sum:BigInt = 0
    var counter:Int = 0
    while (n < 9999999) {
      if (!((n%2) == 0) || ((n%5) == 0) || ((n %3) == 0)) {
        if (isPrime(n)) {
          if (isTruncatablePrime(n)) {
            counter += 1
            println("Truncatable Prime [" + counter + "] = " + n + ", sum = " + sum)
            sum += n

          }
        }
      }
      n += 2
    } // while
    println ("Sum = " + sum)
  }
}
