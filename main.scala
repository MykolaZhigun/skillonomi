import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {

    val students = List(
      new Student("Oleg", "Petrov", age = 21, scholarship = 1200, priceCourse = 120.0f),
      new Student("Ivan", "Petrov", age = 19, scholarship = 750, priceCourse = 120.0f),
      new Student("1", "1", age = 49, scholarship = 750, priceCourse = 120.0f)
    )

    val teacher = new Coach(name = "Igor", surname = "Dmitrievich", age = 42, priceCourse = 500, salary = 500)
    val countStudents = students.length

    println("\nStudents:")
    students.foreach(_.printStudentInfo())

    println("Coach:")
    teacher.printCoachInfo()
    println(s"Count students: $countStudents\n")

    println("Simulation:")

    students.foreach { student =>
      val simulation = new Simulation(scholarship = student.scholarship, priceCourse = 500, salary = 0)

      simulation.oldScholarship()
      val tokens = student.calculateTokens(List.fill(5)(Random.nextInt(5) + 1))
      simulation.newScholarshipFunc(tokens)
      simulation.registerContinue(tokens, priceCourse = 500.0f)
    }

    val teacher1 = new Simulation(scholarship = 1200, priceCourse = 500, salary = 500)
    teacher1.salaryTeacher(priceCourse = 500, studentLearn = countStudents)
  }
}
