package prep2023

// n - rows, m - columns
// result int mod 10^9+7
fun main() {
    // n = 2, m = 4
    val warehouse = arrayOf(arrayOf(1, 1), arrayOf(0, 1))
    warehouse.forEach { println(it.contentToString()) }
    println("Result: ${numPaths(warehouse)}")
}

fun numPaths(warehouse: Array<Array<Int>>): Int {
    // Write your code here
    if (warehouse.isEmpty()) return 0
    val rows = warehouse.size
    val columns = warehouse[0].size

    val modulo = 1000000007
    val dp = warehouse.copyOf()
    for (r in rows - 1 downTo 0) {
        for (c in columns - 1 downTo 0) {
            if (c == columns - 1 && r == rows - 1) {
                // target
                dp[r][c] = 1
            } else if (dp[r][c] == 0) {
                // obstacle
            } else if (r == rows - 1) {
                dp[r][c] = dp[r][c + 1]
            } else if (c == columns - 1) {
                dp[r][c] = dp[r + 1][c]
            } else {
                dp[r][c] = (dp[r + 1][c] + dp[r][c + 1]).mod(modulo)
            }
        }
    }
    return dp[0][0] % modulo
}