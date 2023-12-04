package oop
import base.simpleFun
import functions.AnotherClass
import functions.sum21 as ssum

/**
 * Для подключения сущностей из пакета необходимо применить директиву import.
 */

fun main() {
    //Ниже пример подключения класса BMV из пакета design_pattern без использования import.
    val a21 = design_pattern.BMV()
    a21.start()

    //Ниже подключили класс через импорт.
    val a22 = AnotherClass()
    println(a22.aa)

    //Пример подключения из пакета base, переменные в main поэтому их не получится также подключить.
    simpleFun()

    //Пример подключения через пакет, но с использованием псевдонима.
    println(ssum(2, 3))
}