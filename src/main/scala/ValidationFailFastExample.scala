import scalaz.{-\/, \/-, \/}

object Utils {
  def readIntFromUser: \/[String, Int] = {
    val keyboardInput = scala.io.StdIn.readLine()
    try {
      \/.right(keyboardInput.toInt)
    } catch {
      case e: NumberFormatException =>
        \/.left(keyboardInput + " is not a valid number")
    }
  }
}

object ValidationExample extends App {

  println("Welcome to this")

  println("Please enter three integers, separated by a newline")

  val sum =
    for {
      x <- Utils.readIntFromUser
      y <- Utils.readIntFromUser
      z <- Utils.readIntFromUser
    } yield x + y + z

  sum match {
    case \/-(number) => println("Your sum is " + sum)
    case -\/(errorMsg) => println("Your error is: " + errorMsg)
  }
}
