
object Problem31 {

  def main(args: Array[String]) {
    var counter:Int = 0
  
    for(lb_2 <- 0 to 1) {
       for(lb_1 <- 0 to 2) {
         for(p_50 <- 0 to 4) {
           for (p_20 <- 0 to 10) {
             for(p_10 <- 0 to 20) {
               for(p_5 <- 0 to 40) {
                 for (p_2 <- 0 to 100) {
                   for (p_1 <- 0 to 200) {
                      if (((p_1 * 1) +
                          (p_2 * 2) +
                          (p_5 * 5) +
                          (p_10 * 10) + (p_20 * 20) + (p_50 * 50) + (lb_1 * 100) + (lb_2 * 200)) == 200) {
                         //println("LB2: " + lb_2 + " LB1: " + lb_1 + " P50 " + p_50)
                         counter += 1
                      }
                   }
                 }
               }
             }
           }
         }
       } // lb_1 
    } // lb_2
    println(counter)
  } // main
}