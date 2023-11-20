package base

/**
 *Условные конструкции позволяют направить выполнение программы по одному
 *из путей в зависимости от условия.
 */
fun main() {
    val a = 20
    val b = 8
    var c = true

    //Конструкция if принимает условие, и если это условие истинно, то выполняется последующий блок инструкций.
    if (a in 1..40) println("a in range from 1 to 40.")

    //Если в зависимости от результата, необходимо выполнить не одну инструкцию, то  их обрамляют  в блок.
    if (b != 3) {
        println("b not 3")
        println("b is $b")
    }

    //Если необходимо задать альтернативный вариант, то можно добавить блок else:
    if (c) println("c is true") else println("c is false")

    //Если необходимо проверить несколько альтернативных вариантов, то можно добавить выражения else if:
    if (a == 1) println("a = 1")
    else if (a == 7) println("a = 7")
    else if (a == 3) println("a = 3")
    else println("a не равно ни 1, ни 7, ни 3.")

    //Стоит отметить, что конструкция if может возвращать значение.
    val d = if(a > b) a else b//Вот пример когда мы ищем наибольшее число из двух.
    println(d)

    //Когда у нас от 3 и более вариантов дальнейшего пути выполнения программы, то вместо конструкции if ... else лучше использовать when.
    when(a) {
        1 -> println("a = 1")
        3 -> println("a = 3")
        5 -> println("a = 5")
        else -> println("a = $a")
    }

    val e = when {
        b > 9 -> b
        else -> 9//Когда when используется как выражение, то ele обязательно должно присутствовать.
    }
    println(e)

    //Сравнение с набором значений.
    when (b) {
        1, 3, 4 -> println("b = 1 or 3 or 4")
        in 2..6 -> println("b in range from 2 to 6")
        else -> println("I'm don't know!")
    }

    //when и динамически вычисляемые значения.
    val j = 28
    when (b) {
        j - a -> println("b = j - a")
        j + a -> println("b = j + a")
        else -> println("no result.")
    }
    when (j - b) {
        12, 22, 13 -> println("j - b = 12, or 22, or 13")
        in 7..23 -> println("j - b result in range from 7 to 23")
        else -> println("no")
    }
    when (val g = j - 1) {
        12, 22, 13 -> println("j - b = 12, or 22, or 13")
        in 7..23 -> println("j - b result in range from 7 to 23")
        else -> println("g = $g")
    }
}