package prep2025

fun main() {
    println(maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).contentToString())
    println(maxSlidingWindow(intArrayOf(1, -1), 1).contentToString())
    println(maxSlidingWindow(intArrayOf(7, 2, 4), 2).contentToString())
}

// decreasing monotonic deque
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val result = mutableListOf<Int>()
    val deque = ArrayDeque<Int>()
    var left = 0
    var right = 0
    while (right <= nums.lastIndex) {
        while (deque.isNotEmpty() && nums[deque.last()] < nums[right]) {
            deque.removeLast()
        }
        deque.addLast(right)
        if (left > deque.first()) {
            deque.removeFirst()
        }
        if (right - left + 1 >= k) {
            result.add(nums[deque.first()])
            left++
        }
        right++
    }
    return result.toIntArray()
}