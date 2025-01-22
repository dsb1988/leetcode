package prep2025

fun main() {
    println(maxCount(intArrayOf(1, 4, 6), 6, 4))
    println(maxCount(intArrayOf(4, 3, 5, 6), 7, 18))
}

fun maxCount(banned: IntArray, n: Int, maxSum: Long): Int {
    banned.sort()
    var result = 0
    var j = 0
    var currentSum = 0L
    for (i in 1..n) {
        if (j <= banned.lastIndex && banned[j] == i) {
            j++
            continue
        }
        currentSum += i
        if (currentSum > maxSum) {
            break
        }
        result++
    }
    return result
}