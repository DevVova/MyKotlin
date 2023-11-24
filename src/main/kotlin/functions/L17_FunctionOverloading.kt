package functions

/**
 * Перегрузка функций (function overloading) представляет определение
 * нескольких функций с одним и тем же именем, но с различными параметрами.
 * Параметры перегруженных функций могут отличаться по количеству, типу
 * или по порядку в списке параметров.
 */

fun main() {
    println(sum(2.3, 3))
    println(sum(3, 22.9))
    println(sum(1, 3, 2))
    println(sum(1.1, 3.2))
    println(sum(2, 4))
}

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun sum(a: Double, b: Int): Double {
    return a + b.toDouble()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun sum(b: Int, a: Double): Double {
    return b.toDouble() + a
}