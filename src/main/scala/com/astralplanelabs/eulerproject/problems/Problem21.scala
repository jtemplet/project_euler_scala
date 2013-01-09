package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem21 extends MathLib {

  def sumDivisors(x:Int):Int = {
    val divs:List[Int] = get_divisors(x)
    if (!divs.isEmpty)
      return sum(divs)
    0
  }

  def main(args: Array[String]) {
    if (args.length <= 0) {
      println("Error: Needs argument")
      return
    }
    val max:Int = Integer.parseInt(args(0))
    var amicable:Set[Int] = Set()

    for (i <- 1 until max) {
      val sumOfDivs:Int = sumDivisors(i)
      if ((i==sumDivisors(sumOfDivs)) && (i != sumOfDivs)) {
        println (i + ", " + sumOfDivs)
        amicable += i
        amicable += sumOfDivs
      }
    } // for

    val sum:Int = amicable.foldLeft(0)(_+_)
    println("Total sum of amicable sums = " + sum)
  }
}
