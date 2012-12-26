package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib
/**
 *
 * User: jtempleton
 *
 **/
object Problem41 extends MathLib {

  def createDecimalFraction(length:Int):String = {
    var s:String = ""
    for (i <- 1 until length) {
      s = s + i
    }
    return s
  }

  def evaluateProduct(s:String):Long = {
    var prod:Long = 1
    var index:Long = 1

    for (i <- 0 until 7) {
      prod *= s.charAt(index)
      index *= 10
    }
    return prod
  }

  def main(args: Array[String]) {
    val max:Int = 100
    val value:String = createDecimalFraction(max)
    println(value)
    val prod:Int = evaluateProduct(value)
    println(prod)
  }
}
