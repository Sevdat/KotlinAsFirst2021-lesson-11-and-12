@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import java.lang.IllegalArgumentException
import kotlin.math.pow

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    val sign = s.replace(Regex("[^-+*]"), "")
    val values = s.replace(Regex("[-+*]"), " ").split(" ")
    val normal = values[0].toDouble()
    val i = when {
        sign != "-" -> values[1].replace(" ", "").replace("i", "").toDouble()
        sign == "-" -> (sign + values[1]).replace(" ", "").replace("i", "").toDouble()
        else -> IllegalArgumentException()
    }


    return Complex(normal, i as Double)
}


/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(TODO(), TODO())

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(re + other.re, im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-re, -im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(re - other.re, im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex =
        Complex(re * other.re - im * other.im, re * other.im + im * other.re)

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex = Complex(
        (re * other.re + im * other.im) / (other.re.pow(2) + other.im.pow(2)),
        (im * other.re - re * other.im) / (other.re.pow(2) + other.im.pow(2))
    )

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean = TODO()


    /**
     * Преобразование в строку
     */
    override fun toString(): String = TODO()
}
