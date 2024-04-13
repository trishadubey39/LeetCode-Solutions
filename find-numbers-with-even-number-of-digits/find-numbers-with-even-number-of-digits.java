class Solution {
    public int findNumbers(int[] nums) {
        int count =0;
        for(int i : nums){
            String s = i+"";
            if((s.length())%2 ==0){
                count ++;
            }
        }
        return count;
    }
}