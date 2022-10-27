fun arrangeCoins(n: Int): Int {
    var coins = n
    for (i in 1..n) {
        coins -= i
        if (coins < 0) {
            return i - 1
        } else if (coins == 0) {
            return i
        }
    }
    return 0
}

