class Solution {
    public int countSubMultisets(List<Integer> nums, int l, int r) {
         final int MOD = 1_000_000_007;
        TreeMap<Integer, Integer> numsMap = new TreeMap<>();
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        long[] cache = new long[r + 1];
        cache[0] = 1;

        for (Map.Entry<Integer, Integer> entry : numsMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            // preprocessing
            long[] pSum = Arrays.copyOf(cache, r + 1);
            for (int i = 0; i <= r; ++i) {
                if (i >= num) {
                    pSum[i] += pSum[i - num];
                    pSum[i] %= MOD;
                }
            }

            // update dp cache
            for (int i = r; i >= 0; --i) {
                if (num > 0) {
                    int j = i - (freq + 1) * num;
                    cache[i] = pSum[i] - (j >= 0 ? pSum[j] : 0);
                    cache[i] = Math.floorMod(cache[i], MOD);
                } else {
                    cache[i] *= freq + 1;
                    cache[i] %= MOD;
                }
            }
        }

        long res = 0;
        for (int i = l; i <= r; ++i) {
            res += cache[i];
            res %= MOD;
        }
        return (int) res;
    
    }

}