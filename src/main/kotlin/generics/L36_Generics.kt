package generics

/**
 * Generics или обобщения представляют технику, посредством которой методы
 * и классы могут использовать объекты, типы которых на момент определения
 * классов и функций неизвестны. Обобщения позволяют определять шаблоны, в
 * которые можно подставлять различные типы.
 * Обобщенные типы (generic types) представляют типы, в которых типы
 * объектов параметризированны.
 * То есть обобщения - это языковая конструкция, позволяющая при описании
 * класса или функции не указывать конкретный тип параметров.
 */

fun main() {
    val vova: Man36<Int, String> = Man36(45, "Vova")
    println(vova.age)

    val gena = Man36(27, "Gena")//Можно не указывать тип, если он может быть выведен компилятором.
    println(gena.name)

    printAny(vova)//Здесь передали в качестве аргумента объект типа Man36.

    val array = arrayOf(23, 34, 2)
    val myArray = getBiggest(arrayOf(3, 3), array)
    myArray.forEach { print("$it  ") }

}

class Man36<K, V>(val age: K, val name: V)

fun <T> printAny(anyThing: T) {
    println(anyThing)
}

fun <T> getBiggest(arr1: Array<T>, arr2: Array<T>): Array<T> {
    return if (arr1.size > arr2.size) arr1
    else arr2
}