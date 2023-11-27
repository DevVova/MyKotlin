package functions

/**
 * Функции высокого порядка (high order function) - это функции,
 * которые либо принимают функцию в качестве параметра, либо возвращают
 * функцию, либо и то, и другое.
 */

fun main() {
    //Пример использования лямбды.
    includeFun {
        includeFun {
            printName()
        }
    }
    //Стандартный вызов функции высшего порядка.
    includeFun(::printAge)

    val res = ::action
    var r = res(23, 45) {a: Int, b: Int ->
        multiply19(a, b)
    }
    println(r)
    r = res(12, 2, ::subtract19)
    println(r)
    val simpleF = ::sum19
    r = res(2, 3, simpleF)
    println(r)

    //Возвращение функции из функции.
    val r1 = resOp(7)
    println(r1(34, 44))
}

fun includeFun(otherFun: () -> Unit) {
    otherFun()
}

fun printName() {
    println("Vova")
}

fun printAge() {
    println("45")
}

fun action(a: Int, b: Int, mathOp: (Int, Int) -> Int): Int {
    return mathOp(a, b)
}

fun sum19(a: Int, b: Int): Int {
    return a + b
}

fun subtract19(a: Int, b: Int): Int {
    return a -b
}

fun multiply19(a: Int, b: Int): Int {
    return a * b
}

fun resOp(key: Int): (Int, Int) -> Int {
    return when(key) {
        0 -> ::sum19
        1 -> ::subtract19
        else -> ::multiply19
    }
}