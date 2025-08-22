package arcade.classes

/**
 * Represents a terminal at the arcade.
 *
 * @param prize1 First prize in terminal.
 * @param prize2 Second prize in terminal.
 * @param prize3 Third prize in terminal.
 * @constructor Creates a terminal containing 3 prize categories.
 */
class Terminal(prize1: PrizeCategory, prize2: PrizeCategory, prize3: PrizeCategory) {
    /** Stores all 3 prizes in a mutable list.*/
    private val prizePool = mutableListOf(prize1,prize2,prize3)

    /**
     * Converts money into credits and adds them onto a card at a 1:2 ratio.
     *
     * @param playerCard Card object to add credits to.
     * @param money Amount of money to convert into credits.
     */
    fun addCredits(playerCard: Card, money: Int) {
        if (money >= 1) {
            val credits: Int = money * 2
            playerCard.creditBalance += credits
            println("\n$credits credits added to card " + playerCard.cardID)
        } else {
            println("\nCould not add credits")
            println("Reason: Invalid input, minimum value of 1 must be entered")
        }
        checkBalance(playerCard)
    }

    /**
     * Displays the ID number of card and the remaining ticket and credit balance.
     *
     * @param playerCard The card to show the balance of.
     */
    fun checkBalance(playerCard: Card) {
        println("\nCard ID: "+playerCard.cardID)
        println("Credits remaining: "+playerCard.creditBalance)
        println("Tickets remaining: "+playerCard.ticketBalance)
    }

    /**
     * Transfers credits between two cards, the third parameter can be used to specify a
     *     custom amount or left unspecified to transfer all credits.
     *
     * @param senderCard The card to transfer credits FROM.
     * @param receiverCard The card to transfer credits TO.
     * @param transferAmount Amount of credits to be transferred (leave empty to transfer all).
     */
    fun transferCredits(senderCard: Card, receiverCard: Card, transferAmount: Int? = null) {
        val senderID: Int = senderCard.cardID
        val receiverID: Int = receiverCard.cardID

        if (transferAmount == null) {
            println("\nTransferring ALL credits from card $senderID to card $receiverID...")
            receiverCard.creditBalance += senderCard.creditBalance
            senderCard.creditBalance = 0
        } else if (senderCard.creditBalance >= transferAmount) {
            println("\nTransferred $transferAmount credits")
            println("FROM card: $senderID")
            println("TO card: $receiverID")
            receiverCard.creditBalance += transferAmount
            senderCard.creditBalance -= transferAmount
        } else {
            println("\nInsufficient credits to process this transaction. Please try again...")
        }
        checkBalance(senderCard)
        checkBalance(receiverCard)
    }

    /**
     * Transfers tickets between two cards, the third parameter can be used to specify a
     *     custom amount or left unspecified to transfer all tickets.
     *
     * @param senderCard The card to transfer tickets FROM.
     * @param receiverCard The card to transfer tickets TO.
     * @param transferAmount Amount of tickets to be transferred (leave null to transfer all).
     */
    fun transferTickets(senderCard: Card, receiverCard: Card, transferAmount: Int? = null) {
        val senderID: Int = senderCard.cardID
        val receiverID: Int = receiverCard.cardID

        if (transferAmount == null) {
            println("\nTransferring ALL tickets from card $senderID to card $receiverID...")
            receiverCard.ticketBalance += senderCard.ticketBalance
            senderCard.ticketBalance = 0
        } else if (senderCard.ticketBalance >= transferAmount) {
            println("\nTransferred $transferAmount tickets")
            println("FROM card: $senderID")
            println("TO card: $receiverID")
            receiverCard.ticketBalance += transferAmount
            senderCard.ticketBalance -= transferAmount
        } else {
            println("\nInsufficient tickets to process this transaction")
        }
        checkBalance(senderCard)
        checkBalance(receiverCard)
    }

    /**
     * Matches 'item' parameter to the corresponding prize in the terminal's prize pool.
     *    The 'item' parameter does not need to be case specific.
     *    Processes the transaction if the playerCard contains enough tickets AND there is enough
     *    of the item remaining in the terminal's prize pool.
     *
     * @param item The name of the item to be requested.
     * @param playerCard The card which will be used to purchase the prize with tickets.
     */
    fun requestPrize(item: String, playerCard: Card) {
        if (prizePool.any{it.name.equals(item, true)} ) {
            val prize = prizePool.first{it.name.equals(item, true)}

            if (playerCard.ticketBalance < prize.cost) {
                println("\nCould not purchase "+prize.name)
                println("Reason: Insufficient tickets...")
            } else if (prize.amount <= 0) {
                println("\nCould not purchase "+prize.name)
                println("Reason: No stock available...")
            } else {
                playerCard.ticketBalance -= prize.cost
                prize.amount --
                println("\n"+prize.name+" purchased\nEnjoy your prize!")
                println("There are "+prize.amount+" "+prize.name+"(s) remaining")
            }
        } else {
            println("\n'$item' does not exist in this terminal")
        }
        checkBalance(playerCard)
    }
}