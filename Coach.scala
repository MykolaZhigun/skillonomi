class Coach(name: String, surname: String, age: Int, val priceCourse: Int, val salary: Int)
  extends Human(name, surname, age) {

  def printCoachInfo(): Unit = {
    val personInfo = super.toString()
    println(s"$personInfo")
    println(s"Ціна курсу: $priceCourse")
  }
}
