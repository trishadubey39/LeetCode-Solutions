class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int prev = groups[0];
        for(int i=1;i<groups.length;i++){
            if(prev != groups[i]){
                ans.add(words[i]);
                prev = groups[i];
            }
        }
        return ans;
    }
    

}