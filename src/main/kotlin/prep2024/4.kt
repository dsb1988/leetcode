package prep2024

import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val targetSize = nums1.size + nums2.size
    val half = targetSize / 2
    val a = if (nums1.size < nums2.size) nums1 else nums2
    val b = if (nums1.size < nums2.size) nums2 else nums1
    var left = 0
    var right = a.lastIndex
    while (true) {
        val i = floor((left + right) / 2.0).toInt()
        val j = half - i - 2
        val aLeft = if (i >= 0) a[i] else Integer.MIN_VALUE
        val aRight = if (i + 1 < a.size) a[i + 1] else Integer.MAX_VALUE
        val bLeft = if (j >= 0) b[j] else Integer.MIN_VALUE
        val bRight = if (j + 1 < b.size) b[j + 1] else Integer.MAX_VALUE

        if (aLeft <= bRight && bLeft <= aRight) {
            // partition found
            return if (targetSize % 2 == 0) {
                (max(aLeft, bLeft) + min(aRight, bRight)) / 2.0
            } else {
                min(aRight, bRight).toDouble()
            }
        } else if (aLeft > bRight) {
            // move partition left
            right = i - 1
        } else {
            // move partition right
            left = i + 1
        }
    }
}