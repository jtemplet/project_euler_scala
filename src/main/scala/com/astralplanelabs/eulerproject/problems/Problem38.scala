package com.astralplanelabs.eulerproject.problems

import com.astralplanelabs.eulerproject.common.MathLib

/**
 *
 * User: jtempleton
 *
 **/
object Problem38 extends MathLib with App {

  var products:List[Int] = List()
  for (n <- 1 to 9) {
    products = n :: products
  }
  var max:BigInt = 0
  for ( n <- 2 to (987654321/9)) {
    val productRes:List[Int] = products.map( x => x * n).sorted
    var concat:String = ""
    var i:Int = 0

    while (i < productRes.length) {
      concat += productRes(i)
      if (isPanDigital(BigInt(concat), 9)) {

        if (BigInt(concat) > max) {
          max = BigInt(concat)
          println(max)
        }
      } else if (concat.length >= 9) i = productRes.length
      i += 1
    }
  }

}
