package oop

/**
 * Enums или перечисления представляют тип данных, который позволяет определить
 * набор логически связанных констант. Для определения перечисления применяются
 * ключевые слова enum class.
 * Константы определяются через запятую. Каждая константа фактически
 * представляет объект данного перечисления.
 * Классы перечислений, как и обычные классы, также могут иметь конструктор.
 * Кроме того, для констант перечисления также может вызываться конструктор
 * для их инициализации.
 *
 * Enum class позволяет упростить код и предотвратить ошибки, связанные с
 * опечатками или неправильными значениями на этапе компиляции, а не
 * в процессе выполнения программы.
 */

fun main() {
    val day1 = Day.SUNDAY
    val day2 = Day.THURSDAY
    println(day1.value)
    println(day1.getDuration(day2))
    val day3 = Day.MONDAY
    println(day3)
    println()

    val f = Figure2.TRIANGLE
    println(f.name)
    val f2 = Figure2.CUBE
    println(f2.name)
    println(f.ordinal)//Будет 1, так как счёт идёт с 0.
    println()

    //Вот так можно перечислить все дни недели.
    for(a in Day.entries) {
        println(a)
    }
    println()

    //Возвращение объекта перечисления по названию константы.
    println(Day.valueOf("WEDNESDAY"))
    println()

    val day = Theme.DAY
    day.printInfo()
    println(day.color)
    val night = Theme.NIGHT
    night.printInfo()
    println()

    val tuzik = TypeAnimal.DOG
    tuzik.voice()
    val murzik = TypeAnimal.CAT
    murzik.voice()
    println()

    println(operate(34, 7, Operation.MULTIPLY))
}

enum class Day(val value: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);//Нужно в конце ставить точку с запятой.

    //Ниже функция вычисляет разницу в днях между двумя днями недели.
    fun getDuration(day: Day): Int {
        return value - day.value
    }
}

enum class Figure2 {
    CUBE,
    TRIANGLE
}

//Анонимные классы и реализация интерфейсов.

/*
  Константы перечисления могут определять анонимные классы, которые могут
  иметь собственные методы и свойства или реализовать абстрактные методы
  класса перечисления:
 */
enum class Theme {
    DAY {
        override val color = "white"
        override fun printInfo() {
            println("This is a day.")
        }
    },
    NIGHT {
        override val color = "black"
        override fun printInfo() {
            println("This is a night.")
        }
    };
    abstract val color: String
    abstract fun printInfo()
}

/*
  Также, классы перечислений могут применять интерфейсы. Для этого для каждой
  константы определяется анонимный класс, который содержит все реализуемые
  свойства и функции:
 */

interface Voice32 {
    fun voice()
}

enum class TypeAnimal: Voice32 {
    CAT {
        override fun voice() {
            println("may")
        }
    },
    DOG {
        override fun voice() {
            println("gav")
        }
    }
}

//Хранение состояния.
/*
   Нередко перечисления применяются для хранения состояния в программе.
   И в зависимости от этого состояния мы можем направить действие программы
   по определенному пути. Например, определим перечисление, которое
   представляет арифметические операции, и функцию, которая в зависимости
   от переданной операции выполняет то или иное действие:
 */

fun operate(a: Int, b: Int, op: Operation): Int {
    return when(op) {
        Operation.ADD -> a + b
        Operation.SUBTRACT -> a - b
        Operation.MULTIPLY -> a * b
    }
}

enum class Operation {
    ADD, SUBTRACT, MULTIPLY
}
