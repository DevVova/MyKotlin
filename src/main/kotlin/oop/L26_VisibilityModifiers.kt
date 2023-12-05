package oop

/**
 * Все используемые типы, а также компоненты типов (классы, объекты, интерфейсы,
 * конструкторы, функции, свойства) имеют определенный уровень видимости,
 * определяемый модификатором видимости (модификатором доступа). Модификатор
 * видимости определяет, где те или иные типы и их компоненты доступны и где их
 * можно использовать. В Kotlin есть следующие модификаторы видимости:
 * private: классы, объекты, интерфейсы, а также функции и свойства, определенные
 * вне класса, с этим модификатором видны только в том файле, в котором они
 * определены. Члены класса с этим модификатором видны только в рамках своего
 * класса
 * protected: члены класса с этим модификатором видны в классе, в котором они
 * определены, и в классах-наследниках
 * internal: классы, объекты, интерфейсы, функции, свойства, конструкторы с этим
 * модификатором видны в любой части модуля, в котором они определены. Модуль
 * представляет набор файлов Kotlin, скомпилированных вместе в одну структурную
 * единицу. Это может быть модуль IntelliJ IDEA или проект Maven
 * public: классы, функции, свойства, объекты, интерфейсы с этим модификатором
 * видны в любой части программы. (При этом если функции или классы с этим
 * модификатором определены в другом пакете их все равно нужно импортировать).
 *
 * Для установки уровня видимости модификатор ставится перед ключевыми словами
 * var/val/fun в самом начале определения свойства или функции.
 *
 * Если модификатор видимости явным образом не указан, то применяется
 * модификатор public.
 */

fun main() {
    val aa = CC.setA(22)
    aa.printA()

    val f1 = Cub("red", "cub", 277)
    f1.printName()
    println(f1.color)
    f1.addFun()

    val marker = Copic("orange", 3060)
    marker.printMarkerInfo()
}

//Ниже пример класса с приватным конструктором, который используют чтобы нельзя было создать экземпляр класса извне.
class CC private constructor(val a: Int) {
    companion object{
        fun setA(a: Int): CC {
            return CC(a)
        }
    }
    fun printA() {
        println(a)
    }
}

//Ниже примеры классов с применением различных модификаторов.
open class Figure(val color: String, private val name: String) {
    private fun setName(name: String): String {
        return name
    }
    fun printName() {
        println(setName(name))
    }
    protected fun whatIs(): String {
        return "This is a $name. Its color is $color."
    }
}

class Cub(colorCub: String, nameCub: String, private val price: Int) : Figure(colorCub, nameCub) {
    fun addFun() {
        println("${whatIs()} Price is $price.")
    }
}

//Вот один из способов использования приватного конструктора.
open class Marker private constructor(private val color: String) {
    private var price: Int = 2
    protected constructor(colorNew: String, priceNew: Int) : this(colorNew){
        price = priceNew
    }
    open fun printMarkerInfo() {
        println("This is a $color marker. Its price is $price.")
    }
}

class Copic(colorC: String, priceC: Int) : Marker(colorC, priceC) {
    override fun printMarkerInfo() {
        println("It is \"Copic\".")
        super.printMarkerInfo()
    }
}