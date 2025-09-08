package customers.utils

/** Responsible for handling and validating user inputs. */
object InputHandler {

    /**
     * Reads input from user and typecasts it and returns a non-nullable integer.
     * Also restricts [validInputs] to only accept a range of integers (any Int by default).
     */
    fun retrieveInt(validInputs: IntRange = Int.MIN_VALUE..Int.MAX_VALUE): Int {
        var inputIsValid = false
        var result = 0
        while (!inputIsValid) {
            val userInput = readln().toIntOrNull()
            if (userInput != null && userInput in validInputs) {
                result = userInput
                inputIsValid = true
            } else {
                println("Invalid input, try again.")
            }
        }
        return result
    }

    /** Prompts the user to press enter before continuing. */
    fun retrieveEnter() {
        println("Press enter to continue: ")
        readlnOrNull()
    }

    /**
     * Prompts the user with a generic or custom [message] to confirm [Y/N] before continuing. (not case-sensitive)
     *
     * @return Boolean: true if (y), false if (n).
     */
    fun confirmAction(message: String = "Are you sure?"): Boolean {
        var response: String

        do {
            println("$message [Y/N]")
            response = readln().lowercase()
        } while (response != "y" && response != "n")

        return response == "y"
    }
}