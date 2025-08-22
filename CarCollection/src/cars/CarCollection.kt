package cars

import cars.data.Car
import cars.ui.UserInterface

fun main() {
    // Initializing Car objects into a list
    val carList = listOf(
        Car("Toyota", "Corolla", 2024, 0),
        Car("Ford", "Focus", 2023, 0),
        Car("Mazda", "CX-5", 2024, 0),
        Car("Hyundai", "i30", 2023, 0),
        Car("Honda", "Civic", 2022, 45200),
        Car("Nissan", "X-Trail", 2021, 78650),
        Car("Volkswagen", "Golf", 2023, 12800),
        Car("Ford", "Focus", 2023, 36500),
        Car("Subaru", "Outback", 2020, 90210),
        Car("BMW", "3 Series", 2021, 54300)
    )

    // Creating a test list to test saving and loading files
    val testList = listOf(
        Car("Test", "Vehicle", 2000, 0),
        Car("Test", "Vehicle", 2000, 50000),
        Car("Test", "Vehicle", 2000, 100000),
    )

    // Create UI and run program loop
    val userInterface = UserInterface(carList)
    userInterface.menuController()
    // Restart UI with a new car list
    userInterface.carList = testList
    userInterface.menuController()
}