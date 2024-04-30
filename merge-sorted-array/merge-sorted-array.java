class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = n+m-1;
        int i=m-1;
        int j=n-1;
        while (j>=0){
            if(i>=0 && nums1[i]>=nums2[j]){
                nums1[last] = nums1[i];
                i-=1;
            }else{
                nums1[last] = nums2[j];
                j-=1;
            }
            last-=1;
        }
    
    }
}