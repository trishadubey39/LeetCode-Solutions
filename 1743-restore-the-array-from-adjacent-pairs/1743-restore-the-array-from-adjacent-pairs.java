class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int[] pair : adjacentPairs) {
            if (pair[0] < minNum)  minNum = pair[0];
            if (pair[0] > maxNum)  maxNum = pair[0];
            if (pair[1] < minNum)  minNum = pair[1];
            if (pair[1] > maxNum)  maxNum = pair[1];
        }
        minNum--;   
        
        final int[] links1 = new int[maxNum - minNum + 1];
        final int[] links2 = new int[maxNum - minNum + 1];
        for (int[] pair : adjacentPairs) {
            int u = pair[0] - minNum;   
            int v = pair[1] - minNum;
            if (links1[u] == 0)  links1[u] = v;  else  links2[u] = v;
            if (links1[v] == 0)  links1[v] = u;  else  links2[v] = u;
        }
        
        
        int num = 0;
        for (num = links1.length - 1; num > 0; num--) 
            if (links1[num] != 0 && links2[num] == 0)
                break;
        
    
        int[] nums = new int[adjacentPairs.length + 1];
        int prev = 0;
        int idx = 0;
        while (num != 0) {
            nums[idx++] = num + minNum;
            int next = (links1[num] == prev) ? links2[num] : links1[num];
            prev = num;
            num = next;
        }
        
        return nums;
    }
}