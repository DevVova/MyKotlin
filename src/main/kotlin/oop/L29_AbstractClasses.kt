package oop

/**
 * Абстрактные классы - это классы, определенные с модификатором abstract.
 * Отличительной особенностью абстрактных классов является то, что мы не можем
 * создать объект подобного класса.
 * Абстрактный класс, как и обычный, может иметь свойства, функции, конструкторы,
 * но создать его объект напрямую вызвав его конструктор мы не можем.
 * Такой класс мы можем только унаследовать.
 *
 * Если класс наследуется от абстрактного класса, то он должен либо реализовать
 * все его абстрактные методы и свойства, либо также быть абстрактным.
 */

fun main() {
    val cube = Cube(4)
    cube.info()
    println(cube.corners)
}

abstract class Figure1(val corners: Int) {
    abstract val sides: Int

    fun info() {
        println("This is figure.")
    }
    abstract fun infoAboutSides()
}

class Cube(cubCorners: Int, override val sides: Int = 4) : Figure1(cubCorners) {
    override fun infoAboutSides() {
        println("This is a cube.")
    }
}