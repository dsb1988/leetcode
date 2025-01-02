package prep2024

fun main() {

}

fun containsDuplicate(nums: IntArray): Boolean {
    val stats = hashMapOf<Int, Int>()
    nums.forEach { num ->
        if (stats.containsKey(num)) {
            return true
        } else {
            stats[num] = 1
        }
    }
    return false
}