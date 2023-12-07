package oop

/**
 * В Kotlin классы и интерфейсы могут быть определены в других классах
 * и интерфейсах. Такие классы (вложенные классы или nested classes) обычно
 * выполняют какую-то вспомогательную роль, а определение их внутри класса
 * или интерфейса позволяет разместить их как можно ближе к тому месту, где
 * они непосредственно используются.
 *
 * По умолчанию вложенные классы имеют модификатор видимости public, то есть
 * они видимы в любой части программы. Но для обращения к вложенному классу
 * надо использовать имя внешнего класса.
 * Если необходимо ограничить область применения вложенного класса только
 * внешним классом, то следует определить вложенный класс с модификатором
 * private.
 * Классы также могут содержать вложенные интерфейсы. Кроме того, интерфейсы
 * тоже могут содержать вложенные классы и интерфейсы.
 *
 * Стоит учитывать, что вложенный (nested) класс по умолчанию не имеет
 * доступа к свойствам и функциям внешнего класса.
 * Чтобы вложенный класс мог иметь доступ к свойствам и функциям внешнего
 * класса, необходимо определить вложенный класс с ключевым словом inner.
 * Такой класс еще называют внутренним классом (inner class), чтобы отличать
 * от обычных вложенных классов.
 * Но теперь если мы хотим использовать объект подобного вложенного класса,
 * то необходимо создать объект внешнего класса.
 */

fun main() {
    //Для создания объекта inner класса, нужно создать объект внешнего класса.
    val vasya = Person31(23)
    vasya.infoAboutAll()
    vasya.Account3(33).info()

    //Ниже создание объекта с использованием вложенного класса.
    val petya = Person31.Account1(21, "Petya")
    petya.info()

    //Используем функцию, завязанную на приватном вложенном классе.
    vasya.showAccountDetails()

    val vova = Person31(46, "Vova")
    vova.Account3(46).printAFromPerson31AndFromAccount3()
    vova.Account3(46).info()

    val kolya = Human31()
    kolya.moving()
    kolya.gav()
}

open class Person31(private val ageI: Int, private val nameI: String = "Tom") {
    private val account = Account2(ageI, nameI)
    private val a = true

    interface Move {
        fun moving()
    }

    class Account1(private val age: Int, private val name: String) {
        fun info() {
            println("$name is $age years old.")
        }
    }

    private class Account2(val ageInput: Int, val nameInput: String)

    inner class Account3(private val innerAge: Int) {
        private val a  = false
        fun info() {
            println("This is $nameI. He's $innerAge years old.")
        }
        fun printAFromPerson31AndFromAccount3() {
            println()
            println(this.a)//Это "а" из Account3.
            println(this@Account3.a)//Это "а" из Account3.
            println(this@Person31.a)//Это "а" из Person31.
            println()
        }
    }

    fun showAccountDetails() {
        println("Username: ${account.nameInput}, age: ${account.ageInput}")
    }

    fun infoAboutAll() {
        println("Constructor data is - age : $ageI, name : $nameI.")
    }
}

interface Voice {
    interface Gav {
        fun gav()
    }
    fun voice()
}

//Ниже примеры использования вложенных интерфейсов.
class Human31 : Person31.Move, Voice.Gav, Voice {
    override fun moving() {
        println("Moving.")
    }

    override fun gav() {
        println("gav-gav.")
    }

    override fun voice() {
        println("voice.")
    }
}