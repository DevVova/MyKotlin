package functions

//Анонимные функции выглядят как обычные за тем исключением, что они не имеют имени.

fun main() {
    //Анонимная функция может иметь одно выражение:
    val function1 = fun(a: Int, b: Int) = a / b
    println(function1(23, 7))

    //Либо может представлять блок кода:
    val function2 = fun(a: Int, koef: Int) {
        println(a * koef)
    }//Пробовал присвоить koef значение по умолчанию, но нельзя.
    function2(23, 44)

    //Анонимная функция как аргумент функции.
    op20(44, 33, function2)
    op20(3, 12, fun(a: Int, b: Int) {
        println(a + b)
    })

    //Возвращение анонимной функции из функции.
    val s = select(2)
    println(s(23, 2))

    val g = select(7)
    println(g(344, 3))

    val fff = select(3)
    println(fff(12, 12))
}

fun op20(a: Int, b: Int, f: (Int, Int) -> Unit) {
    f(a, b)
}

fun sum20(a: Int, b: Int): Int {
    return a + b
}

fun subtract20(a: Int, b: Int): Int {
    return a - b
}

fun select(key: Int): (Int, Int) -> Int {
    return when (key) {
        1 -> ::sum20
        2 -> ::subtract20
        3 -> fun(a: Int, b: Int) = a * b
        else -> fun(_, _) = 0//В этом случае вместо неиспользуемых параметров можно указать прочерки, так как оно не использует параметры, эти параметры не нужны.
    }
}