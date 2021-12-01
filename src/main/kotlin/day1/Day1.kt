package day1

import java.io.File

fun main() {
    val numbers = File("src/main/kotlin/day1/input.txt").readLines().map { it.toInt() }
    println(numbers.subList(1,numbers.size).mapIndexed { index, i -> (i - numbers[index]) > 0 }.count{it})
    // Part 1
    val increased = numbers.subList(1,numbers.size).mapIndexed { index, i ->
        println("Index: $index, number: $i")
        (i - numbers[index]) > 0
    }
    println(increased.count {it})

    // Part2
    val sums = numbers.subList(0,numbers.size-2).mapIndexed {index, i ->  i + numbers[index+1] + numbers[index+2]}
    println(sums.subList(0,sums.size-1).mapIndexed { index, i -> sums[index + 1] - i > 0}.count{it})
}