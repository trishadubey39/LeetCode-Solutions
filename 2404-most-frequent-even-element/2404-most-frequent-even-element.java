class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int v : nums) {
            if (v % 2 == 0) {
                ans.put(v, ans.getOrDefault(v, 0) + 1);
            }
        }
        int result = -1, mx = 0;
        for (var y : ans.entrySet()) {
            int x = y.getKey(), t = y.getValue();
            if (mx < t || (mx == t && result > x)) {
                mx = t;
                result = x;
            }
        }
        return result;
    }
}