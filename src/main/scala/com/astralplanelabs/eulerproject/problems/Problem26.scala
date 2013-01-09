package com.astralplanelabs.eulerproject.problems

import java.math.BigDecimal
import java.math.RoundingMode
/**
 *
 * User: jtempleton
 *
 **/
object Problem26 {

  var maxPatternLength:Int = 0
  var denominator:Int = 0

  def findPattern(i:Int) = {
    var f:Double = 1/(i.toDouble)

    var bd:BigDecimal = BigDecimal.ONE.divide(new BigDecimal(i),i+i, RoundingMode.CEILING)
    //val s:String = f.toString
    val bigDecimalStr = bd.toString()
    var maxLength:Int = 0
    // 0.1234567123456123456123456
    var buffer:String = ""
    var startIndex:Int = 2
    var endIndex:Int = 3
   // println("Double as string     = " + f)
    //println("BigDecimal as string = " + bigDecimalStr)
    while(endIndex < bigDecimalStr.length) {
      val searchTerm:String = bigDecimalStr.substring(startIndex, endIndex)
      val lastChar = searchTerm.substring(searchTerm.length-1)
      if ((bigDecimalStr.indexOf(searchTerm, endIndex) > 0) &&
          (searchTerm.substring(0, searchTerm.length-1).indexOf(lastChar) < 0)) {
        buffer = searchTerm
        endIndex += 1
        if (buffer.length > maxPatternLength) {
          maxPatternLength = buffer.length
          println("Found New Max Pattern In: " + f + ", buffer = " + buffer)
          denominator = i
        }
      } else {
        startIndex = endIndex
        endIndex += 1
        //buffer = ""
      }
    }
  }

  def main(args: Array[String]) {

    val max:Int = 1000-1
    var maxLength = 0
    for (i <- 2 to max) {

      println("Looking at 1/" + i)
      findPattern(i)
    }
    println("Max Length of recurring pattern = " + maxPatternLength + " with 1/" + denominator)
  }
}
