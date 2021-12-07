package day5

import java.io.File
import java.util.function.BiFunction
import kotlin.math.abs
import kotlin.math.sign

data class Point(val x: Int, val y: Int)

class Line(lineString: String) {
    val regex = """(\d+),(\d+) -> (\d+),(\d+)""".toRegex()
    var startPoint: Point = Point(0,0)
    var endPoint: Point = Point(0,0)
    var dy: Int = 0
    var dx: Int = 0
    var points: MutableList<Point> = mutableListOf()
    init {
        regex.matchEntire(lineString)?.destructured?.let { (x1, y1, x2, y2) ->
            startPoint = Point(x1.toInt(), y1.toInt())
            endPoint = Point(x2.toInt(), y2.toInt())
        }

        dx = endPoint.x - startPoint.x
        dy = endPoint.y - startPoint.y

        val maxDelta: Double = if (abs(dx) > abs(dy)) dx.toDouble() else dy.toDouble()
        val xStep: Double = dx / abs(maxDelta)
        val yStep: Double = dy / abs(maxDelta)

        var xCursor: Double = startPoint.x.toDouble()
        var yCursor: Double = startPoint.y.toDouble()
        while (xCursor.toInt() != endPoint.x || yCursor.toInt() != endPoint.y) {
            points.add(Point(xCursor.toInt(), yCursor.toInt()))
            xCursor += xStep
            yCursor += yStep
        }
        points.add(endPoint)
    }
}

class LineMap {
    var map: MutableMap<Point, Int> = mutableMapOf()

    fun applyLine(line : Line) {
        line.points.forEach {
            val currentCount = map[it] ?: 0
            map[it] = currentCount + 1
        }
    }

    fun count(threshold: Int): Int {
        var numPoints = 0
        map.forEach {point, value ->
            if (value >= threshold) {
                numPoints += 1
            }
        }
        return numPoints
    }
}

fun main() {
    var lineMap: LineMap = LineMap()
    val lines = File("src/main/kotlin/day5/input.txt").readLines().map { Line(it) }
    lines.forEach {
//        if (it.dx == 0 || it.dy == 0) {
            lineMap.applyLine(it)
//        }
    }

    println(lineMap.count(2))
}