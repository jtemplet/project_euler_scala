package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib
/**
 *
 * User: jtempleton
 *
 **/
object Problem40 extends MathLib {

  def createDecimalFraction(length:Int):StringBuilder = {
    var s:StringBuilder = new StringBuilder
    for (i <- 1 until length) {
      s.append(i)
    }
    return s
  }

  def evaluateProduct(s:StringBuilder, mults:Int):BigInt = {
    var prod:BigInt = 1
    var index:Int = 1

    for (i <- 0 until mults) {
      println("Index = " + (index))
      val v:Int = Integer.parseInt(s.charAt(index-1) + "")
      //println("Got value: " + v)
      println("Multiplying: " + prod + " * " + v)
      prod *= v
      index *= 10
    }
    return prod
  }

  def main(args: Array[String]) {
    val numOfMults:Int = 7
    val max:Int = 1000000
    val value:StringBuilder = createDecimalFraction(max)
    println(value.toString())
    println("length of string: " + value.length)
    val prod:BigInt = evaluateProduct(value, numOfMults)
    println(prod)
  }
}
