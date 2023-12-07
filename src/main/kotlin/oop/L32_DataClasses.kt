package oop

/**
 * Иногда классы бывают необходимы только для хранения некоторых данных.
 * В Kotlin такие классы называются data-классы. Они определяются с модификатором
 * data. При компиляции такого класса компилятор автоматически добавляет в класс
 * функции с определенной реализацией, которая учитывает свойства класса,
 * которые определены в первичном конструкторе:
 *
 * equals(): сравнивает два объекта на равенство
 *
 * hashCode(): возвращает хеш-код объекта
 *
 * toString(): возвращает строковое представление объекта
 *
 * copy(): копирует данные объекта в другой объект
 *
 * Таким образом, в случае с data-классами мы имеем готовую реализацию
 * для этих функций. Их не надо вручную переопределять. Но вполне возможно
 * нас может не устраивать эта реализация, тогда мы можем определить свою.
 *
 * При этом чтобы класс определить как data-класс, он должен соответствовать
 * ряду условий:
 * Первичный конструктор должен иметь как минимум один параметр
 * Все параметры первичного конструктора должны предваряться ключевыми словами
 * val или var, то есть определять свойства,
 * которые определяются вне первичного конструктора, не используются
 * в функциях toString, equals и hashCode
 * Класс не должен определяться с модификаторами open, abstract, sealed или inner.
 *
 * Также стоит отметить, что несмотря на то, что мы можем определять свойства в
 * первичном конструкторе и через val, и через var, но вообще в ряде ситуаций
 * рекомендуется определять свойства через val, то есть делать их неизменяемыми,
 * поскольку на их основании вычисляет хеш-код, который используется в качестве
 * ключа объекта в такой коллекции как HashMap.
 */

fun main() {
    val gena = Person32(27, "Gena")
    gena.info()
    println(gena.toString())
    println()

    val petya = Person32Data(33, "Petya")
    println(petya.toString())
    println()

    val vasya = Person32Data2(53, "Vasya")
    println(vasya.toString())
    println(petya.toString())
    println()

    val tolya = petya.copy(name = "Tolya")//Изменили при копировании имя.
    println(tolya.toString())

    val sam = petya.copy()

    println(tolya.equals(gena))//Сравниваем два объекта на равенство.
    println(sam == petya)//На это - "println(sam.equals(petya))" среда ругается, говорит что можно заменить.

    //Декомпозиция data-классов.
    val(outAge, outName) = sam
    println(outAge)
    println(outName)
}

class Person32(private val age: Int = 37, private val name: String = "Ted") {
    fun info() {
        println("He is $name. He's $age years old.")
    }
}

data class Person32Data(val age: Int, val name: String)

//Мы можем переопределить свою реализацию для функций.
data class Person32Data2(val age: Int, val name: String) {
    override fun toString(): String {
        return "He is $name. He's $age years old."
    }
}