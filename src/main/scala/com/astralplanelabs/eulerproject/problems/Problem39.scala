package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem39 extends MathLib {

  def generateCombinations(sum:Int):List[List[Int]] = {
    var combos:List[List[Int]] = List()

    for (x <- 1 until sum) {
      for (y <- 1 until sum) {
        for (z <- 2 until sum) {
          if ((x+y+z) == sum) {
            val c:List[Int] = List(x, y, z)
            combos = c :: combos
          }
        }
      }
    }
    combos
  }

  def numberOfTriangles(perimeter:Int):Int = {
    val combinations:List[List[Int]] = generateCombinations(perimeter)
    val rightTriangleCombinations = combinations.filter(isRightTriangle(_))
    if (rightTriangleCombinations.size > 0)
        println("-------")
    rightTriangleCombinations.foreach(println)
    rightTriangleCombinations.size
  }

  def main(args: Array[String]) {
    if (args.length <= 0) {
      println("Please supply max range")
      exit(-1)
    }
    val max:Int = Integer.parseInt(args(0))
    var maxSolutions:Int = 1
    var perimeter:Int = 0

    for (i <- max to 2 by -1) {
      var solutions:Int = numberOfTriangles(i)
      if (solutions > maxSolutions) {
        maxSolutions = solutions
        perimeter = i
      }
    }
    println(maxSolutions + " solutions for perimeter " + perimeter)
  }
}
