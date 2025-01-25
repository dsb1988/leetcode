package prep2025

import kotlin.math.max

fun main() {
    println(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        )
    )
}

fun maximalSquare(matrix: Array<CharArray>): Int {
    var maxSquare = 0
    if (matrix.isEmpty()) {
        return 0
    }
    val rows = matrix.size
    val cols = matrix[0].size

    val cache = Array(rows + 1) { IntArray(cols + 1) { 0 } }
    for (i in rows - 1 downTo 0) {
        for (j in cols - 1 downTo 0) {
            if (matrix[i][j] == '1') {
                val min = minOf(
                    cache[i][j + 1],
                    cache[i + 1][j],
                    cache[i + 1][j + 1]
                )
                cache[i][j] = min + 1
            } else {
                cache[i][j] = 0
            }

            maxSquare = max(maxSquare, cache[i][j])
        }
    }

    return maxSquare * maxSquare
}