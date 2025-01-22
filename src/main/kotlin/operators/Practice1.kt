package operators

/**
 * В Kotlin operator — это модификатор, используемый для объявления функции, которая
 * переопределяет стандартные операции (операторы), такие, как +, -, *, /, [], ==, >, <, и другие.
 * Это позволяет использовать пользовательские объекты в выражениях, как если бы они были
 * встроенными типами.
 */
fun main() {
    val pr1 = Profit(23.4)
    val pr2 = Profit(14.6)
    var res = pr1 + pr2
    println(res.profit)
    res = pr1 + pr1//res = pr1 + 7 - вот так нельзя, мы можем переменную типа Profit только складывать с такой же переменной.
    println(res.profit)

    //Ниже пример когда мы можем складывать тип AnyProfit с Int.
    val pr3 = AnyProfit(33.3)
    var pr4 = pr3 + 7
    println(pr4)
    pr4 = pr3 + 22
    println(pr4)//pr4 = 8 + pr3 - вот так нельзя, а можно только pr4 = pr3 + 8, и так тоже нельзя - pr4 = pr3 + 8.3
}

class Profit(val profit: Double) {
    operator fun plus(other: Profit): Profit {
        return Profit(this.profit + other.profit)
    }
}

//Ниже уже не класс, а дата класс и у него функция, которая переопределяет операцию плюс, но она также перегружена.
data class AnyProfit(val profit: Double) {
    operator fun plus(other: AnyProfit): AnyProfit {
        return AnyProfit(this.profit + other.profit)
    }

    //Ниже вот такая вот нелепица, можно теперь складывать зато с целыми числами.
    operator fun plus(other: Int): AnyProfit {
        return AnyProfit(this.profit + other)
    }
}