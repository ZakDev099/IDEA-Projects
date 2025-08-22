package arcade

import arcade.classes.*


fun main() {
    // DEMO:: Initializing objects
    val card1 = Card() // A card created with a unique id (1)
    val card2 = Card() // Another card created with a unique id (2)
    val game1 = Game(5) // A playable game which costs 5 credits per play
    val game2 = Game(7) // Another playable game which costs 7 credits per play

    val prizeCandy = PrizeCategory("Candy", 60, 200) // Creating a prize called "Candy"
    val prizeHat = PrizeCategory("Hat", 500, 1) // Creating a prize called "Hat"
    val prizeBalloon = PrizeCategory("Balloon", 30, 120) // Creating a prize called "Balloon"
    val terminal1 = Terminal(prizeCandy, prizeHat, prizeBalloon) // Terminal with Prizes

    val prizeGlasses = PrizeCategory("Glasses", 300, 30) // Creating a prize called "Glasses"
    val prizeDice = PrizeCategory("Dice", 200, 85) // Creating a prize called "Dice"
    val prizeOminousOrb = PrizeCategory("Ominous orb", 9999, 1) // Creating a prize called "Ominous Orb"
    val terminal2 = Terminal(prizeGlasses, prizeDice, prizeOminousOrb) // Terminal 2 with Prizes

    // DEMO:: Add initial credits to cards and play some games
    terminal1.addCredits(card1, 20) // add 40 credits with $20 into card1
    terminal1.addCredits(card1, 0) // attempt to add 0 credits with $0 onto card1 (Should Fail)
    terminal1.addCredits(card2, 20) // add 40 credits with $20 into card2
    println("\n\n>>> Card #1 is used to play Game #1 5 times...")
    repeat(5) {
        game1.play(card1) // play game1 5 times with card1
    }
    println("\n\n>>> Card #2 is used to play Game #2 5 times...")
    repeat(5) {
        game2.play(card2) // play game1 5 times with card2
    }

    // DEMO:: Transferring credits and tickets
    println("\n\n>>> Some Credits & Tickets will be transferred from Card #2 to Card #1...")
    terminal1.transferCredits(card2, card1, 5) // transfer some credits from card2 to card1
    terminal1.transferTickets(card2, card1, 100) // transfer some tickets from card2 to card1
    println("\n\n>>> All Credits & Tickets will be transferred from Card #1 to Card #2...")
    terminal1.transferCredits(card1, card2) // transfer ALL remaining credits from card1 to card2
    terminal1.transferTickets(card1, card2) // transfer ALL remaining tickets from card1 to card2

    // DEMO:: Attempt to play a game with no credits on card
    println("\n\n>>> Card #1 is used to play Game #1 one more time...")
    game1.play(card1) // Expected Result: Insufficient credits

    // Request some prizes (Candy, Hat or Classes) with card 1 or card 2
    println("\n\n>>> Request different prizes with Card #1 and Card #2...")
    terminal1.requestPrize("Candy", card1) //Expected Result: Insufficient credits
    terminal1.requestPrize("Hat", card2) //Expected Result: *Success*
    terminal1.requestPrize("Hat", card2) //Expected Result: No stock remaining
    terminal1.requestPrize("candy", card2) //Expected Result: *Success*
    terminal1.requestPrize("Glasses", card2) //Expected Result: Item does not exist in this terminal
    terminal1.requestPrize("Candy", card2) //Expected Result: *Success*
    terminal2.requestPrize("glasses", card2) //Expected Result: *Success*
}