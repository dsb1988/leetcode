package prep2025

fun main() {
    println(countPairs(intArrayOf(1, 2, 3, 4, 5), 2))
}

fun countPairs(nums: IntArray, k: Int): Long {
    fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)

    var result = 0L
    val gcds = hashMapOf<Int, Long>()
    nums.forEach { n ->
        val divisor = gcd(n, k)
        gcds[divisor] = gcds.getOrDefault(divisor, 0) + 1
    }
    for (i in gcds.keys) {
        for (j in gcds.keys) {
            if ((i.toLong() * j.toLong()) % k == 0L) {
                if (i < j) {
                    val left = gcds[i] ?: 0
                    val right = gcds[j] ?: 0
                    result += left * right
                } else if (i == j) {
                    val count = gcds[i] ?: 0
                    result += count * (count - 1).floorDiv(2)
                }
            }
        }
    }
    return result
}