class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        recurse(s, ans, 0, "", 0);
        return ans;
    }
    private void recurse(String curr, List<String> ans, int index, String temp, int count) {
        if (count > 4)
            return;
        if (count == 4 && index == curr.length())
            ans.add(temp);
        for (int i=1; i<4; i++) {
            if (index+i > curr.length()){
                break;
            }
            String s = curr.substring(index,index+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)){
                continue;
            }
            recurse(curr, ans, index+i, temp+s+(count==3?"" : "."), count+1);
        }
    }
}