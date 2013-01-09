package com.astralplanelabs.eulerproject.problems

//package main.eulerproject

/**
 *
 * User: jtempleton
 *
 **/
object Problem17 {

  var numbersAsWordsOnes:Map[Int, String] = Map(
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine")

  var numbersAsWordsTeens:Map[Int, String] = Map(10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen")

  var numbersAsWordsTens:Map[Int, String] = Map(2 -> "twenty",
    3 -> "thirty",
    4 -> "forty",
    5 -> "fifty",
    6 -> "sixty",
    7 -> "seventy",
    8 -> "eighty",
    9 -> "ninety")


  def convert_teens(num: Integer):String = {
    if (num == 0) return ""
    if (num < 10)
      return numbersAsWordsOnes(num)

    return numbersAsWordsTeens(num)
  }

  def convert_tens(num: Integer):String = {
    if (num < 20)
      return convert_teens(num)

    val numberAsString:String = String.valueOf(num)
    var i = Integer.parseInt("" + numberAsString.charAt(0))
    var wholeWord:String = numbersAsWordsTens(i)
    i = Integer.parseInt("" + numberAsString.charAt(1))
    if (i > 0) {
      wholeWord += numbersAsWordsOnes(i)
    }
    return wholeWord
  }

  def convert_hundreds(num: Integer):String = {
    val numberAsString:String = String.valueOf(num)
    var i = Integer.parseInt("" + numberAsString.charAt(0))
    var wholeWord:String = numbersAsWordsOnes(i) + "hundred"
    var tens:String = numberAsString.substring(1)
    i = Integer.parseInt(tens)
    var word:String = convert_tens(i)
    if (word.length > 0)

    wholeWord = wholeWord + "and" + word
    return wholeWord
  }

  def convert_thousands(num: Integer):String = {
    return "onethousand"
  }

  def lookup_number(num: Integer):Integer = {
    val numberAsString:String = String.valueOf(num)
    val numRev:String = numberAsString.reverse
    var word:String = ""
    var wholeWord:String = ""

    if (numRev.length() == 1) {
      wholeWord = numbersAsWordsOnes(num)
    } else if (numRev.length() == 2) {
      wholeWord = convert_tens(num)
    } else if (numRev.length() == 3) {
      wholeWord = convert_hundreds(num)
    } else if (numRev.length() == 4) {
      wholeWord = convert_thousands(num)
    }
    println(wholeWord)
    return wholeWord.length
  }

    def main(args: Array[String]) {
      if (args.length < 1) {
        println("Error: Parameter required")
        exit(-1)
      }
      var sum:Integer = 0
      for (i <- 1 to Integer.valueOf(args(0))) {
        val r:Integer = lookup_number(i)
        //println(r)
        sum += r
      }
      println(sum)
    }
  }
