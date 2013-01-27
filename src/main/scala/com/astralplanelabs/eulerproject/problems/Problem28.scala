package com.astralplanelabs.eulerproject.problems

/**
 *
 * User: jtempleton
 *
 **/
object Problem28 extends App {

  def spiralDiagonalRecursive(spiralSize:Int):Int = {

    def sdr(i:Int, counter:Int, levelCounter:Int):Int = {
      if (i <= 1) return 1
      var lc:Int = levelCounter
      if ((counter % 4 == 0) && (counter > 0)){
        lc += 2
      }
      return i + sdr(i-(spiralSize-lc), counter+1, lc)
    }
    return sdr(spiralSize*spiralSize, 0, 1)
  }

  def spiralDiagonal(spiralSize:Int):Int = {
    var i:Int = spiralSize * spiralSize
    var sum:Int = i
    var counter:Int = 0
    var levelCounter:Int = 1
    var dec:Int = 0

    while (i > 1) {
      if ((counter % 4 == 0) && (counter > 0)){
        levelCounter += 2
      }
      i = i - (spiralSize-levelCounter)
      counter += 1
      sum += i
    }
    return sum
  }

  var currentTime:Long = System.currentTimeMillis()
  val sumRec:Int = spiralDiagonalRecursive(1001)
  println("Sum Recursive " + sumRec + " took " + (System.currentTimeMillis() - currentTime))
  //currentTime = System.currentTimeMillis()
  //val sumNR:Int = spiralDiagonal(1001)
  //println("Sum Non Recursive " + sumNR + " took " + (System.currentTimeMillis() - currentTime))
}
