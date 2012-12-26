package com.astralplanelabs.eulerproject.problems

//package main.eulerproject

import collection.mutable

/**
 *
 * User: jtempleton
 *
 **/
object Problem35 {

  def isPrime(x:Int): Boolean = {
    if (x==4) return false
    //val range = Range(2, Math.sqrt(x).toInt)
    val range = Range(2, x/2)

    for (m <- range) {
      //println(x + " % " + m + " = " + (x%m))
      if ((x%m) == 0) return false
    }
    println(x + " is a prime")
    return true
  }

  def isCircular(x:Int): Boolean = {
    var s:String = x.toString

    for (i <- 1 until s.length) {
      val t:String = s.substring(i) + s.substring(0, i)
      val x:Int = Integer.parseInt(t)
      if (!isPrime(x))
        return false
    }
    return true
  }

  def main(args: Array[String]) {
    if (args.length < 1) {
      println("Error: Parameter required")
      exit(-1)
    }
    val max:Int = Integer.parseInt(args(0))+ 1
    val range = Range(2, max, 1)
    var results = mutable.Set.empty[Int]
    for (r <- range) {
       if (isPrime(r)) {
         if (isCircular(r)) {
           results.add(r)
         }
       }
    }
    println("Total circular primes = " + results.size)
  }
}
