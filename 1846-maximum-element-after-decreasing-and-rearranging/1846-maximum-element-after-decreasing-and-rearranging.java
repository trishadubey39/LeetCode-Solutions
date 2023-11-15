class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int size=arr.length;
        arr[0]=1;
        int max=1;
        for(int i=1;i<size;i++){
             int diff=Math.abs(arr[i]-arr[i-1]);
              if(diff!=1){
                if(arr[i]>arr[i-1]) arr[i]=arr[i-1]+1;
               // else if(arr[i]==arr[i-1]) arr[i]-=1;
                }
            
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}