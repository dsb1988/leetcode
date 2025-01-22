package prep2025

fun main() {
    println(maxSumRangeQuery(intArrayOf(1, 2, 3, 4, 5), arrayOf(intArrayOf(1, 3), intArrayOf(0, 1))))
}


fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
    val MOD = 1000_000_007

    // build diff array
    val diffArray = IntArray(nums.size + 1) { 0 }
    requests.forEach { r ->
        val start = r[0]
        val end = r[1]
        diffArray[start] += 1
        diffArray[end + 1] -= 1
    }

    // prefix sum
    for (i in 1..diffArray.lastIndex) {
        diffArray[i] += diffArray[i - 1]
    }

    nums.sortDescending()
    diffArray.sortDescending()

    var result = 0L
    for (i in nums.indices) {
        result += diffArray[i] * nums[i]
    }

    return (result % MOD).toInt()
}