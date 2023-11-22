package base

/**
 * Для хранения набора значений в Kotlin, как и в других языках программирования,
 * можно использовать массивы. При этом массив может хранить данные только одного
 * того же типа. В Kotlin массивы представлены типом Array.
 */

fun main() {
    val arr: Array<Byte> = arrayOf(-7, 22, 0, -4)//arrayOf- это функция для передачи набора значений в массив.
    arr.forEach { print("$it ") }
    println()

    println(arr[2])//Вот так можно узнать 3 элемент массива, нумерация начинается с 0.
    val arr1 = Array<Short>(5) { 0 }//Так создаём массив из 5 элементов и каждый элемент равен 0.
    arr1.forEach { print("$it  ") }
    println()

    var i = 0
    val arr2 = Array(7) { i++ * 3 }//Пример создания массива по условию.
    arr2.forEach { print("$it   ") }
    println()
    //Ниже пример того как мы пробежали по всем индексам массива и записали их, indices- это набор всех индексов.
    for (n in arr2.indices) {
        print("$n ")
    }
    println()
    val elementIs = 3 in arr2//Вот так можно определить содержится ли число в массиве.
    println(elementIs)

    /**
     * Для упрощения создания массива в Kotlin определены дополнительные
     * типы BooleanArray, ByteArray, ShortArray, IntArray, LongArray,
     * CharArray, FloatArray и DoubleArray, которые позволяют создавать
     * массивы для определенных типов. Например, тип IntArray позволяет
     * определить массив объектов Int, а DoubleArray - массив объектов Double:
     */

    val arr3: FloatArray = floatArrayOf(9.1f, 2.2f, 3.88f)
    var b = 0
    while (b in arr3.indices) {
        print("${arr3[b]}     ")
        b++
    }
    println()

    var a = 1.0
    val arr4 = DoubleArray(8) { ++a * 2.8 }
    arr4.forEach { print("$it  ") }
    println()

    //Двухмерные массивы.
    //Ниже пример создания массива из 3 рядов в каждом ряду по 4 элемента и значения всех элементов равно 0.
    val arrTwo: Array<Array<Short>> = Array(3) {
        Array(4) {
            0
        }
    }
    //Ниже пример как можно изменить значение каждого элемента.
    arrTwo[0] = arrayOf(1, 2, 3, 4)
    arrTwo[1] = arrayOf(9, 8, 7, 6)
    arrTwo[2] = arrayOf(8, 8, 8, 8)
    for (row in arrTwo) {
        for(cell in row) {
            print("$cell\t")
        }
        println()
    }
}