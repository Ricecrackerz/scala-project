import scala.util.control.Breaks.break

object Main {
  def main (args: Array[String]): Unit = {
    var num1: Float = 0
    var num2: Float = 0
    var operator = 0
    var result: Float = 0

    println("Welcome to the Scala Calculator!")
    println("Enter your first number you want to calculate: ")
    num1 = scala.io.StdIn.readFloat()
    println("Enter your second number you want to calculate: ")
    num2 = scala.io.StdIn.readFloat()
    val calc = new Calculator(num1,num2)


    while(operator != 'e'){
      println(
        "\nEnter the operation you want to perform: " +
          "\n<1> Add" +
          "\n<2> Subtract" +
          "\n<3> Multiply" +
          "\n<4> Divide" +
          "\n<5> Square First Number" +
          "\n<6> Square Second Number" +
          "\n<7> Cube First Number" +
          "\n<8> Cube Second Number" +
          "\n<9> Change your first number" +
          "\n<10> Change your second number" +
          "\n<11> Exit"
      )
      operator = scala.io.StdIn.readInt()
      operator match{
        case 1 => result = calc.calcAdd(num1,num2)
        case 2 => result = calc.calcSub(num1,num2)
        case 3 => result = calc.calcMulti(num1,num2)
        case 4 => result = calc.calcDiv(num1,num2)
        case 5 => result = calc.calcAnything(num1, calc.calcSquare)
        case 6 => result = calc.calcAnything(num2, calc.calcSquare)
        case 7 => result = calc.calcAnything(num1, calc.calcCube)
        case 8 => result = calc.calcAnything(num2, calc.calcCube)
        case 9 => println("Enter your first number you want to calculate: ")
                  num1 = scala.io.StdIn.readFloat()
        case 10 => println("Enter your second number you want to calculate: ")
                   num2 = scala.io.StdIn.readFloat()
        case 11 => println("Goodbye!")
                   break
      }//end match
      println("Your RESULT: " + result)
    }//end while
  }

  //Calculator Object
  class Calculator (var num1: Float, var num2: Float){
    //Calculator Functions
    def calcAnything(num1: Float, calcFunction: Float => Float): Float = calcFunction(num1)
    def calcSquare(num1: Float): Float = num1 * num1
    def calcCube(num1: Float): Float = num1 * num1 * num1
    def calcAdd(num1: Float, num2: Float): Float = num1 + num2
    def calcSub(num1: Float, num2: Float): Float = num1 - num2
    def calcMulti(num1: Float, num2: Float): Float = num1 * num2
    def calcDiv(num1: Float, num2: Float): Float = {
      if(num2 != 0){
        num1 / num2
      }else{
        println("Your second number can't be zero!")
        num2 / num1
      }
    }
  }
}