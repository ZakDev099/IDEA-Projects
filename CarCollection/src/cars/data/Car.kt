package cars.data

import java.io.Serializable

/**
 * Represents a typical car.
 *
 * @property make The make of the car.
 * @property model The model of the car.
 * @property year The year the car was manufactured.
 * @property odometer The total km reading of the car's odometer.
 * @constructor creates a standard car.
 */
data class Car(val make: String, val model: String, val year: Int, val odometer: Int = 0) : Serializable {
    /**
     * @property condition Whether the car is new or used based on the odometer reading.
     */
    var condition = "New"

    init {
        condition = if (odometer > 0) "Used" else "New"
    }

    /**
     * Formats and displays the car's properties
     */
    fun display() {
        println(
            """
            $make $model, $year
            Condition: $condition
            Odometer:  $odometer
            """.trimIndent()
        )
        println()
    }
}