package customers.objects

import java.io.Serializable

/**
 * Represents a customer with a unique id.
 *
 * @property name The name of the customer.
 * @property email The customer's email address.
 * @property phone The customer's phone number.
 * @constructor creates a single customer.
 */
data class Customer(val name: String, val email: String, val phone: String) : Serializable {
    /** @property id The customer's unique ID. */
    val id = ++UID_Generator

    /** @property properties A map of the customer's properties */
    val properties: Map<String, Any> = mapOf(
        "id" to id,
        "name" to name,
        "email" to email,
        "phone" to phone
    )

    companion object {
        private var UID_Generator = 0
    }

    /** Formats and prints all properties of the Customer (excluding the properties map) */
    fun display() {
        println(
            """
            CUSTOMER ID: $id
            NAME: $name
            EMAIL: $email
            PHONE: $phone
            """.trimIndent()
        )
        println()
    }
}