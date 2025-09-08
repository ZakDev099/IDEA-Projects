package customers

import customers.objects.Customer
import customers.ui.UI

fun main() {
    // Creating new list of customers
    val customerList = listOf(
        Customer("John Smith", "JohnSmith97@gmail.com", "0400589540"),
        Customer("Mark Smith", "MarkSmith99@gmail.com", "0400778597"),
        Customer("Elyse Stone", "Elyse.Stone7@outlook.com", "0407249245"),
        Customer("James Whitkaupf", "TheEmmersonBand21@gmail.com", "0409294061"),
        Customer("Dan Ghinslinger", "DanTheMan1989@hotmail.com.au", "0401457992")
    )

    UI.menuController(customerList) // Running UI with customerList

    // Creating another list of customers
    val customerList2 = listOf(
        Customer("Test Person", "Example@email.com", "0000000001"),
        Customer("Test Person2", "Example2@email.com", "0000000002"),
        Customer("Test Person3", "Example3@email.com", "0000000003"),
    )

    UI.menuController(customerList2) // Running UI again with new customers to test save/load functionality
}