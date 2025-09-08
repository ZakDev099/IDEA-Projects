package customers.utils

import customers.objects.Customer

/** Provides functionality for sorting, searching and displaying lists of customers. */
object DisplayCustomers {

    /**
     * Generic display method that displays a list of customers.
     *
     * @param customers A list containing Customers.
     */
    fun display(customers: List<Customer>) {
        var customersFound = 0
        for (customer in customers) {
            customer.display(); customersFound++
        }
        println("$customersFound customers were found.\n")
    }

    /**
     * Displays all customers from a list of Customers.
     *
     * @param customers A list containing Customers.
     */
    fun displayAll(customers: List<Customer>) {
        display(customers)
        InputHandler.retrieveEnter()
    }

    /**
     * Only displays Customers when the user's input matches the value of the Customer's specified property
     * (i.e. provides basic search functionality for Customers).
     *
     * @param customers A list containing Customers.
     * @param category A Customer's property to compare against.
     */
    fun displaySearched(customers: List<Customer>, category: String) {
        println("\nEnter $category to search for: ")
        val searchedList = mutableListOf<Customer>()
        val userInput = readln()

        for (customer in customers) {
            /* Ensuring ID search only displays exact matching results
             * (e.g. searching '3' should not show '31, 32, etc.).
             */
            if (category == "id") {
                if (userInput.toInt() == customer.properties.getValue("id")) {
                    searchedList.add(customer)
                }
            } else {
                if (customer.properties.getValue(category).toString().contains(userInput, true)) {
                    searchedList.add(customer)
                }
            }

        }
        display(searchedList)
        InputHandler.retrieveEnter()
    }

    /**
     * Displays a sorted (ascending) list of customers by a specified property.
     *
     * @param customers A list of Customers.
     * @param category A Customer's property to sort by.
     */
    fun displaySorted(customers: List<Customer>, category: String) {
        val sortedList = customers.sortedBy { it.properties.getValue(category).toString() }

        display(sortedList)
        InputHandler.retrieveEnter()
    }
}