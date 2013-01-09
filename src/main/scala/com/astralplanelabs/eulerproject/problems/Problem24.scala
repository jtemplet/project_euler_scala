package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem24 extends MathLib {
  def main(args: Array[String]) {
    if (args.length <= 0) {
      println("Error: Needs argument")
      return
    }
    println("Getting Sorted Permutations ")
    val max:Int = 9 //Integer.parseInt(args(0))
    var numList:List[Int] = List()
    // Create List
    for (i <- 0 to max) {
      numList = i :: numList
    } // for
    println("Generating Perms")
    var numListStr:List[String] = List()
    var perms = numList.permutations
    for (p <- perms) {
      val s = p.mkString
      numListStr = s :: numListStr
    }
    println("Generated Perms, going to sort")
    val x = numListStr.sortWith(_ < _)(1000000-1)
    println(x)
  }
}
