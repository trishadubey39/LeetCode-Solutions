class Solution {
    public int trap(int[] height) {
        int n= height.length;

        //Creating leftmax array for storing max height at left
        int [] leftmax = new int[n];
        leftmax[0]= height[0];
        for (int i=1; i<n; i++){
           leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }

        //Creating rightmax array for storing max height at right 
        int [] rightmax = new int[n];
        rightmax[n-1]= height[n-1];
        for (int i=n-2; i>=0; i--){
           rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        //Finding Water level by finding Minimum of leftmax and rightmax
        // Calculating Trapped water using formula - trappedwater = waterlevel- height[i];
        int waterlevel=0;
        int trappedwater=0;
        for (int i=0; i<n; i++){
           waterlevel= Math.min( leftmax[i],rightmax[i]);
           trappedwater += waterlevel- height[i];
        }

        return trappedwater;
    }
}