package functions

/**
 *  Функция может принимать переменное количество параметров одного типа.
 *  Для определения таких параметров применяется ключевое слово vararg.
 */

fun main() {
    var result = sum(34, 2, 56, 4, str = "Hello!")//Если кроме vararg параметров есть ещё параметры и они идут после, то их следует указывать с использованием именованного аргумента.
    println(result)
    val arr = intArrayOf(23, 44, 12, 2)
    result = sum(*arr, str = "Goodbye!")//Вот так мы можем передавать в качестве аргументов все элементы массива. Оператор * (spread operator).
    println(result)
}

fun sum(vararg num: Int, str: String): Int {
    var i = 0
    for (n in num) {
        i += n
    }
    println(str)
    return i
}