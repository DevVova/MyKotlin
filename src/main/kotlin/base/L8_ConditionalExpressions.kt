package base

fun main() {
    val a = 2
    val b = 8
    println(a > b)//То что в скобках является выражением, так как результатом является какое-то значение.
    println(a == b)// a и b являются операндами, то есть тем над кем проводится операция какая-то.
    println(a <= b)// <= это оператор, то есть знак которым обозначают операцию, а операция- это инструкция к выполнению определённого действия.

    var c = (a < 8) and (b == 3)//С помощью операторов and, or, xor мы можем создавать более сложные условные выражения, составные.
    println(c)
    c = (a != 4) || (((b == 0) && (a == b)) xor (a > 9))//&&, ||, != это также операторы сравнения.
    if (!c) print("c is false") else print("c is true")
    println()
    println(b in 2..7)//результатом будет true, если b лежит в диапазоне чисел от 2 до 7 включительно.
    if (!c) println("c is false") else println("c is true")
    c = a !in 9..12//Если значение переменной не лежит в диапазоне, то вернётся true, иначе false.
    println(c)
}