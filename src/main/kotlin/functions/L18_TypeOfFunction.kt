package functions

/**
 * В Kotlin все является объектом, в том числе и функции.
 * И функции, как и другие объекты, имеют определенный тип.
 */

fun main() {
    var f: (Int, Int) -> Int = ::sum18
    println(f(23, 33))
    f = ::subtract18
    println(f(23, 45))
}

fun sum18(a: Int, b: Int): Int {
    return a + b
}

fun subtract18(a: Int, b: Int): Int {
    return a - b
}