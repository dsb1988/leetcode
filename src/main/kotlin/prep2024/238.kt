package prep2024

fun main() {
    println(productExceptSelf(intArrayOf(2, 3, 4, 5)).contentToString())
}

fun productExceptSelf(nums: IntArray): IntArray {
    val products = IntArray(nums.size) { 1 }
    for (i in 1 until nums.size) {
        products[i] = nums[i - 1] * products[i - 1]
    }
    var right = nums.last()
    for (i in nums.lastIndex - 1 downTo 0) {
        products[i] *= right
        right *= nums[i]
    }
    return products
}