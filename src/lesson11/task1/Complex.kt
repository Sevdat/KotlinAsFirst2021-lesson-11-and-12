@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import kotlin.IllegalArgumentException
import kotlin.math.pow

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
//matches(s)
//matches(s)
//\d*[+-]|\d*[i]
//\d([0-9+-]+)i?
//\d([0-9]+[+-][0-9])i?
//\d([0-9][+-]?[0-9])i?

fun Complex(s: String): Complex {
    if (
        !Regex("""\d([0-9+-]+)i?""").matches(s) || s.replace(Regex("[^-+]"), "").length != 1
    ) throw IllegalArgumentException("Value Error")

    val sign = s.replace(Regex("[^-+]"), "")
    val values = s.replace(Regex("[-+]"), " ").split(" ")
    val normal = values[0].toDouble()
    val i = when {
        sign != "-" -> values[1].replace("i", "").toDouble()
        else -> (sign + values[1]).replace("i", "").toDouble()
    }

    return Complex(normal, i)
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
    constructor(x: Double) : this(x, 0.0)

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
    operator fun div(other: Complex): Complex = if ((other.re.pow(2) + other.im.pow(2)) != 0.0) Complex(
        (re * other.re + im * other.im) / (other.re.pow(2) + other.im.pow(2)),
        (im * other.re - re * other.im) / (other.re.pow(2) + other.im.pow(2))
    ) else throw IllegalArgumentException("Denominator 0")

    /**
     * Сравнение на равенство
     */
    //null
    override fun equals(other: Any?): Boolean = other is Complex && other.re == re && other.im == im
//   override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as Complex
//
//        if (re != other.re) return false
//        if (im != other.im) return false
//
//        return true
//    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = if (im < 0) "$re${im}i" else "$re+${im}i"

}
