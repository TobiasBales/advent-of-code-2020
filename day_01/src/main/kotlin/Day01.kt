package dev.tobiasbales.advent_of_code_2020.day_01

import java.io.File

class Day01(filename: String) {
    private val numbers by lazy {
        File("day_01/src/main/resources/$filename")
            .readLines()
            .map { it.toInt() }
    }

    fun run() {
        val sumOfTwo = sumOfTwo(2020)
        println("Numbers matched for two: ${sumOfTwo.first} + ${sumOfTwo.second} == 2020")
        println("Result: ${sumOfTwo.first * sumOfTwo.second}")

        val sumOfThree = sumOfThree(2020)
        println("Numbers matched for three: ${sumOfThree.first} + ${sumOfThree.second} + ${sumOfThree.third} == 2020")
        println("Result: ${sumOfThree.first * sumOfThree.second * sumOfThree.third}")
    }

    private fun sumOfTwo(target: Int): Pair<Int, Int> {
        numbers.forEach { numberA ->
            numbers.forEach { numberB ->
                if (numberA + numberB == target) {
                    return Pair(numberA, numberB)
                }
            }
        }

        throw Exception("Could not find matching two numbers")
    }

    private fun sumOfThree(target: Int): Triple<Int, Int, Int> {
        numbers.forEach { numberA ->
            numbers.forEach { numberB ->
                numbers.forEach { numberC ->
                    if (numberA + numberB + numberC == target) {
                        return Triple(numberA, numberB, numberC)
                    }
                }
            }
        }

        throw Exception("Could not find matching three numbers")
    }
}

fun main() {
    Day01("input.txt").run()
}
