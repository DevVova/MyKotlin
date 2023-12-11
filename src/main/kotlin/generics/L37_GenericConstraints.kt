package generics

/**
 * Ограничения обобщений (generic constraints) ограничивают набор типов,
 * которые могут передаваться вместо параметра в обобщениях.
 * Стоит отметить, что по умолчанию ко всем параметрам типа также применяется
 * ограничение в виде типа Any?. То есть определение параметра типа <T>
 * фактически аналогично определению <T: Any?>
 */

fun main() {
    val vova = Human37("Vova", 45)
    mes(vova)
    vova.printInfo()

    val gena = Man37("Gena")
    mes(gena)

    //Пример с двойным ограничением.
    val vasya = ManMan("Vasya", 31)
    val kolya = Human("Kolya", 77)
    mes2(kolya)
    mes2(vasya)
    val g = GoodMan36<ManMan>()//Здесь нужно указывать тип в угловых скобках, так как конструктор не принимает параметров.
    g.infoInfo(vasya)
}

fun<T: Message> mes(text: T) {
    println(text.info)
}

//Ниже полная верная версия записи.
fun<T> mes2(text: T) where T: Message, T: MessageAge {
    println(text.info)
    println(text.infoAge)
}

interface Message {
    val info: String
}

interface MessageAge {
    val infoAge: Int
}

class ManMan(override val info: String, override val infoAge: Int) : Message, MessageAge
class Human(override val info: String, override val infoAge: Int) : Message, MessageAge

class Man37(override val info: String) : Message
class Human37(override val info: String, private val age: Int) : Message {
    fun printInfo() {
        println("He' $age years old.")
    }
}

class GoodMan36<T> where T: Message, T: MessageAge {
    fun infoInfo(man: T) {
        println(man.info)
        println(man.infoAge)
    }
}