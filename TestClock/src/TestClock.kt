// Primary constructor initializes properties as 0
class Clock() {
    var hour: Int = 0
    var minute: Int = 0
    var second: Int = 0

    // This constructor is used for setting the time manually
    constructor (inputHour: Int, inputMinute: Int, inputSecond: Int) : this() {
        hour = inputHour
        minute = inputMinute
        second = inputSecond
    }
    fun resetClock() {
        hour = 0
        minute = 0
        second = 0
    }
    // increments time by one second and resets when max value is reached, resets and increment the next variable by 1
    fun addSecond() {
        second++
        if (second >= 60) {
            second = 0
            minute++
            if (minute >= 60) {
                minute =0
                hour++
                if (hour >= 24) {
                    hour = 0
                }
            }
        }
    }
}

fun main() {
    var myClock = Clock()
    var menuSelection: Char
    var inputHour: Int
    var inputMinute: Int
    var inputSecond: Int
    var runProgram = true
    // Continuously run the program until the user quits the menu, allowing consecutive user inputs
    while (runProgram) {
        // Provide a display of the current time and menu options to user
        println("The current time ==> ${myClock.hour} : ${myClock.minute} : ${myClock.second}")
        println("Enter 's' to set the time.")
        println("Enter 'a' to advance one second.")
        println("Enter 'r' to reset the clock.")
        println("Enter 'q' to quit.")
        // Check and validate user input for a menu selection and provide functionality for each option
        menuSelection = readln().first()
        when (menuSelection) {
            /*
             * Per the activity requirements, this block sets the clock time manually (based on user input)
             * by creating a replacement object with custom properties using the secondary constructor
             */
            's' -> {
                println("You can now set the clock\n")
                println("Enter hour (0 - 23): ")
                inputHour = readln().toInt()
                println("Enter minute (0 - 59): ")
                inputMinute = readln().toInt()
                println("Enter second (0 - 59): ")
                inputSecond = readln().toInt()
                if (inputHour in 0..23 && inputMinute in 0..59 && inputSecond in 0..59) {
                    myClock = Clock(inputHour, inputMinute, inputSecond)
                } else {
                    println("Invalid input. Please try again...\n")
                }
            }
            'a' -> myClock.addSecond()
            'r' -> myClock.resetClock()
            // Quits the program, ending the while loop
            'q' -> runProgram = false
            // Simple error check, restarts the loop
            else -> println("Invalid input. Please try again...\n")
        }
    }
}