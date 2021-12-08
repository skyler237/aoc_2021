package day7 import java.io.File
import kotlin.math.*

fun part2Cost(numbers: List<Int>, pos: Int): Int {
    return numbers.sumOf { with(abs(it-pos)) {(this + 1)*this / 2 }}
}

fun main() {
    val numbers = File("src/main/kotlin/day7/input.txt").readText().trim().split(',').map { it.toInt() }.sorted()
    val median = numbers[numbers.size / 2]
    val medianCost = numbers.sumOf { abs(it - median) }
    println(medianCost)
    val mean = numbers.average()
    val lowerMean = floor(mean).toInt()
    val upperMean = ceil(mean).toInt()
    println(min(part2Cost(numbers, lowerMean), part2Cost(numbers, upperMean)))
}