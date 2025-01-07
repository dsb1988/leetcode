package prep2024

fun main() {
    val one = intArrayOf(2, 7, 11, 15)
    println(twoSumSorted(one, 9).contentToString())
}

fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        when {
            sum < target -> left++
            sum > target -> right--
            else -> return intArrayOf(left + 1, right + 1)
        }
    }
    return intArrayOf()
}