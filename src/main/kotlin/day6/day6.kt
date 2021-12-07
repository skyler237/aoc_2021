package day6

import java.io.File

fun main() {
    val fish = File("src/main/kotlin/day6/input.txt").readText().trim().split(',').map { it.toInt() }
    val fishCounts = LongArray(9)
    fish.forEach { fishCounts[it] = fishCounts[it] + 1 }
    for( i in 0 until 256) {
        val zeroIndex = i % 9
        val sevenIndex = (zeroIndex + 7) % 9
        fishCounts[sevenIndex] += fishCounts[zeroIndex]
        if (i == 79 || i == 255) {
            println(fishCounts.sum())
        }
    }
}

/*
0 -> 80 =
6,79 + 8,79 =
5,78 + 7,78 =
0,73 + 2,73 =
6,72 + 1,72 + 8,72 =
5,71 + 0,71 + 7,71 =
4,70 + 6,70 + 6,70 + 8,70
 */