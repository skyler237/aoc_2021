package day8 import java.io.File

fun decodeSegments(patterns: List<String>, digits: List<String>): List<Int> {
    // Decode numbers we know
    val patternsBySize: Map<Int, List<String>> = patterns.groupBy { it.length }

    return digits.map {
        when(it.length) {
            2 -> 1
            3 -> 7
            4 -> 4
            5 -> {
                with (it.toSet()) {
                    if (this.containsAll<Char>(patternsBySize[2]!![0].toSet())) {
//                    if (this.containsAll(patternsBySize[2].toSet())) {
                        3
                    }
                    else if (this.containsAll<Char>((patternsBySize[4]!![0].toSet() - patternsBySize[2]!![0].toSet().toSet()))){
                        5
                    }
                    else {
                        2
                    }
                }
            }
            6 -> {
                with (it.toSet()) {
                    if (this.containsAll<Char>(patternsBySize[4]!![0].toSet())) {
                        9
                    } else if (this.containsAll<Any>(patternsBySize[2]!![0].toSet())) {
                        0
                    } else {
                        6
                    }
                }
            }
            7 -> 8
            else -> {
                println("Error!")
                0
            }
        }
    }
}

fun main() {
    val lines = File("src/main/kotlin/day8/input.txt").readLines()
    val part1Count = lines.sumOf { line ->
        with(line.split('|')) {
            // Part1
//            decodeSegments(this[0].trim().split(' '), this[1].trim().split(' ')).count { it in listOf(1,4,7,8) }
            val digits = decodeSegments(this[0].trim().split(' '), this[1].trim().split(' '))
            val digitsVal = digits.joinToString("").toInt()
            digitsVal
        }
    }
    println(part1Count)
}