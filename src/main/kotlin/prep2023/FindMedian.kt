package prep2023

import kotlin.math.ceil

fun main() {
    println(findMedian(arrayOf(5, 3, 4, 2, 1)))
}

fun findMedian(arr: Array<Int>): Int {
    // Write your code here
    arr.sort()
    val middleIndex = ceil((arr.size / 2f))
    return middleIndex.toInt()
}
