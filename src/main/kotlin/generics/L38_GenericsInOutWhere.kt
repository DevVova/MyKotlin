package generics

/**
 * Вариантность - это состояние наличия отношений наследования между
 * параметризованными типами, содержащими параметры из одной иерархии
 * наследования.
 *
 * Инвариантность — это отсутствие отношений наследования между
 * параметризованными типами. Можно передать ровно тот тип, который указан.
 * Инвариантность означает, что тип не может быть расширен или сужен при
 * наследовании. Ковариантность позволяет типу быть расширенным,
 * а контравариантность — суженным.
 */

fun main() {
    //Ниже приведён пример инвариантности.
    val gena: AnyObj<Animal> = AnyObj<Animal>(Dog("Gena", 7))
    gena.pr()

    //Ниже приведён пример ковариантности.
    val gena2: AnyObj1<Animal> = AnyObj1<Dog>(Dog("Gena", 8))
    gena2.pr()

    //Ниже приведён пример контрвариантности.
    val gena3: AnyObj2<Dog> = AnyObj2<Animal>(Dog("Gena", 9))
    gena3.pr()

    val sam = Dog("Sam", 5)
    sam.infoPlus()
}

open class Animal(val name: String) {
    fun info() {
        println("It is $name.")
    }
}

class Dog(name: String, val age: Int) : Animal(name) {
    fun infoPlus() {
        println("It's $age.")
    }
}

class AnyObj<T>(private val obj: T) where T: Animal {
    fun pr() {
        obj.info()
    }
}

//Входной параметр может быть только val.
class AnyObj1<out T: Animal>(private val obj: T) {
    fun pr() {
        obj.info()
    }
}

class AnyObj2<in T: Animal>(private val obj: T) {
    fun pr() {
        obj.info()
    }
}