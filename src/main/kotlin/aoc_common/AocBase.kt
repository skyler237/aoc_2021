package aoc_common

import java.io.File

open class AocBase (val day_string: String) {
    val input_lines: List<String> = File("src/main/kotlin/$day_string/input.txt").readLines()
}