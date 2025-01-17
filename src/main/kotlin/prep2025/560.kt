package prep2025

fun main() {
    println(subarraySum(intArrayOf(1, -1, 0), 0))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var result = 0
    val prefixSum = hashMapOf<Int, Int>()
    prefixSum[0] = 1
    var curSum = 0
    nums.forEach { n ->
        curSum += n
        val diff = curSum - k
        result += prefixSum.getOrDefault(diff, 0)

        prefixSum[curSum] = prefixSum.getOrDefault(curSum, 0) + 1
    }
    return result
}