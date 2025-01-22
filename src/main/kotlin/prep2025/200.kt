package prep2025

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(numIslands(grid))
}

fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0
    var result = 0

    val rows = grid.size - 1
    val cols = grid.first().size - 1
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun bfs(row: Int, col: Int) {
        val queue = mutableListOf<Pair<Int, Int>>()
        visited.add(Pair(row, col))
        queue.add(Pair(row, col))
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            val directions = mutableListOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
            directions.forEach { d ->
                val r = node.first + d.first
                val c = node.second + d.second
                if (r in 0..rows && c in 0..cols &&
                    grid[r][c] == '1' && !visited.contains(r to c)
                ) {
                    queue.add(r to c)
                    visited.add(r to c)
                }
            }
        }
    }

    for (r in 0..rows) {
        for (c in 0..cols) {
            if (grid[r][c] == '1' && !visited.contains(Pair(r, c))) {
                // Land, ho!
                bfs(r, c)
                result++
            }
        }
    }
    return result
}