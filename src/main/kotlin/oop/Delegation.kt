package oop

/**
 * Делегирование представляет паттерн объектно-ориентированного
 * программирования, который позволяет одному объекту
 * делегировать/перенаправить все запросы другому объекту.
 *
 * В определенной степени делегирование может выступать
 * альтернативой наследованию.
 *
 * То есть допустим что у нас есть класс, который реализует
 * какой-то интерфейс. И мы создаём другой класс, в который
 * хотим установить функционал того класса. Так вот мы можем
 * не наследоваться от него, а передать в качестве входного
 * параметра объект этого класса и затем обращаться к функциям
 * того класса, хотя по факту сам класс эти функции не выполняет,
 * а он делегирует это другому.
 */

fun main() {
    val p1 = LaserPrinter("Wow! Is great!")
    val p2 = LaserPrinterReceiver("Stirlich")
    val p = Fax(p1, p2)
    p.printFax()
    p.printText()
    p.setMessage()

    val aa = Another()
    val aaa = AnotherDelegation(aa)
    aaa.printText()
    aaa.setMessage()
    val aaa2 = AnotherDelegation2(aa)
    aaa2.setMessage()//А вот printText() уже вызвать нельзя, так как имплементировали только Receiver.
}

interface Printer {
    fun printText()
}

//Создаём класс, который имплементирует интерфейс Printer.
class LaserPrinter(private val text: String) : Printer {
    override fun printText() {
        println("The text is \"$text\".")
    }
}

interface Receiver {
    fun setMessage()
}

class LaserPrinterReceiver(private val nameDevice: String) : Receiver {
    override fun setMessage() {
        println("The receiver \"$nameDevice\" is working.")
    }
}

/*
Создаём класс, который принимает на вход два объекта. Этот класс
через эти объекты имплементирует два интерфейса. То есть он в
последующем при создании объекта этого класса, при обращении к
функции этого объекта, будет перенаправлять к вызову соответствующей
функции другого объекта, которому он это делегирует.
 */
//После конструктора нужно будет сделать отступ перед двоеточием.
class Fax(pr: LaserPrinter, lpr: LaserPrinterReceiver) : Printer by pr,
    Receiver by lpr {
    fun printFax() {
        println("The fax is working.")
    }
}

class Another : Receiver, Printer {
    override fun setMessage() {
        println("Ку- ку")
    }

    override fun printText() {
        println("Ку- ку. I'm Vova.")
    }
}

//Вот как можно делегировать объекту, класс которого имплементирует несколько интерфейсов.
class AnotherDelegation(a: Another) : Receiver by a, Printer by a

class AnotherDelegation2(a: Another) : Receiver by a