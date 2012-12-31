package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem23 extends MathLib {
  def main(args: Array[String]) {
    if (args.length <= 0) {
      println("Error: Needs argument")
      return
    }
    println("Getting Abdundant Nums from 1 to " + args(0))
    val max:Int = Integer.parseInt(args(0))
    var abundant:Set[Int] = Set()
    for (i <- 1 to max) {
      var divs:List[Int] = get_divisors(i)
      if (!divs.isEmpty) {
        var sumOfDivs:Int = divs.foldLeft(0)(_+_)
        if (sumOfDivs == i) {
          // perfect Number
        } else if (sumOfDivs > i) {
          // Abundant Number
          abundant += i
        }
      }
    } // for

    val sum:Int = abundant.foldLeft(0)(_+_)
    println("Total sum of abundant nums = " + sum)
  }
}
