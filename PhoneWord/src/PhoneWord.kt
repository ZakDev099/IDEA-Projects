class AlphaNumConverter(val userInput: String, val keyMap: Map<Char, Byte>) {
    // Loops through each character in string and prints the corresponding value,
    // else, if key doesn't exist, prints the character
    fun convertToNum() {
        for (x: Char in userInput) {
            if (keyMap.containsKey(x)) {
                print(keyMap[x])
            }
            else {
                print(x)
            }
        }
    }
}

fun main() {
    // Mapping each key to its numerical value
    val keyMap = mapOf<Char, Byte>(
        'a' to 2, 'b' to 2, 'c' to 2,
        'd' to 3, 'e' to 3, 'f' to 3,
        'g' to 4, 'h' to 4, 'i' to 4,
        'j' to 5, 'k' to 5, 'l' to 5,
        'm' to 6, 'n' to 6, 'o' to 6,
        'p' to 7, 'q' to 7, 'r' to 7, 's' to 7,
        't' to 8, 'u' to 8, 'v' to 8,
        'w' to 9, 'x' to 9, 'y' to 9, 'z' to 9
    )
    // Retrieves user input and converts string to lowercase for use as keys
    print("Enter Phone Number: ")
    val userInput = readln().lowercase()
    val converter = AlphaNumConverter(userInput,keyMap)
    converter.convertToNum()
}