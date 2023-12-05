package oop

/**
 * Геттеры (getter) и сеттеры (setter) (еще их называют методами доступа)
 * позволяют управлять доступом к переменной.
 *
 * Инициализатор, геттер и сеттер свойства необязательны. Указывать тип
 * свойства также необязательно, если он может быть выведен их значения
 * инициализатора или из возвращаемого значения геттера.
 *
 * Геттеры и сеттеры необязательно определять именно для свойств внутри
 * класса, они могут также применяться к переменным верхнего уровня.
 */

val num27 = 2
    get() {
        println("Field = $field")
        return field
    }

fun main() {
    println(num27)

    val ex = Example27(45)
    ex.printAgeE()
    ex.age = 46
    ex.printAgeE()

    val ex1 = Person27("Vova", "Zabotin")
    println(ex1.fullName)

    val ex2 = Human27()
    ex2.age = 77
    ex2.printInputAge()
    ex2.age = -7
    ex2.printInputAge()
}

class Example27(inputAge: Int) {
    var age: Int = inputAge
        set(value) {
            field = if (value < 0) 0
            else value
        }
    fun printAgeE() {
        println("Age is $age.")
    }
}

class Person27(private val firstName: String, private val lastName: String) {
    val fullName: String
        get() = "$firstName $lastName"
}

//Ниже пример надстройки над полем ageIn используя геттер и сеттер другого свойства, открытого.
class Human27 {
    private var ageIn = 1
    var age: Int
        set(value) {
            if (value in 1..119) ageIn = value
        }
        get() = ageIn
    fun printInputAge() {
        println("Input age = $ageIn.")
    }
}