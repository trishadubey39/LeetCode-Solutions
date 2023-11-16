class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        
        for (String num : nums) {
            set.add(num);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0'); // Initialize with '0'
        }
        
        String candidate = sb.toString();
        
        while (set.contains(candidate)) {
            candidate = generateNext(candidate);
        }
        
        return candidate;
    }

    private String generateNext(String str) {
        char[] chars = str.toCharArray();
        int i = chars.length - 1;
        
        while (i >= 0 && chars[i] == '1') {
            chars[i] = '0';
            i--;
        }
        
        if (i >= 0) {
            chars[i] = '1';
        }
        
        return new String(chars);
    }
}