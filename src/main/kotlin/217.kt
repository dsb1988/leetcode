fun containsDuplicate(nums: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (n in nums) {
        if (set.contains(n)) {
            return true
        } else {
            set.add(n)
        }
    }
    return false
}