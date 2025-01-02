package prep2024

fun main() {
    println("Search in Rotated Sorted Array")

    val arr1 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val arr2 = intArrayOf(0, 1, 2, 4, 5, 6, 7)
    val arr3 = intArrayOf(1)
    val arr4 = intArrayOf(4, 5, 6, 7, 8, 1, 2, 3)

    println(search(arr1, 0))
    println(search(intArrayOf(5, 1, 2, 3, 4), 1))
    println(search(arr3, 0))
    println(search(arr4, 8))
}

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) {
        return if (nums[0] == target) 0 else -1
    }

    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val middle = left + (right - left) / 2
        if (nums[middle] == target) {
            return middle
        }

        if (target > nums[middle]) {
            if (nums[middle] > nums[left]) {
                left = middle + 1
            } else {
                if (target <= nums[right]) {
                    left = middle + 1
                } else {
                    right = middle - 1
                }
            }
        } else {
            if (nums[middle] < nums[left]) {
                right = middle - 1
            } else {
                if (target >= nums[left]) {
                    right = middle - 1
                } else {
                    left = middle + 1
                }
            }
        }
    }

    return -1
}
