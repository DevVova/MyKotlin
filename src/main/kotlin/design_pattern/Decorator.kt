package design_pattern

/**
 * Как я понял, основное отличие делегирования от декорации в том, что
 * не нужно переопределять функции интерфейсов.
 */

fun main() {
    val car1: Car = Audi()
    val car2: Car = BMV()
    val eng1: Engine = AudiEngine()
    var car = CarDecorator(car1, eng1)//Лучше думаю не указывать тип. И снизу также.
    var carDelegation = CarDelegation(car2, eng1)

    carDelegation.voice()
    carDelegation.start()
    carDelegation = CarDelegation(car1, eng1)
    carDelegation.voice()
    carDelegation.start()
    println()


    car.start()
    car = CarDecorator(car2, eng1)
    car.start()
    car.voice()
}

interface Car {
    fun start()
}

interface Engine {
    fun voice()
}

class AudiEngine : Engine {
    override fun voice() {
        println("Voice engine.")
    }
}

class Audi : Car {
    override fun start() {
        println("Audi is starting.")
    }
}

class BMV : Car {
    override fun start() {
        println("BMV is starting.")
    }
}

class CarDecorator(private val car: Car, private val eng: Engine) : Engine, Car {
    override fun start() {
        car.start()
    }

    override fun voice() {
        eng.voice()
    }
}

//Снизу пример того же что и сверху по сути, но через делегирование.
class CarDelegation(private val car: Car, private val eng: Engine) : Car by car, Engine by eng
