package prep2025

fun main() {
    println(minSwaps("[[[]]]][][]][[]]][[["))
}

fun minSwaps(s: String): Int {
    var opening = 0
    var closing = 0
    val arr = s.toCharArray()
    var swaps = 0
    var left = 0
    var right = arr.lastIndexOf('[')
    while (left < right) {
        if (arr[left] == '[') {
            opening++
        } else {
            closing++
            if (closing > opening) {
                arr[left] = '['
                arr[right] = ']'
                while (right > left && arr[right] != '[') {
                    right--
                }
                opening++
                closing--
                swaps++
            }
        }
        left++
    }
    return swaps
}