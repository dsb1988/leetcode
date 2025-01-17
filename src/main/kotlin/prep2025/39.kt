package prep2025

fun main() {
    println(combinationSum(intArrayOf(2, 3, 6, 7), 7))
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun dfs(i: Int, current: List<Int>, total: Int) {
        if (total == target) {
            result.add(current)
            return
        }
        if (i !in candidates.indices || total > target) {
            return
        }
        val newCurrent = current + candidates[i]
        dfs(i, newCurrent, total + candidates[i])
        dfs(i + 1, current, total)
    }

    dfs(0, emptyList(), 0)

    return result
}