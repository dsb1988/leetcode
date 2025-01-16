package prep2025

fun main() {
    val one = intArrayOf(1, 2, 3, 0, 0, 0)
    val two = intArrayOf(2, 5, 6)
    merge(one, 3, two, 3)
    println(one.contentToString())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1

    for (k in nums1.lastIndex downTo 0) {
        if (i >= 0 && (j < 0 || nums1[i] >= nums2[j])) {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
    }
}