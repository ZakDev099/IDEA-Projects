package cars.utils

/**
 * Responsible for handling and validating user inputs.
 */
object InputHandler {

    /**
     * Reads input from user, typecasts it and returns a non-nullable integer.
     *
     * @return A non-nullable integer.
     */
    fun retrieveInt(): Int {
        var inputIsValid = false
        var result = 0

        while (!inputIsValid) {
            val userInput = readln().toIntOrNull()
            if (userInput != null) {
                result = userInput
                inputIsValid = true
            } else {
                println("Invalid input, try again.\n")
            }
        }
        return result
    }

    /**
     * Reads input from user and typecasts it to a non-nullable integer.
     * Also restricts possible inputs to only accept a range of integers.
     *
     * @param validInputs an IntRange of acceptable inputs.
     * @return A non-nullable integer within range of validInputs.
     */
    fun retrieveInt(validInputs: IntRange): Int {
        var inputIsValid = false
        var result = 0
        while (!inputIsValid) {
            val userInput = readln().toIntOrNull()
            if (userInput != null && userInput in validInputs) {
                result = userInput
                inputIsValid = true
            } else {
                println("Invalid input, try again.\n")
            }
        }
        return result
    }

    /**
     * Prompts the user to press enter before continuing.
     */
    fun retrieveEnter() {
        println("Press enter to continue: ")
        readlnOrNull()
    }

    /**
     * Prompts the user to confirm [Y/N] before continuing. (not case-sensitive)
     *
     * @return Boolean: true if (y), false if (n).
     */
    fun confirmAction(): Boolean {
        var response: String

        do {
            println("Are you sure? [Y/N]")
            response = readln().lowercase()
        } while (response != "y" && response != "n")

        return response == "y"
    }
}