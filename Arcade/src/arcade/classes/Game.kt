package arcade.classes

/**
 * Represents a single game at the arcade.
 *
 * @property creditCost the amount of credits to remove from a card when the game is played.
 */
class Game(val creditCost: Int) {

    /**
     * Plays the game once, removing the credit cost from the player's card and awarding a
     *    random amount of tickets between 1-500.
     *
     * @param playerCard The card used to pay for the game.
     */
    fun play(playerCard: Card) {
        if (playerCard.creditBalance >= creditCost) {
            val ticketsWon: Int = (1..500).random()
            playerCard.creditBalance -= creditCost
            playerCard.ticketBalance += ticketsWon
            println("\nYou are playing game...")
            println("\nCard: ${playerCard.cardID}")
            println("Tickets Won!: $ticketsWon")
            println("Total Tickets: ${playerCard.ticketBalance}")
        } else {
            println("\nCould not play game\nReason: Insufficient credits...")
        }
    }
}