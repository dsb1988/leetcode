package prep2025

fun main() {
    println(numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)))
}

fun numPairsDivisibleBy60(time: IntArray): Int {
    val rems = Array(60) { 0 }
    time.forEach { t ->
        val rem = t.mod(60)
        rems[rem] += 1
    }

    var result = 0
    result += ((rems[0] - 1) * rems[0]) / 2
    result += ((rems[30] - 1) * rems[30]) / 2
    for (i in 1 until 29) {
        result += rems[i] * rems[60 - i]
    }
    return result
}