package com.astralplanelabs.eulerproject.common

/**
 *
 * User: jtempleton
 *
 **/
trait MathLib {

  def isPrime(x:Int): Boolean = {
    if ((x == 1) || (x == 4)) return false
    if ((x >= 2) && (x <= 5)) return true
    if ((x%2 == 0) || (x%3 == 0) || (x%5 == 0)) return false
    val max:Int = StrictMath.sqrt(x).ceil.toInt
    for (m <- 2 to max) {
      if ((x%m) == 0) return false
    }
    true
  }

  def isComposite(x:Int): Boolean = !isPrime(x)

  def isPanDigital(p:BigInt, d:Int):Boolean = {
    val numString:String = (p + "")
    if (numString.length != d) return false

    for (i <- 1 to 9) {
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

  //
  // Circular prime, all rotations of a number, ex 197, 971, 719 are prime
  //
  def isCircularPrime(x:Int): Boolean = {
    var s:String = x.toString

    for (i <- 1 until s.length) {
      val t:String = s.substring(i) + s.substring(0, i)
      val x:Int = Integer.parseInt(t)
      if (!isPrime(x))
        return false
    }
    return true
  }

  //
  // Find Greatest Common Denominator
  //
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

  def getPentagonNumber(i:Int):Int = {
    (i *(3*i-1)/2)
  }

  //
  // Given 4999, returns List(9994, 9949, 9499, 4999)
  //
  def generatePermutations(n:Int):List[Int] = {
    var perms:List[Int] = List()
    val numAsString:String = "" + n
    val it = numAsString.permutations
    while (it.hasNext) {
      val s:String = it.next()
      perms = Integer.parseInt(s) :: perms
    }
    perms
  }

  def isPermutation(a:Int,b:Int):Boolean = { a.toString.sorted == b.toString.sorted }

  def factorial(a:Int):Int = {
    if (a == 1) return 1
    else factorial(a-1) * a
  }
}
