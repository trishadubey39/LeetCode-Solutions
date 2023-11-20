class Solution {
    public int jump(int[] nums) {
          int i =0;
            int counter=0;
            if(nums.length==1)
            return 0;
        while(i<nums.length)
        {//System.out.println(i);
        counter++;
            int range = i+nums[i];
            if(range>=nums.length-1)
             break;
            int max=0;
            int temp=0;
            for( int k=i+1;k<=range;k++)
            {
                if(nums[k]+k>=max)
                {
                    max=nums[k]+k;
                    temp=k;
                }
                //System.out.println("index->"+i+"maxrange->"+max);
            }
            i=temp;
        }
        return counter;
    }
}