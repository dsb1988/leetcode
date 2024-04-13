package prep2023

fun main() {
    bonAppetit(arrayOf(3, 10, 2, 9), 1, 12)
}

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
    // Write your code here
    var result = "Bon Appetit"
    // k - did not eat
    // b - charged amount
    val total = bill.filterIndexed { index, e -> index != k }.sum()
    if (total / 2 != b) {
        result = "${b - total / 2}"
    }
    println(result)
}