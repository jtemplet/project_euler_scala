package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem50 extends MathLib {

  def sumIncrementalSeries(i:Int, max:Int):Int = {
    if (i > max)
      0
    else
      (i + sumIncrementalSeries(i+1, max))
  }

  def sumEvenSeries(i:Int, max:Int):Int = {
    if (i > max)
      0
    else if ((i%2) == 0)
      (i + sumEvenSeries(i+1, max))
    else
      (0 + sumEvenSeries(i+1, max))
  }

  def printIncrementalSeries(i:Int, max:Int):String = {
    if (i > max)
      ""
    else
      (i + " " + printIncrementalSeries(i+1, max))
  }

  def printEvenSeries(i:Int, max:Int):String = {
    if (i > max)
      ""
    else if ((i%2) == 0)
      (i + " " + printEvenSeries(i+1, max))
    else
      ("" + printEvenSeries(i+1, max))
  }

  def primeSeries(i:Int, max:Int):String = {
    if (i > max)
      ""
    else if (isPrime(i))
      (i + " " + primeSeries(i+1, max))
    else
      ("" + primeSeries(i+1, max))
  }

  def main(args: Array[String]) {
    if (args.length <= 0) {
      println("Please supply max range")
      exit(-1)
    }
    val max:Int = Integer.parseInt(args(0))
    println("Sum = " + sumIncrementalSeries(0, max))

    println("Series = " + printIncrementalSeries(0, max))

    println("Even Sum = " + sumEvenSeries(0, max))

    println("Even Series = " + printEvenSeries(0, max))

    println("Prime Series = " + primeSeries(0, max))
  }

}
