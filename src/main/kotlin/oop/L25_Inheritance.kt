package oop

/**
 * Наследование позволяет создавать классы, которые расширяют функциональность
 * или изменяют поведение уже существующих классов. В отношении наследования
 * выделяются два ключевых компонента. Прежде всего это базовый класс
 * (класс-родитель, родительский класс, суперкласс), который определяет
 * базовую функциональность. И производный класс (класс-наследник, подкласс),
 * который наследует функциональность базового класса и может расширять или
 * модифицировать ее.
 *
 * Чтобы функциональность класса можно было унаследовать, необходимо определить
 * для этого класса аннотацию open. По умолчанию без этой аннотации класс
 * не может быть унаследован.
 */

fun main() {
    val petya = Sun1("Petya", 21)
    petya.printNewInfo()
    petya.printInfo()
    println()

    val fedya = Sun2("Fedya", 17)
    fedya.printInfo()
    println(fedya.name)
    println()

    val vova = Sun3("Trader", "Vova", 45)
    vova.printInfo()
}

open class Mother(private val age: Int = 45) {
    open fun printInfo() {
        println("This is a human. He's $age years old.")
    }
}

//Наследоваться можно только от одного класса. Ниже я его также расширил дополнительной функцией.
class Sun1(private val name2: String, private val age2: Int = 20) : Mother(age2) {
    fun printNewInfo() {
        println("This is a human. He's $age2 years old. His name is $name2. ")
    }
}

//Ниже пример как можно ещё создать класс, но лучше так не делать, а делать как выше.
class Sun2 : Mother {
    var name = "X"
    //В конструкторе нельзя указывать val для параметров, так как среда говорит что это вторичный конструктор, а в нём не указывают.
    constructor(inName: String, age: Int): super(age) {
        this.name = inName
    }
}

class Sun3(private val name: String, private val age: Int): Mother(age) {
    var profession = ""
    constructor(profession: String, name: String, age: Int) : this(name, age) {
        this.profession = profession
    }

    override fun printInfo() {
        super.printInfo()
        println("Добавочная функция. Профессия человека $profession.")
    }
}