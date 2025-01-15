package coroutines.metanit

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * coroutineScope — это блокирующий билдер корутин в Kotlin. Он создает локальную область
 * видимости для корутин, которая не завершается до тех пор, пока все корутины, запущенные
 * в этом блоке, не завершат свою работу. Это ключевой инструмент для организации и
 * структурирования асинхронного кода. Код, следующий за coroutineScope, не выполняется,
 * пока все вложенные корутины не завершатся.
 *
 * launch — это билдер корутин в Kotlin, который используется для запуска новой корутины
 * без ожидания возвращаемого результата. Он возвращает объект типа Job, который можно
 * использовать для управления или отслеживания состояния корутины.
 *
 * Корутины, созданные с помощью launch, работают асинхронно и не блокируют поток.
 */
suspend fun main() {
    print("Введите число: ")
    val inputNumber = readln()
    coroutineScope {
        val job = launch {
            for (i in 1 until 5) {
                delay(500L)//Это специальная функция для задержки выполнения.
                println(i)
            }
        }
        if (inputNumber.toInt() < 5) job.join()
        else job.cancel()
    }
    val nextJob = coroutineScope {
        val job2 = launch {
            for (i in 1 until 8) {
                delay(1000L)
                print("$i ")
            }
            println()
        }
        println("Hello Vova 1!")// Выполняется сразу, так как launch выполняется асинхронно.
        job2
    }
    nextJob.join()
    println("Hello Vova 2!")// Выполняется, когда coroutineScope завершит работу.

    for (i in 1 until 5) {
        val c = coroutineScope {
            val cc = launch {
                doWork(i)
            }
            cc
        }
        c.join()
    }
}

//Ниже в примере мы вынесли логику в отдельную функцию.
suspend fun doWork(i: Int) {
    delay(700L)
    println(i)
}