package arcade.classes

/**
 * Represents a player card.
 *
 * @property cardID The unique ID of each card.
 * @property creditBalance Contains the total credits belonging to the card.
 * @property ticketBalance Contains the total tickets belonging to the card.
 * @constructor Creates a new card with a unique cardID and empty credit and ticket balances.
 */
class Card(
    val cardID: Int = ++UID_Generator,
    var creditBalance: Int = 0,
    var ticketBalance: Int = 0
) {
    /** Companion object containing a unique ID generator it increments by 1 for every new card.*/
    companion object {
        private var UID_Generator: Int = 0
    }
}