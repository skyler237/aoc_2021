package day3

import java.io.File
import kotlin.math.pow

fun main() {
    // Part 1
    val numBits = 12
    var bitSums = IntArray(numBits)
    var numEntries = 0
    val lines = File("src/main/kotlin/day3/input.txt").readLines()
    lines.forEach {
        it.forEachIndexed{i, c -> bitSums[i] += c.digitToInt() }
        numEntries += 1
    }
    var gamma = 0.0
    bitSums.forEachIndexed{i, sum ->
        if (sum > numEntries/2) {
            gamma += 2.0.pow(numBits - 1 - i)
        }
    }
    val epsilon = 2.0.pow(numBits).toInt() - gamma - 1
    println(epsilon * gamma)

    // Part 2
    val sortedLines = lines.sorted()
    var oxygenLines = sortedLines
    var co2Lines = sortedLines
    var oxygenVal = 0U
    var co2Val = 0
    for (i in 0 until numBits) {
        with(oxygenLines.indexOfLast { it[i] == '0' }) {
            oxygenLines = if (this > (oxygenLines.count())/2-1) {
                oxygenLines.subList(0, this+1)
            } else {
                oxygenLines.subList(this+1, oxygenLines.count())
            }
        }
        if (oxygenLines.count() == 1) {
            println("oxygen: $oxygenLines")
            oxygenVal = oxygenLines[0].toUInt(2)
            println("value: $oxygenVal")
        }

        with(co2Lines.indexOfLast { it[i] == '0' }) {
            co2Lines = if (this <= (co2Lines.count())/2-1) {
                co2Lines.subList(0, this+1)
            } else {
                co2Lines.subList(this+1, co2Lines.count())
            }
        }
        if (co2Lines.count() == 1) {
            println("co2Lines: $co2Lines")
            co2Val = co2Lines[0].toInt(2)
            println("value: $co2Val")
        }
    }
    println(co2Val.toDouble() * oxygenVal.toDouble())
}