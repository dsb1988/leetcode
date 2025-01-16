package prep2025

fun maximumPopulation(logs: Array<IntArray>): Int {
    // [birth, death]
    // alive = death - birth - 1
    val years = hashMapOf<Int, Int>() // year, population
    logs.forEach { log ->
        if (log.size == 2) {
            for (year in log[0] until log[1]) {
                years[year] = years.getOrDefault(year, 0) + 1
            }
        }
    }
    val maxPopulation = years.maxOf { it.value }
    return years.filter { (_, pop) -> pop == maxPopulation }.minOf { (year, _) -> year }
}