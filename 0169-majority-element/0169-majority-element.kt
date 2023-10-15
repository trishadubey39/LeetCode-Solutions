class Solution {
    fun majorityElement(nums: IntArray): Int {
        var result = nums[0]
        var count=0
        for(i in nums){
            if(i==result){
                count++
            }else{
                count--
                if(count==0){
                    result = i
                    count =1
                }
                
            }
        }
        return result
    }
}