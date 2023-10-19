class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words) map.put(w, map.getOrDefault(w,0)+1);

        int wordSize = words[0].length(), windowSize = words.length*wordSize;
        for(int i=0; i<=s.length()-windowSize; i++){
            int left=i; 
            HashMap<String, Integer> wordsSeen = new HashMap<>();

            for(int right=i; right<=i+windowSize-wordSize; right+=wordSize){
                String rightWord = s.substring(right, right+wordSize);
                if(!map.containsKey(rightWord)) break;
                wordsSeen.put(rightWord,wordsSeen.getOrDefault(rightWord,0)+1);
                if(wordsSeen.get(rightWord)>map.get(rightWord)) break;
                if(right==i+windowSize-wordSize) list.add(left);
            }
        }
        return list;
    }
}