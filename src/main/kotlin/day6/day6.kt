package day6 import java.io.File
fun main() {
    val fish=File("src/main/kotlin/day6/input.txt").readText().trim().split(',').map { it.toInt() }
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