package prep2025

fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('C', 'A', 'A'),
                charArrayOf('A', 'A', 'A'),
                charArrayOf('B', 'C', 'D')
            ),
            "AAB"
        )
    )
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.lastIndex
    val cols = board[0].lastIndex

    fun dfs(row: Int, col: Int, visited: List<Pair<Int, Int>>): Boolean {
        if (visited.size == word.length) {
            return true
        }
        val currentLetter = word[visited.size]
        if (row > rows || rows < 0) {
            return false
        }
        if (col > cols || cols < 0) {
            return false
        }

        if (row + 1 <= rows) {
            if (board[row + 1][col] == currentLetter && !visited.contains(row + 1 to col)) {
                val existBottom = dfs(row + 1, col, visited + (row + 1 to col))
                if (existBottom) {
                    return true
                }
            }
        }
        if (row - 1 >= 0) {
            if (board[row - 1][col] == currentLetter && !visited.contains(row - 1 to col)) {
                val existTop = dfs(row - 1, col, visited + (row - 1 to col))
                if (existTop) {
                    return true
                }
            }
        }
        if (col + 1 <= cols) {
            if (board[row][col + 1] == currentLetter && !visited.contains(row to col + 1)) {
                val existRight = dfs(row, col + 1, visited + (row to col + 1))
                if (existRight) {
                    return true
                }
            }
        }
        if (col - 1 >= 0) {
            if (board[row][col - 1] == currentLetter && !visited.contains(row to col - 1)) {
                val existLeft = dfs(row, col - 1, visited + (row to col - 1))
                if (existLeft) {
                    return true
                }
            }
        }
        return false
    }

    for (row in 0..rows) {
        for (col in 0..cols) {
            if (board[row][col] == word[0]) {
                if (dfs(row, col, listOf(row to col))) {
                    return true
                }
            }
        }
    }
    return false
}