
object Problem22 {

	def main(args: Array[String]) {
	  if (args.length <= 0) {
      	println("Error: Needs input file as argument")
        return
      }
      val source = scala.io.Source.fromFile(args(0))
	  val lines = source.mkString
	  source.close ()
	  val names:Array[String] = lines.split(",")
	  val sortedNames:Array[String] = names.sortWith(_ < _)
	  var totalScore:Int = 0
	  for (i <- 0 until sortedNames.length) {
	    val s:String = sortedNames(i).substring(1, sortedNames(i).size-1)
	    var score:Int = 0
	    val charArr:Array[Char] = s.toCharArray()
	    for (c <- 0 until s.length) {	
	      val tc:Char = charArr(c)
	      score += (tc.intValue()-64)
	    }
	    totalScore = totalScore + (score * (i+1))
        println("[" + i + "] = " + s + ", score = " + score)	
	  }
	  println("Total Score = " + totalScore)
	}
}