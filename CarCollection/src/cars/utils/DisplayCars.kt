package cars.utils

import cars.data.Car

/**
 * Responsible for displaying car details, including sort and search functionality.
 */
object DisplayCars {

    /**
     * Displays all cars in a list.
     *
     * @param cars A list containing Cars.
     */
    fun displayAll(cars: List<Car>) {
        var carsFound = 0
        for (car in cars) {
            car.display(); carsFound++
        }
        println("$carsFound cars were found.")
        InputHandler.retrieveEnter()
    }

    /**
     * Only displays cars from a list that are either new or used.
     *
     * @param cars A list containing Cars.
     * @param showNew If true, displays only new cars. If false, displays only used cars.
     */
    fun displayCondition(cars: List<Car>, showNew: Boolean) {
        var carsFound = 0
        for (car in cars) {
            when {
                (car.condition.equals("new", true) && showNew) -> {
                    car.display(); carsFound++
                }

                (car.condition.equals("used", true) && !showNew) -> {
                    car.display(); carsFound++
                }
            }
        }
        println("$carsFound ${if (showNew) "new" else "used"} cars were found.")
        InputHandler.retrieveEnter()
    }

    /**
     * Only displays cars where a user's input matches the value of a car's specified property
     * (i.e. provides basic search functionality for cars).
     *
     * @param cars A list containing Cars.
     * @param category A car's property to compare against.
     */
    fun displaySearched(cars: List<Car>, category: String) {
        val itemsFound: MutableList<String> = mutableListOf()
        // The maximum preview items of make or model that can be shown
        val maxPreview = 10
        var userInput: String
        var carsFound = 0

        when (category) {
            "make" -> {
                for (car in cars) if (itemsFound.size <= maxPreview) {
                    itemsFound.add(car.make)
                } else break
                // Displaying a preview of distinct makes contained in the list to help the user search.
                println("${category}s found: ")
                itemsFound.distinct().forEach { println("[$it]") }
                if (itemsFound.size > maxPreview) println("...")
                // Then prompting for search input...
                println("\nEnter value to search: ")
                userInput = readln()
                for (car in cars) {
                    if (userInput.contains(car.make, true)) {
                        car.display(); carsFound++
                    }
                }
            }

            "model" -> {
                for (car in cars) if (itemsFound.size <= maxPreview) {
                    itemsFound.add(car.model)
                } else break
                // Displaying a preview of distinct models contained in the list to help the user search.
                println("${category}s found: ")
                itemsFound.distinct().forEach { println("[$it]") }
                if (itemsFound.size > maxPreview) println("...")
                // Then prompting for search input...
                println("\nEnter value to search: ")
                userInput = readln()
                for (car in cars) {
                    if (userInput.contains(car.model, true)) {
                        car.display(); carsFound++
                    }
                }
            }

            "year" -> {
                // Skips preview and just prompts for search input
                println("\nEnter value to search: ")
                val intInput = InputHandler.retrieveInt()
                for (car in cars) {
                    if (intInput == car.year) {
                        car.display(); carsFound++
                    }
                }
                userInput = intInput.toString()
            }

            else -> {
                println("Error"); return
            }
        }
        println("$carsFound cars were found for '$userInput'")
        InputHandler.retrieveEnter()
    }

    /**
     * Displays a sorted (ascending) list of cars by a specified property.
     *
     * @param cars A list of Cars.
     * @param category A car's property to sort by.
     */
    fun displaySorted(cars: List<Car>, category: String) {
        when (category) {
            "make" -> displayAll(cars.sortedBy { it.make })
            "model" -> displayAll(cars.sortedBy { it.model })
            "year" -> displayAll(cars.sortedBy { it.year })
            "condition" -> displayAll(cars.sortedBy { it.odometer })
        }
    }
}