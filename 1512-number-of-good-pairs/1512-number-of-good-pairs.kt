class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        var ans = 0
        val cnt = IntArray(101)
        
        for (i in nums.indices) {
          ans += cnt[nums[i]]++
        }
        
        return ans
    }
}