package operators

/**
 * В этом примере я хотел показать как можно создать функцию расширение для базового
 * класса Int. В результате теперь можно прибавлять к целому числу определённый объект.
 */
fun main() {
    val a = MyNumber(56)
    val b = 5 + a
    println(b)
}

data class MyNumber(val num: Int)

operator fun Int.plus(num: MyNumber): MyNumber {
    return MyNumber(this + num.num)
}