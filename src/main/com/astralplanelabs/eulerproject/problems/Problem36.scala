//package com.astralplanelabs.eulerproject.problems

/**
 *
 * User: jtempleton
 *
 **/
object Problem36 {

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

  def main(args: Array[String]) {
    println("Double-base palindromes")

    //println(isPalindrome("bike"))
    //println(isPalindrome("racecar"))
    //println("toBinary(4) = " + toBinary(4))
    //println("toBinary(3) = " + toBinary(3))
    //println("toBinary(156) = " + toBinary(156))

    var sum:Int = 0
    for (i <- 0 until 1000000) {
      val b = toBinary(i)
      if (isPalindrome(b) && isPalindrome("" + i)) {
        sum += i
      }
    }
    println("Sum of all Double Base Palindromes: " + sum)
  }

}
