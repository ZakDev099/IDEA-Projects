package customers.ui

import customers.objects.Customer
import customers.utils.*

/** The user interface for the program. Handles menu logic. */
object UI {
    /** @property position Tracks the current menu state. */
    var position = 0

    /** @property customers The currently loaded list of customers*/
    var customers: List<Customer> = listOf()

    /** Central program controller, tracks the root menu state and updates customers with [customerList]*/
    fun menuController(customerList: List<Customer>) {
        customers = customerList
        var programIsAlive = true

        while (programIsAlive) {
            when (position) {
                0 -> toMainMenu()
                1 -> {
                    DisplayCustomers.displayAll(customers)
                    position = 0
                }

                2 -> toSearchMenu()
                3 -> toSortMenu()

                4 -> if (InputHandler.confirmAction()) {
                    ByteIO.saveFile(customers)
                    position = 0
                } else {
                    position = 0
                }

                5 -> if (InputHandler.confirmAction()) {
                    customers = ByteIO.loadFile(customers)
                    position = 0
                } else {
                    position = 0
                }

                6 -> if (InputHandler.confirmAction()) {
                    println("Goodbye!")
                    programIsAlive = false
                    position = 0
                } else {
                    position = 0
                }

                else -> {
                    println("ERROR: Invalid menu state -> returning to Main Menu."); position = 0
                }
            }
        }
    }

    /** Displays the main menu, and updates the menu position from user input. Users can access sub-menus from here. */
    fun toMainMenu() {
        println(
            """
            |   CUSTOMERS!
            |   
            |   1. Show All
            |   2. Search
            |   3. Sort By
            |   4. Save Customers
            |   5. Load Customers
            |   6. Exit
            
            Please selection an option:
        """.trimIndent()
        )

        position = InputHandler.retrieveInt(1..6)
    }

    /** Takes user input and calls methods from DisplayCustomers to search by a Customer property. */
    fun toSearchMenu() {
        println(
            """
            |   SEARCH CUSTOMERS
            |
            |   0. <<<
            |   1. Search ID
            |   2. Search Name
            |   3. Search Email
            |   4. Search Phone
            
            Please selection an option:
        """.trimIndent()
        )

        when (InputHandler.retrieveInt(0..4)) {
            0 -> position = 0
            1 -> DisplayCustomers.displaySearched(customers, "id")
            2 -> DisplayCustomers.displaySearched(customers, "name")
            3 -> DisplayCustomers.displaySearched(customers, "email")
            4 -> DisplayCustomers.displaySearched(customers, "phone")
        }
    }

    /**
     * Takes user input and calls methods from DisplayCustomers to display a sorted list of customers
     * by a Customer property.
     */
    fun toSortMenu() {
        println(
            """
            |   SORT CUSTOMERS
            |
            |   0. <<<
            |   1. By ID
            |   2. By Name
            |   3. By Email
            |   4. By Phone 
            
            Please selection an option:
        """.trimIndent()
        )

        when (InputHandler.retrieveInt(0..4)) {
            0 -> position = 0
            1 -> DisplayCustomers.displaySorted(customers, "id")
            2 -> DisplayCustomers.displaySorted(customers, "name")
            3 -> DisplayCustomers.displaySorted(customers, "email")
            4 -> DisplayCustomers.displaySorted(customers, "phone")
        }
    }
}