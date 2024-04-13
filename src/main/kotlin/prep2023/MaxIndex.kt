package prep2023

import kotlin.math.max

fun main() {
    val expected = 9
    val actual = maxIndex(4, 6)
    println("expected: $expected, actual: $actual")
}

fun maxIndex(steps: Int, badIndex: Int): Int {
    // Write your code here
    var result = 0
    for (skipStep in 1..steps) {
        var index = 0
        for (j in 1..steps) {
            if (j == skipStep) continue
            if (index + j != badIndex) {
                index += j
            }
        }
        result = max(result, index)
    }
    return result
}