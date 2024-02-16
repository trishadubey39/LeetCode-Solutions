class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for(int i = 0;i<arr.length;i++){
            if(count.containsKey(arr[i])){
                count.put(arr[i], count.get(arr[i])+1);
            }else{
                count.put(arr[i], 1);
            }
        }
        int unique = count.size();

        int[] countArray = new int[100000];
        for(Integer key : count.keySet()) {
            int keyCount = count.get(key);
            countArray[keyCount]++;
        }

        for (int i = 1; i < 100000; i++) {
            if (countArray[i]!= 0) {
                int remove = k / i;
                if (remove == 0) {
                    break;
                } else {
                    remove = Math.min(remove, countArray[i]);
                    unique -= remove;
                    k -= remove * i;
                }
            }
        }
        return unique;
        
    }
}