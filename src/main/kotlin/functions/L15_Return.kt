package functions

/**
 * Функция может возвращать некоторый результат. В этом случае после
 * списка параметров через двоеточие указывается возвращаемый тип.
 * А в теле функции применяется оператор return, после которого указывается
 * возвращаемое значение.
 *
 * Если функция не возвращает какого-либо результата, то фактически неявно
 * она возвращает значение типа Unit. Если функция возвращает значение Unit,
 * мы также можем использовать оператор return для возврата из функции.
 * При этом если функция возвращает значение Unit, то после оператора return
 * можно не указывать никакого значения.
 */

fun main() {
    simpleFun(77)
    println(sum22(34747, 38383))
}

fun simpleFun(a: Int) {
    if (a > 100){
        println("a больше 100")
        return
    }
    println("a меньше 100")
}

fun sum22(a: Int, b: Int): Int {
    return a + b
}