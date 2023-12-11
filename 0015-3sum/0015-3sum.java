class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                    while(k>j && nums[k]==nums[k+1])k--;
                    while(k>j && nums[j]==nums[j-1])j++;
                }
            }
        }
        return ans;
    }
}