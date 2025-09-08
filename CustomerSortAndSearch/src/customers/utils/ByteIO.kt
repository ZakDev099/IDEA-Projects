package customers.utils

import customers.objects.Customer
import java.io.*

/** Responsible for saving and loading Customers to/from binary files. */
object ByteIO {

    /** Saves list of [customers] to a binary file named "customers.dat" (overwrites). */
    fun saveFile(customers: List<Customer>) {
        try {
            println("Saving customers to customer.dat...")
            FileOutputStream("customers.dat").use { fileOut ->
                ObjectOutputStream(fileOut).use { objectOut ->
                    objectOut.writeObject(customers)
                }
            }
            println("\ncustomers.dat saved successfully!\n")
        } catch (e: IOException) {
            println(e)
        } catch (e: Exception) {
            println(e)
        }
    }

    /**
     * Loads and returns a list of Customers from a binary file named "customers.dat".
     *
     * @param customers A list of Customers to return in-case load fails
     */
    fun loadFile(customers: List<Customer>): List<Customer> {
        println("Loading cars from file...")
        var customers = customers
        var newCustomers: List<Customer> = listOf()

        try {
            FileInputStream("customers.dat").use { fileIn ->
                ObjectInputStream(fileIn).use { objectIn ->
                    @Suppress("UNCHECKED_CAST") // customers will always be List<Customer>
                    newCustomers = objectIn.readObject() as List<Customer>
                }
            }
            println("Showing preview...\n")
            DisplayCustomers.display(newCustomers)
            if (InputHandler.confirmAction("Are you sure you to overwrite existing customers?")) {
                customers = newCustomers
            }
        } catch (e: IOException) {
            println(e)
        } catch (e: ClassNotFoundException) {
            println(e)
        } catch (e: Exception) {
            println(e)
        }

        return customers
    }
}