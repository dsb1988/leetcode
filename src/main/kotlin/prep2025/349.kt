package prep2025

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val statsOne = mutableSetOf<Int>()
    nums1.forEach { n ->
        statsOne.add(n)
    }
    val statsTwo = mutableSetOf<Int>()
    nums2.forEach { n ->
        statsTwo.add(n)
    }
    return statsOne.intersect(statsTwo).toIntArray()
}