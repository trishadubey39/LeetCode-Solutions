class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ca = s.toCharArray();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(ca[i]) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}