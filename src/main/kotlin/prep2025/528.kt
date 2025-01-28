package prep2025

import kotlin.random.Random

class Solution(w: IntArray) {
    private val prefixSums = IntArray(w.size) { 0 }
    private var total = 0


    init {
        prefixSums[0] = w[0]
        for (i in 1..w.lastIndex) {
            prefixSums[i] = prefixSums[i - 1] + w[i]
        }
        total = prefixSums.last()
    }

    fun pickIndex(): Int {
        val target = Random.nextInt(total + 1)

        var left = 0
        var right = prefixSums.lastIndex
        while (left < right) {
            val mid = (right + left) / 2
            if (prefixSums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}