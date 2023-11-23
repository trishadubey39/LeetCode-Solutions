class Solution {
    private boolean isAirthmatic(int []nums, int l, int r){
        int []arr = new int[r-l+1];
        int idx=0;
        for(int i=l; i<=r; i++){
            arr[idx++] = nums[i];
        }

        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for(int i=1; i<arr.length-1; i++){
            if((arr[i+1]-arr[i]) != diff) return false;
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> list = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            list.add(isAirthmatic(nums, l[i], r[i]));
        }
        return list;
    }
}