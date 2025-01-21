package prep2025

fun main() {
    println(minNonZeroProduct(1))
    // 945196305
    println(minNonZeroProduct(30))
    // 138191773
    println(minNonZeroProduct(31))
    // 505517599
    println(minNonZeroProduct(32))
    // 112322054
    println(minNonZeroProduct(35))
    // 247773741
    println(minNonZeroProduct(54))
}

const val MOD = 1000_000_007L
fun minNonZeroProduct(p: Int): Int {
    if (p == 1) return 1
    fun modPow(num: Long, pow: Long, mod: Long = MOD): Long {
        if (num == 0L) return 0
        if (pow == 0L) return 1
        var base = num % mod
        var exp = pow
        var result = 1L
        while (exp > 0) {
            if (exp % 2 == 1L) {
                result = ((result % mod) * (base % mod)) % mod
            }
            base = ((base % mod) * (base % mod)) % mod
            exp /= 2
        }
        return result
    }

    // minProduct = maxValue * (maxValue - 1)^(2^p-1 - 1)
    val max = (1L shl p) - 1
    return (max % MOD * modPow((max - 1) % MOD, max / 2) % MOD).toInt()
}
