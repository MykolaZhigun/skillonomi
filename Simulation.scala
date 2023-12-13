import scala.util.Random

class Simulation(scholarship: Int, priceCourse: Int, salary: Int) {
  private val random = new Random()

  def oldScholarship(): Unit = {
    println(s"Стара стипендія: $scholarship")
  }

  def newScholarshipFunc(tokens: Float): Unit = {
    val newScholarship = tokens * 2
    println(s"Нова стипендія: $newScholarship\n")
  }

  def registerContinue(tokens: Float, priceCourse: Float): Unit = {
    val numberRandomResult = random.nextInt(2) + 1

    if (numberRandomResult == 1) {
      if ((tokens - priceCourse) >= 0) {
        println("Ви продовжуєте навчання!\n")
        val remainingTokens = tokens - priceCourse
        println(s"Кількість токенів: $remainingTokens")
      } else {
        val tokensNeeded = priceCourse - tokens
        println(s"Не достатньо токенів для навчання!\nВам потрібно $tokensNeeded\n")
        shopToken(tokensNeeded)
      }
    } else {
      println("Навчання завершено за бажанням студента!\n")
    }
  }

  def shopToken(tokensNeededToBuy: Float): Unit = {

    def buyToken(): Unit = {
      if (tokensNeededToBuy <= 0) {
        println("Необхідно позитивне значення кількості токенів для покупки.")
      } else {
        val tokensToBuy = tokensNeededToBuy / priceCourse
        println(s"Покупка $tokensToBuy токенів за $tokensNeededToBuy грн.")
      }
    }

    def sellToken(tokensToSell: Float): Unit = {
      if (tokensToSell <= 0) {
        println("Необхідно позитивне значення кількості токенів для продажу.")
      } else {
        val moneyEarned = tokensToSell * priceCourse
        println(s"Продаж $tokensToSell токенів за $moneyEarned грн.")
      }
    }
  }

  def salaryTeacher(priceCourse: Int, studentLearn: Int): Unit = {
    val teacherSalary = salary + priceCourse * studentLearn
    println(s"\nЗарплата вчителя: $teacherSalary")
  }
}
