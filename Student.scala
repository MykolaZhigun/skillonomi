import scala.util.Random

class Student(name: String, surname: String, age: Int, val scholarship: Int, val priceCourse: Float)
  extends Human(name, surname, age) {

  private var studentTokens = 0.0f

  def calculateTokens(grades: List[Int]): Float = {
    studentTokens = 0.0f

    for (grade <- grades) {
      studentTokens += {
        if (grade == 1) 0.7f * priceCourse
        else if (grade == 2) 0.8f * priceCourse
        else if (grade == 3) 0.9f * priceCourse
        else if (grade == 4) 1.0f * priceCourse
        else if (grade == 5) 1.1f * priceCourse
        else 0.0f
      }
    }

    studentTokens
  }

  def printStudentInfo(): Unit = {
    val personInfo = super.toString()
    val grades = List.fill(3)(List.fill(2)(Random.nextInt(5) + 1))

    println(s"Name: $name")
    println(s"Surname: $surname")
    println(s"Age: $age")
    println(s"Scholarship: $scholarship")
    println(s"Оценки:")

    for ((monthGrades, month) <- grades.zipWithIndex) {
      println(s"  Month ${month + 1}: ${monthGrades.mkString(", ")}")
    }

    calculateTokens(grades.flatten)
    println(s"Кількість токенів: $studentTokens\n")
  }
}
