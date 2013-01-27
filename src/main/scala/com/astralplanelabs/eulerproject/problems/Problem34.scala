package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem34 extends MathLib {


  def f(args:List[Int], sum:Int):Int = {
    val xyz:Int = Integer.parseInt(args.mkString("", "", ""))

    val fact:Int = args.map( x => factorial(x)).foldLeft(0)(_+_)
    if (xyz == fact) {
      println("2 digits = " + xyz)
      return sum + xyz
    }
    sum
  }

  def twoDigits():Int = {
    var sum:Int = 0

    for (y <- 1 to 9) {
      for (z <- 1 to 9) {
        val xyz:Int = Integer.parseInt(y + "" + z)
        val fact:Int = factorial(y) + factorial(z)
        if (xyz == fact) {
          sum += xyz
          println("2 digits = " + xyz)
        }
      }
    }
    sum
  }

  def threeDigits():Int = {
    var sum:Int = 0
    for (x <- 1 to 9) {
      for (y <- 1 to 9) {
        for (z <- 1 to 9) {
          val xyz:Int = Integer.parseInt(x + "" + y + "" + z)
          val fact:Int = factorial(x) + factorial(y) + factorial(z)
          if (xyz == fact) {
            sum += xyz
            println("3 digits = " + xyz)
          }
        }
      }
    }
    sum
  }

  def fourDigits():Int = {
    var sum:Int = 0
    for (x <- 1 to 9) {
      for (y <- 1 to 9) {
        for (z <- 1 to 9) {
          for (a <- 1 to 9) {
            val xyz:Int = Integer.parseInt(x + "" + y + "" + z + "" + a)
            val fact:Int = factorial(x) + factorial(y) + factorial(z) + factorial(a)
            if (xyz == fact) {
              sum += xyz
              println("4 digits = " + xyz)
            }
          }
        }
      }
    }
    sum
  }

  def fiveDigits():Int = {
    var sum:Int = 0
    for (x <- 1 to 9) {
      for (y <- 1 to 9) {
        for (z <- 1 to 9) {
          for (a <- 1 to 9) {
            for (b <- 1 to 9) {
              val xyz:Int = Integer.parseInt(x + "" + y + "" + z + "" + a + "" + b)
              val fact:Int = factorial(x) + factorial(y) + factorial(z) + factorial(a) + factorial(b)
              if (xyz == fact) {
                sum += xyz
                println("4 digits = " + xyz)
              }
            }
          }
        }
      }
    }
    sum
  }

  def sixDigits():Int = {
    var sum:Int = 0
    for (x <- 1 to 9) {
      for (y <- 1 to 9) {
        for (z <- 1 to 9) {
          for (a <- 1 to 9) {
            for (b <- 1 to 9) {
              for (c <- 1 to 9 ) {
                val xyz:Int = Integer.parseInt(x + "" + y + "" + z + "" + a + "" + b + "" + c)
                val fact:Int = factorial(x) + factorial(y) + factorial(z) + factorial(a) + factorial(b) + factorial(c)
                if (xyz == fact) {
                  sum += xyz
                  println("4 digits = " + xyz)
                }
              }
            }
          }
        }
      }
    }
    sum
  }

  def main(args: Array[String]) {
    var sum:Int = 0
    sum += twoDigits()
    sum += threeDigits()
    sum += fourDigits()
    sum += fiveDigits()
    sum += sixDigits()
    println("Sum = " + sum)
  } // main
}
