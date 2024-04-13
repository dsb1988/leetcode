package prep2023

fun main() {

}

fun countingSort(arr: Array<Int>): Array<Int> {
    // Write your code here
    val max = arr.maxOf { it }
    val result = Array(max + 1) { 0 }
    for (a in arr) {
        result[a]++
    }
    return result
}