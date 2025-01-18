package prep2025

fun main() {
    println(maxCount(intArrayOf(1, 6, 5), 5, 6))
    println(maxCount(intArrayOf(11), 7, 50))
}

fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
    val bannedSet = mutableSetOf<Int>()
    banned.forEach { e -> bannedSet.add(e) }
    val nums = mutableSetOf<Int>()
    var sum = 0
    var i = 1
    do {
        if (!bannedSet.contains(i)) {
            sum += i
            if (sum > maxSum) {
                break
            }
            nums.add(i)
        }
        i++
    } while (sum <= maxSum && i <= n)
    return if (nums.isNotEmpty()) nums.size else 0
}