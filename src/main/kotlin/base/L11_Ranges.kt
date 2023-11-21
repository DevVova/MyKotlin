package base

/**
 * Диапазон представляет набор значений или некоторый интервал. Для создания
 * диапазона применяется оператор ".."  :
 */

fun main() {
    //Создали диапазон по нарастающей.
    val range1 = 1..9
    range1.forEach {print("$it ")}
    println()

    //Создали диапазон по убывающей.
    val range = 9 downTo 1
    range.forEach { print("$it ") }
    println()

    //Пример создания диапазона символов.
    val range2 = 'a'..'k'
    range2.forEach {print("$it ")}
    println()

    val t = 'x' in range2
    println(t)

    //Еще одна специальная функция step позволяет задать шаг, на который будут изменяться последующие элементы:
    val range3 = 1..7 step 2
    for (n in range3) {
        print("$n ")
    }
    println()

    //Еще одна функция until позволяет не включать верхнюю границу в диапазон:
    val range4 = 1..<7// Её уже изменили, видно устарела, теперь пишем "..<"
    range4.forEach { print("$it ")}
}
