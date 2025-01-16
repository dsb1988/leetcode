package prep2025

fun main() {
    println(dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
}

fun dividePlayers(skill: IntArray): Long {
    val sorted = skill.sorted()
    var left = 0
    var right = sorted.lastIndex
    val teams = mutableListOf<Pair<Int, Int>>()
    var teamChemistry = -1
    var totalChemistry = 0L
    while (left < right) {
        if (teamChemistry == -1) {
            teamChemistry = sorted[left] + sorted[right]
        } else if (teamChemistry != sorted[left] + sorted[right]) {
            return -1
        }
        teams.add(Pair(sorted[left], sorted[right]))
        totalChemistry += sorted[left] * sorted[right]
        left++
        right--
    }
    return totalChemistry
}