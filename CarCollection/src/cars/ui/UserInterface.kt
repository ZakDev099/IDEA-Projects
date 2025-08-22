package cars.ui

import cars.data.Car
import cars.utils.ByteIO
import cars.utils.DisplayCars
import cars.utils.InputHandler

/**
 * The user interface for the program. Handles menu logic.
 *
 * @property carList Currently loaded list of cars to display.
 * @constructor Creates a user interface with a list of cars.
 */
class UserInterface(var carList: List<Car>) {
    /**
     * @property position Menu state tracker for the menu controller.
     */
    var position: Int = 0

    /**
     * Central program controller, tracks the root menu state.
     */
    fun menuController() {
        var programIsAlive = true

        while (programIsAlive) {
            when (position) {
                0 -> toMainMenu()
                1 -> toDisplayMenu()
                2 -> toSortMenu()

                3 -> if (InputHandler.confirmAction()) {
                    ByteIO.saveCars(carList)
                    position = 0
                } else {
                    position = 0
                }

                4 -> if (InputHandler.confirmAction()) {
                    carList = ByteIO.loadCars()
                    position = 0
                } else {
                    position = 0
                }

                5 -> if (InputHandler.confirmAction()) {
                    println("Goodbye!")
                    programIsAlive = false
                } else {
                    position = 0
                }

                else -> {
                    println("Invalid menu selection - returning to Main Menu."); position = 0
                }
            }
        }

        position = 0
    }

    /**
     * Displays the main menu, and updates the menu position from user input. Users can access sub-menus from here.
     */
    fun toMainMenu() {
        println(
            """
            |   CAR COLLECTION!
            |   
            |   1. Display
            |   2. Sort
            |   3. Save Cars
            |   4. Load Cars
            |   5. Exit
            
            Please selection an option:
        """.trimIndent()
        )

        position = InputHandler.retrieveInt(1..5)
    }

    /**
     * Takes user input and calls display methods to show the user all cars or only cars that fulfil a condition.
     */
    fun toDisplayMenu() {
        println(
            """
            |   DISPLAY ONLY
            |
            |   0. <<<
            |   1. All Cars
            |   2. New Cars
            |   3. Used Cars
            |   4. Search Make
            |   5. Search Model
            |   6. Search Year
            
            Please selection an option:
        """.trimIndent()
        )

        val userInput = InputHandler.retrieveInt(0..6)
        when (userInput) {
            0 -> position = 0
            1 -> DisplayCars.displayAll(carList)
            2 -> DisplayCars.displayCondition(carList, true)
            3 -> DisplayCars.displayCondition(carList, false)
            4 -> DisplayCars.displaySearched(carList, "make")
            5 -> DisplayCars.displaySearched(carList, "model")
            6 -> DisplayCars.displaySearched(carList, "year")
        }
    }

    /**
     * Takes user input and calls displays a sorted list of all cars by a given property.
     */
    fun toSortMenu() {
        println(
            """
            |   DISPLAY SORTED
            |
            |   0. <<<
            |   1. By Make
            |   2. By Model
            |   3. By Year
            |   4. By Condition 
            
            Please selection an option:
        """.trimIndent()
        )

        val userInput = InputHandler.retrieveInt(0..4)

        when (userInput) {
            0 -> position = 0
            1 -> DisplayCars.displaySorted(carList, "make")
            2 -> DisplayCars.displaySorted(carList, "model")
            3 -> DisplayCars.displaySorted(carList, "year")
            4 -> DisplayCars.displaySorted(carList, "condition")
        }
    }
}