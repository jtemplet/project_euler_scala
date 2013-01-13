package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib
import com.astralplanelabs.eulerproject.common.CommonLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem44 extends MathLib with CommonLib {

  def findPentagonalPairs(list:List[List[Int]], pentNums:List[Int]):List[Int] = {
    list.foreach(e =>
      //if (pentNums.contains(sum(e)) && pentNums.contains(StrictMath.abs(e(0) - e(1))))
      if (pentNums.contains(sum(e))) {
        val a = e(0)
        val b = e(1)
        if (a > b) {
          if (pentNums.contains(a-b)) {
            println("Found it! " + e)
            return e
          }
        } else {
          if (pentNums.contains(b-a)) {
            println("Found it! " + e)
            return e
          }
        }
      }
    )
    Nil
  }

  def main(args: Array[String]) {
    var pentagonNumbers:List[Int] = List()
    val max:Int = 10000
    for (n <- 1 to max) {
      pentagonNumbers = getPentagonNumber(n) :: pentagonNumbers
      if ((n % 1000) == 0) {
        println("Checking at " + n)
        val combos:List[List[Int]] = combinations(2, pentagonNumbers)
        if (combos.size > 1) {
          val pairs:List[Int] = findPentagonalPairs(combos, pentagonNumbers)
          if ((pairs != null) && (pairs.size > 1)) {
            println(StrictMath.abs(pairs(0) - pairs(1)))
            return
          }
        }
      }
    }
  }
}
