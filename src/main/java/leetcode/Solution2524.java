package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2524 {

    public final int MODULO = 1000_000_007;

    public static void main(String[] args) {
        Solution2524 sol = new Solution2524();

        System.out.println(sol.maxFrequencyScore(new int[]{1, 1, 1, 2, 1, 2}, 3));
    }

    private long powMod(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = result * base % MODULO;
            }
            base = base * base % MODULO;
            exponent >>= 1;
        }
        return result;
    }

    public int maxFrequencyScore(int[] nums, int k) {
        HashMap<Integer, Integer> stats = new HashMap<>();
        for (int i = 0; i < k; i++) {
            stats.put(nums[i], stats.getOrDefault(nums[i], 0) + 1);
        }

        long current = 0;
        for (Map.Entry<Integer, Integer> entry : stats.entrySet()) {
            current = (current + powMod(entry.getKey(), entry.getValue())) % MODULO;
        }
        long result = current;
        for (int i = k; i < nums.length; i++) {
            int prev = nums[i - k];
            int next = nums[i];

            if (prev != next) {
                int prevFreq = stats.getOrDefault(prev, 0);
                if (prevFreq > 1) {
                    current -= (prev - 1) * powMod(prev, prevFreq - 1) % MODULO;
                } else {
                    current -= prev;
                }

                int nextFreq = stats.getOrDefault(next, 0);
                if (nextFreq > 0) {
                    current += (next - 1) * powMod(next, nextFreq) % MODULO;
                } else {
                    current += next;
                }

                current = (current + MODULO) % MODULO;

                stats.put(prev, prevFreq - 1);
                stats.put(next, nextFreq + 1);

                result = Math.max(result, current);
            }
        }
        return (int) result;
    }
}
