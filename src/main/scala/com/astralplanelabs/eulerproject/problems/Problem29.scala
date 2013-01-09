package com.astralplanelabs.eulerproject.problems

//package main.eulerproject

import scala.collection.mutable
/**
 *
 * User: jtempleton
 *
 **/
object Problem29 {


  def main(args: Array[String]) {
    //if (args.length < 1) {
    //  println("Error: Parameter required")
    //  exit(-1)
    //}
    var base_start:Double = 2
    var base_max:Double = 100
    var exp_start:Double = 2
    var exp_max:Double = 100
    var results = mutable.Set.empty[Double]
    val base_range = Range.Double(base_start, base_max+1, 1)
    val exp_range = Range.Double(exp_start, exp_max+1, 1)

    for (base <- base_range) {
      for (exp <- exp_range) {
        var r = Math.pow(base, exp)
        println(base + "^" + exp + " = " + r)
        results.add(r)
      }
    }

    println("Number of distinct vals: " + results.size)
  }
}
