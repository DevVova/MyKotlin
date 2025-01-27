package function

/**
 * В этом примере я рассмотрел популярную конструкцию типа
 * fun main() = someFunction(). То есть можно было так написать,
 * а можно так -
 *
 * fun main() {
 *
 * someFunction()
 *
 * }
 *
 * и разницы бы никакой не было.
 */
fun main() {
    function1 {
        someFunction()
    }
}

/*
fun main() = function1 {
    someFunction()
}. Аналогичная запись.
*/

fun function1(inputFun: () -> Unit) {
    inputFun()
}

fun someFunction() {
    println("Hi, my friend!")
}