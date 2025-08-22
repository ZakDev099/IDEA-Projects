package arcade.classes

/**
 * Represents different kinds of prizes which can be purchased at terminals.
 *
 * @property name The name of the prize (e.g. Candy).
 * @property cost How many tickets the prize will cost at a terminal.
 * @property amount The total stock of the prize remaining.
 */
class PrizeCategory(val name: String, val cost: Int, var amount: Int)