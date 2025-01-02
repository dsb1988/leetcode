package prep2024

fun main() {
    val exampleOne = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )

    val exampleTwo = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )

    val exampleThree = arrayOf(
        charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
        charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
        charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
        charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
        charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
        charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
        charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.'),
    )

    println(isValidSudoku(exampleOne))
    println(isValidSudoku(exampleTwo))
    println(isValidSudoku(exampleThree))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    // rows
    for (i in board.indices) {
        val rowStats = hashMapOf<Char, Int>()
        for (j in board.indices) {
            if (!board[i][j].isDigit()) continue
            if (rowStats.getOrDefault(board[i][j], 0) > 0) {
                return false
            } else {
                rowStats[board[i][j]] = 1
            }
        }
    }
    // columns
    for (i in board.indices) {
        val columnStats = hashMapOf<Char, Int>()
        for (j in board.indices) {
            if (!board[j][i].isDigit()) continue
            if (columnStats.getOrDefault(board[j][i], 0) > 0) {
                return false
            } else {
                columnStats[board[j][i]] = 1
            }
        }
    }
    // 3x3
    for (i in board.indices step 3) {
        for (j in board.indices step 3) {
            val subBoardsStats = hashMapOf<Char, Int>()
            for (k in 0..2) {
                for (l in 0..2) {
                    val char = board[k + i][l + j]
                    if (!char.isDigit()) continue
                    if (subBoardsStats.getOrDefault(char, 0) > 0) {
                        return false
                    } else {
                        subBoardsStats[char] = 1
                    }
                }
            }
        }
    }
    return true
}