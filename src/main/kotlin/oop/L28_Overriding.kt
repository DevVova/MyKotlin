package oop

/**
 * Kotlin позволяет переопределять в производном классе функции и свойства,
 * которые определенны в базовом классе. Чтобы функции и свойства базового
 * класса можно было переопределить, к ним применяется аннотация open. При
 * переопределении в производном классе к этим функциям применяется аннотация
 * override.
 */

fun main() {
    val vova = Sun28("Vova", "trader")
    vova.printInfo()
    vova.country = "Kazakhstan"
    vova.printInfo()

    val tom = SunSun("Tom", "artist")
    tom.printInfo()
}

open class Parent28(open val name: String = "Sam") {
    open val age: Int
        get() = 33
    open var country: String = "Germany"
        set(value) {
            if (value != "usa") field = "another"
        }

    open fun printInfo() {
        println("His name is $name. He is $age years old.")
    }
}

open class Sun28(
    override val name: String,
    private val profession: String,
) : Parent28(name) {
    //Ниже примеры переопределения геттеров и сеттеров.
    override val age
        get() = 23
    override var country: String = "Ukraine"
        set(value) {
            if (value != "usa") field = "USA"
        }

    override fun printInfo() {
        println("His name is $name. He is $age years old. He's a $profession. He is from $country.")
    }
}

open class SunSun(name: String, profession: String) : Sun28(name, profession) {
    override val age = super.age + 5//Пример обращения к реализации из базового класса.

    //Когда мы хотим чтобы больше в других классах наследниках эта функция не переопределялась.
    final override fun printInfo() {
        super.printInfo()//Пример обращения к реализации из базового класса.
        println("Final function.")
    }
}