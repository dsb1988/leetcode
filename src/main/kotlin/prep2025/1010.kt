package prep2025

fun main() {
    println(numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
}

fun numPairsDivisibleBy60(time: IntArray): Long {
    val rems = Array(60) { 0L }
    time.forEach { t ->
        val rem = t.mod(60)
        rems[rem] += 1L
    }

    var result: Long = 0
    result += ((rems[0] - 1) * rems[0]) / 2 // ((n-1) * n) / 2
    result += ((rems[30] - 1) * rems[30]) / 2
    for (i in 1 until 30) {
        result += rems[i] * rems[60 - i]
    }
    return result
}