package com.astralplanelabs.eulerproject.common

/**
 *
 * User: jtempleton
 *
 **/
trait MathLib {

  def isPrime(x:Int): Boolean = {
    if (x==4) return false
    //val range = Range(2, Math.sqrt(x).toInt)
    val range = Range(2, x/2)

    for (m <- range) {
      //println(x + " % " + m + " = " + (x%m))
      if ((x%m) == 0) return false
    }
    //println(x + " is a prime")
    return true
  }

  def isComposite(x:Int): Boolean = !isPrime(x)

  def isPanDigital(p:Double, d:Int):Boolean = {
    var numString:String = p + ""
    if (numString.length != (d+1)) return false

    for (i <- (new Range(0, (d+1), 1))) {
      if (!numString.contains("" + i)) return false
    }
    return true
  }

  def isPalindrome(s:String):Boolean = {

    for (i <- 0 until (s.length/2)) {
      if (s.charAt(i) != s.charAt(s.length-1-i)) {
        return false
      }
    }
    return true
  }

  def toBinary(i:Int):String = {
    var res:String = ""
    var quotient:Int = i
    while (quotient >= 1) {
      var mod:Int = quotient%2
      res = mod + res
      quotient = quotient/2
    }
    return res
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

  def gcd(x:Int, y:Int):Int = {
    if (y == 0) return x else return gcd(y, x%y)
  }

  /** *******************************
    * Recursive sum not using foldLeft
    *
    * @param xs
    * @return
    *********************************/
  def sum(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException("List is empty")
    if (xs.length == 1) return xs.head
    return xs.head + sum(xs.tail)
  }

  /** *******************************
    * Recursive max not using foldLeft
    *
    * @param xs
    * @return
    *********************************/
  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException("List is empty")
    def loop(xs: List[Int], acc:Int):Int = {
      if (xs.length == 1) return acc
      if (xs.head > acc) {
        return loop(xs.tail, xs.head)
      }
      return loop(xs.tail, acc)
    }
    return loop(xs.tail, xs.head)
  }

  def get_divisors(n:Int):List[Int] = {
    var div:List[Int] = List()

    for (i <- 1 to (n/2)) {
      if ((n%i) == 0)
        div = i :: div
    }
    div
  }

  def isRightTriangle(sides:List[Int]):Boolean = {
    if (sides.size != 3) return false
    // get the longest side aka the hyp
    val hyp:Int = max(sides)
    val sorted:List[Int] = sides.filter(_ != hyp)
    if (sorted.size < 2) return false
    val a:Int = sorted(0)
    val b:Int = sorted(1)

    // verify a*a + b*b = hyp*hyp
    ((a*a + b*b) == hyp*hyp)
  }

  def isTriangle(sides:List[Int], perimeter:Int) = {
    (sides.reduceLeft(_ + _) == perimeter)
  }
}
