package day2
import java.io.File
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        var depth = 0
        var position = 0
        var aim = 0
        File("src/main/kotlin/day2/input.txt").readLines().forEach{
            val (command, value) = it.split(" ")
            with(value.toInt()) {
                // Part 1
//                when (command) {
//                    "forward" -> {
//                        position += this
//                    }
//                    "up" -> {
//                        depth -= this
//                    }
//                    "down" -> {
//                        depth += this
//                    }
//                }
//                println(depth * position)
                // Part 2
                when (command) {
                    "forward" -> {
                        position += this
                        depth += aim * this
                    }
                    "up" -> {
                        aim -= this
                    }
                    "down" -> {
                        aim += this
                    }
                }
            }
        }
        println(depth * position)

    }

    println("Elapsed time: $executionTime ms")
}