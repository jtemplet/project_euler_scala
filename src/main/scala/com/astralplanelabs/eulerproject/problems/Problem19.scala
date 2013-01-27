
object Problem19 extends App {
  def isLeapYear(year:Int):Boolean = {
    var res:Boolean = false
    if ((year%100 == 0) && (year%400 == 0) && (year%4 == 0)) res = true      
    else if ((year%100 != 0) && (year%4 == 0)) res = true
    res
  }

  var sundayCounter:Int = 0
  
  var dayCounter:Int = 1
  var doyCounter:Int = 1
  var domCounter:Int = 1
  var dowCounter:Int = 1

  var monthCounter:Int = 1
  var weekCounter:Int = 1
  var yearCounter:Int = 1900
  println("1901 to 2000")
  while ((yearCounter <= 2000) && (monthCounter <= 12)) {

    // Week Stuff
    if ((dayCounter%7) == 0) weekCounter += 1
  
    if (yearCounter > 1900) {
      if (dayCounter%7 == 0) sundayCounter += 1
    } 

    // Month Stuff
    if ((monthCounter == 9) || (monthCounter == 6) || (monthCounter == 11) || (monthCounter == 4)) {
      if (domCounter == 30) {
        domCounter = 1
        monthCounter += 1
      }
    } else if (monthCounter == 2) {
      if (isLeapYear(yearCounter) && (domCounter == 29)) {
        domCounter = 1
        monthCounter += 1
      }
      else if (domCounter == 28) {
        domCounter = 1
        monthCounter += 1
      }
    } else {
      if (domCounter == 31) {
        domCounter = 1
        monthCounter += 1
      }
    }

    // Year Stuff
    if (monthCounter > 12) {
      println("Year Counter " + yearCounter)
      println("Sunday Counter = " + sundayCounter)
      yearCounter += 1
      monthCounter = 1
    }
    dayCounter += 1
    domCounter += 1
  } // while
  println("Sunday Counter = " + sundayCounter)
}
