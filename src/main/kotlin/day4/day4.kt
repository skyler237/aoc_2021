package day4

import java.io.File

data class BingoSquare (val row: Int, val col: Int, val isCalled: Boolean = false)

class BingoBoard(boardString: String) {
    private var isFinished: Boolean = false
    var columnCounts: IntArray = IntArray(5) {0}
    var rowCounts: IntArray = IntArray(5) {0}

    private var squares_: MutableMap<Int, BingoSquare> = mutableMapOf()
    var uncalledSquares: MutableSet<Int> = mutableSetOf()

    init {
        boardString.trim().split('\n').forEachIndexed { row, line ->
            if (!line.isEmpty()) {
                line.trim().split("\\s+".toRegex()).forEachIndexed { col, x ->
                    with(x.toInt()) {
                        squares_[this] = BingoSquare(row, col)
                        uncalledSquares.add(this)
                    }
                }
            }
        }
    }

    fun checkNumber(number: Int): Boolean {
        if (uncalledSquares.contains(number)) {
            val square = squares_[number]
            if (square != null) {
                columnCounts[square.col] += 1
                rowCounts[square.row] += 1
                uncalledSquares.remove(number)
                if (columnCounts[square.col] >= 5 || rowCounts[square.row] >= 5) {
                    isFinished = true
                    return true
                }
            }
        }
        return false
    }

    fun getScore(): Int {
        return uncalledSquares.sum()
    }

    fun finished(): Boolean {
        return isFinished
    }
}

fun main() {

    val text = File("src/main/kotlin/day4/input.txt").readText().split("""\n\n""".toRegex())
    val numbers: List<Int> = text[0].split(',').map {it.toInt()}
    val boards = text.subList(1, text.size).map { BingoBoard(it) }
    val numBoards = boards.size
    var finishedBoards = 0
    numbers.forEach { number ->
        boards.forEach { board ->
            if (!board.finished() && board.checkNumber(number)) {
                finishedBoards += 1
                if (finishedBoards == 1 || finishedBoards == numBoards) {
                    println(number * board.getScore())
                }
            }
        }
    }

}