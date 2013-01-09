//package com.astralplanelabs.eulerproject.problems

import collection.mutable

/**
 *
 * User: jtempleton
 *
 **/
object Problem43 {

  val primes = Set(2, 3, 5, 7, 11, 13, 17)

  def isPanDigital(p:Double):Boolean = {
    var numString:String = p + ""
    if (numString.length != 10) return false

    for (i <- (new Range(0, 10, 1))) {
      if (!numString.contains("" + i)) return false
    }
    return true
  }
/*
  def groupBy3s(p:Long):Boolean = {
    var numString:String = p + ""
    for (i <- (new Range(1, 9, 1))) {
       val sub:String = numString.substring(i, 3)
       val subInt:Int = Integer.parseInt(sub)
       if (subInt%primes(i-1) != 0) return false
    }

    return true
  }
*/
  def main(args: Array[String]) {
    println("Sub-String Divisibility")
    var results:List[Double] = List()
    //val range = Range.Long(1000000000l, 9999999999l, 1l)
    val range = Range.Double(1000000000d, 9999999999d, 1)
  println("Hello")
    for (i <- range) {
      println(i)
      if (isPanDigital(i)) {
        println(i)
        results ::= i  // add(i)
      }
    }
    if (results.size > 0) {
      println("Found " + results.size + " Pan-Digital Items")
      val sum = results.sum
      println(sum)
    } else {
      println("No Pan-Digital Vals Found")
    }
  }
}
