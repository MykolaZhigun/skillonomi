class Human(private val name: String, private val surname: String, val age: Int) {
  override def toString: String = s"Name: $name\nSurname: $surname\nAge: $age"
}
