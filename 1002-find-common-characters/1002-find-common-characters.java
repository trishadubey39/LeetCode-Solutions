class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                if (map.containsKey(c) && map.get(c) > 0) {
                    tmp.put(c, tmp.getOrDefault(c, 0) + 1);
                    map.put(c, map.get(c) - 1);
                }
            }
            map = tmp;
            if (map.size() == 0)
                break;
        }
        List<String> res = new ArrayList<>();
        for (Character c : map.keySet()) {
            for (int k = 0; k < map.get(c); k++) {
                res.add("" + c);
            }
        }
        return res;
    }
}