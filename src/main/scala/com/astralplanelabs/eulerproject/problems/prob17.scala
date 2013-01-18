
object Problem17 {

  var numbersAsWordsOnes:Map[Int, String] = Map(0 -> "zero",
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
     return numbersAsWordsTeens(num)
  }
  
  def convert_tens(num: Integer):String = {
  	 if (num < 20)
  	   return convert_teens(num)
  	 else
       return numbersAsWordsTens(num)
  }

  def convert_hundreds(num: Integer):String = {
     return (numbersAsWordsOnes(num) + "hundred")
  }

  def convert_thousands(num: Integer):String = {
     return numbersAsWordsOnes(num) + "thousand"
  }

  def lookup_number(num: Integer):Integer = {
  	var numberAsString:String = String.valueOf(num)
    var numRev:String = numberAsString.reverse()
    var word:String = ""

    if (numRev.length() == 1) {
       word = numbersAsWordsOnes(num)
    } else if (numRev.length() == 2) {

    } else if (numRev.length() == 3) {

    } 

    
    
/*  	    
  	    var tens:String = convert_tens(Integer.parseInt("" + numberAsString.charAt(0)))
  	    	var i = Integer.parseInt("" + numberAsString.charAt(1))
  	    	
  	    	if (i != 0) {
  	    	  var ones:String = numbersAsWordsOnes(i)  	    	
  	    	  word = tens + ones
  	    	} else {
  	    		word = tens
  	    	}
  	    	println("Whole word:  " + word)
  	    	sum = word.length()
  	    } else if (numberAsString.length() == 3) {
  	    	var tens:String = ""
  	    	var ones:String = ""
  	    	var hundreds:String = convert_hundreds(Integer.parseInt("" + numberAsString.charAt(0)))
  	    	var tensAsInt:Integer = Integer.parseInt("" + numberAsString.charAt(1))  	    	
  	    	
  	    	if (tensAsInt != 0) {
  	    	   tens = convert_tens(i)
  	    	   tens = "and" + tens
  	    	}
  	    	i = Integer.parseInt("" + numberAsString.charAt(2))
  	    	if (i != 0) {
  	    	   ones = numbersAsWordsOnes(i)
  	    	   ones = "and" + ones
  	    	}
  	    	word = hundreds + tens + ones
  	    	println(word)
  	    	sum = word.length()
  	    } else if (numberAsString.length() == 4) {
  	    	println("THounsands not supported")
  	    }
  	}	
  	  	
        //var word = numbersAsWordsOnes(num)
        //var wordLength:Integer = word.toString().length()
        //sum += wordLength
*/      
   
  }

  def main(args: Array[String]) {
    println("Looking up " + args(0))
    println(lookup_number(Integer.valueOf(args(0))))
  }
}