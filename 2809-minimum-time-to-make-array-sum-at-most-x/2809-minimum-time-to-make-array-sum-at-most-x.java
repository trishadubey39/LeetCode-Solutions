class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        Integer[] ind = new Integer[n];
        int s = 0, d = 0;
        for (int i = 0; i < n; ++i) {
            ind[i] = i;
            s += nums1.get(i);
            d += nums2.get(i);
        }
        if (s <= x) {
            return 0;
        }
        Arrays.sort(ind, (a, b) -> nums2.get(a) - nums2.get(b)); 
        int[] dp = new int[n + 1];
        int r = n + 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = Math.min(i, r - 1); j > 0; --j) {
                dp[j] = Math.max(dp[j], dp[j - 1] + nums2.get(ind[i - 1]) * j + nums1.get(ind[i - 1]));
                if (s + j * d - dp[j] <= x) {
                    r = j;
                }
            }
        }
        return r <= n ? r : -1;
    }
}