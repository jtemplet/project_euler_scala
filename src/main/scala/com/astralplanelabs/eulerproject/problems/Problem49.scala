package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem49 extends MathLib {

  def main(args: Array[String]) {
    val max:Int = 10000
    val start:Int = 1000

    var primeList:List[Int] = List()
    for (n <- start to max) {
      if (isPrime(n)) {
        primeList = n :: primeList
      }
    }

    for (i <- 0 until primeList.size) {
      val a = primeList(i)
      //println(a)
      for (j <- i+1 until primeList.size) {
        val b = primeList(j)
        val k =  StrictMath.abs(b - a)

          if (isPermutation(b, a) && (k==3330)) {
            println(b + " " + a)
          }

      }
    }
  }
}


/*
        val perms:List[Int] = generatePermutations(i)
        var p:Int = 0
        perms.foreach(e => {
          if (isPrime(e))
            p+=1
        })
        if (p >= 3) {
          var diffHist:List[Int] = List()
          var lastVar:Int = 0
          perms.sorted.foreach(e => {
            val diff:Int = e - lastVar
            diffHist = diff :: diffHist
            lastVar = e
          })
          val unique:List[Int] = diffHist.distinct
          val duplicates:List[Int] = diffHist.diff(unique)
          if (duplicates.size > 0){
            //var occurances:List[Int] = List()
            println("Prime = " + i)
            val m = (diffHist.groupBy(identity).mapValues(_.size).filter(e => (e._2 > 2) && (e._1.toString.length > 3)))

          }
*/