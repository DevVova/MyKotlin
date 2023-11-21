package base

/**
 * Циклы представляют вид управляющих конструкций, которые позволяют
 * в зависимости от определенных условий выполнять некоторое действие
 * множество раз.
 *
 * В Kotlin forEach - это функция высшего порядка, которая позволяет
 * проходиться по элементам коллекции и выполнять некоторое действие
 * для каждого элемента.
 */

fun main() {
    val range = Array(5) { 0 }
    var i = 0
    for (a in 1..5) {
        range[i] = a
        i++
    }
    range.forEachIndexed() { index, number ->
        if (index == i - 1) {
            println(number)
        } else print("$number\t")
    }

    val r = arrayOf(2, 5, 7)
    r.forEach {
        print("${it * 10}\t")
    }
    println()

    var k = 0
    while (k < 11) {
        print("$k  ")
        k++
    }
    println()

    //У этого цикла сначала исполняется код в блоке do, а потом только условие.
    do {
        println(k)
    } while (k > 11)

    range.forEach { if (it != 3) print("$it       ") }
    println()

    for (n in range) {
        if (n == 3) continue
        print("$n ")
    }
    println()

    for (n in range) {
        if (n == 3) break
        print("$n ")
    }
    println()

    //Пример вложенного цикла.
    for (a in 1..10) {
        for (b in 1..10) {
            print("${b * a}\t")
        }
        println()
    }
}