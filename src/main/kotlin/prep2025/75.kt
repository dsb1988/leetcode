package prep2025

fun main() {

}

fun sortColors(nums: IntArray): Unit {
    var red = 0
    var white = 0
    var blue = 0
    nums.forEach { n ->
        when (n) {
            0 -> red++
            1 -> white++
            2 -> blue++
        }
    }
    var i = 0
    while (red > 0) {
        nums[i] = 0
        red--
        i++
    }
    while (white > 0) {
        nums[i] = 1
        white--
        i++
    }
    while (blue > 0) {
        nums[i] = 2
        blue--
        i++
    }
}
// 0 - red
// 1 - white
// 2 - blue