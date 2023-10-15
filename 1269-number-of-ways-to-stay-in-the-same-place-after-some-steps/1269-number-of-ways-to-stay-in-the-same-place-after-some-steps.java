class Solution {
    public int numWays(int steps, int arrLen) {
        HashMap<String,Long> memo=new HashMap();
        
        return (int)solve(steps, arrLen, 0,memo)% 1000000007;

    }
    
    public long solve(int steps, int arrLen, int currIndex,HashMap<String,Long> memo){
        if(currIndex==0 && steps==0) return 1;
        if(currIndex < 0|| currIndex >= arrLen || steps <=0) 
        return 0;

         String currentKey=String.valueOf(currIndex)+"@"+String.valueOf(steps);
         if(memo.containsKey(currentKey))
              return memo.get(currentKey);

          long stay=solve(steps-1,arrLen,currIndex,memo);
          long left=solve(steps-1,arrLen,currIndex-1,memo);
          long right=solve(steps-1,arrLen,currIndex+1,memo);

          long answer=(stay+left+right)% 1000000007;
          memo.put(currentKey,answer);
          return memo.get(currentKey);
    }
}