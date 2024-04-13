package prep2023

fun main() {
    val billOne = intArrayOf(5,5,5,10,20)
    lemonadeChange(billOne)
    val billTwo = intArrayOf(5,5,10,10,20)
    lemonadeChange(billTwo)
}

fun lemonadeChange(bills: IntArray): Boolean {
    var fives = 0
    var tens = 0
    var twenties = 0
    for (bill in bills) {
        when(bill) {
            5 -> {
                fives++
            }
            10 -> {
                if (fives > 0) {
                    fives--
                    tens++
                } else {
                    return false
                }
            }
            20 -> {
                if (tens > 0 && fives > 0) {
                    tens--
                    fives--
                    twenties++
                } else if (fives >= 3) {
                    fives -= 3
                    twenties++
                } else {
                    return false
                }
            }
        }
    }

    return true
}
