package prep2023

fun main() {
    println(divisibleSumPairs(6, 5, arrayOf(1, 2, 3, 4, 5, 6)))
}

fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    // Write your code here
    var result = 0
    for (i in 0..ar.size - 2) {
        for (j in i + 1 until ar.size) {
            if ((ar[i] + ar[j]) % k == 0) {
                result++
            }
        }
    }
    return result
}