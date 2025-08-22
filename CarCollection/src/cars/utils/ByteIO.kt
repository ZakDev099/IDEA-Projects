package cars.utils

import cars.data.Car
import java.io.*

/**
 * Responsible for saving and loading cars to/from binary files.
 */
object ByteIO {

    /**
     * Saves list of cars to a binary file named "cars.dat" (overwrites).
     *
     * @param cars A list of Cars.
     */
    fun saveCars(cars: List<Car>) {
        try {
            println("Saving cars to cars.dat...")
            FileOutputStream("cars.dat").use { fileOut ->
                ObjectOutputStream(fileOut).use { objectOut ->
                    objectOut.writeObject(cars)
                }
            }
            println("\ncars.dat saved successfully!")
        } catch (e: IOException) {
            println(e)
        } catch (e: Exception) {
            println(e)
        }
    }

    /**
     * Loads list of cars from a binary file named "cars.dat".
     *
     * @return A list of Cars.
     */
    fun loadCars(): List<Car> {
        println("Loading cars from file...")
        var carList: List<Car> = listOf()

        try {
            FileInputStream("cars.dat").use { fileIn ->
                ObjectInputStream(fileIn).use { objectIn ->
                    @Suppress("UNCHECKED_CAST") // carList will always be List<Car>
                    carList = objectIn.readObject() as List<Car>
                }
            }
            println("\nUpdated cars!")
        } catch (e: IOException) {
            println(e)
        } catch (e: ClassNotFoundException) {
            println(e)
        } catch (e: Exception) {
            println(e)
        }

        return carList
    }
}