package prep2025;

public class Solution1969 {
    final int MOD = 1000_000_007;

    public static void main(String[] args) {
        Solution1969 sol = new Solution1969();
        System.out.println(sol.minNonZeroProduct(30));
        System.out.println(sol.minNonZeroProduct(31));
    }

    public long modPow(long num, long power) {
        if (power == 0) return 1;
        long base = num % MOD;
        long exp = power;
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = ((result % MOD) * (base % MOD)) % MOD;
            }
            base = ((base % MOD) * (base % MOD)) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public long minNonZeroProduct(int p) {
        if (p == 1) return 1;
        long max = (1L << p) - 1;
        return (max % MOD) * modPow((max - 1) % MOD, max / 2) % MOD;
    }
}
