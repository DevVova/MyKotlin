package design_pattern

/**
 * Пример шаблона проектирования под названием "CallBack" функция. "CallBack"
 * функция - это такая функция, которая вложена в качестве параметра другой
 * функции или является результатом действия этой функции.
 *
 * Ниже в примере используется лямбда выражение. Так как у нас функция обратного
 * вызова не принимает ни каких параметров и не возвращает никаких значений,
 * то мы можем создавать такого рода вложенности(как ёлочка).
 */

fun main() {
    anotherFunction {
        anotherFunction {
            anotherFunction {
                val a = 9
                val b = 8
                print("a = $a, b = $b")
                println()
            }
        }
    }
}

fun anotherFunction(callBack: () -> Unit) {
    callBack()//Вот она функция обратного вызова, она вызывается в определённый момент выполнения программы(поэтому так называют её, хотя на мой взгляд не вполне логично).
}