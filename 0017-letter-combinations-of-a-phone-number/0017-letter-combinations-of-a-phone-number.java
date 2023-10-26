class Solution {
    ArrayList<String> arl = new ArrayList();
    String[] arr =  {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return arl;
        }
        helper(0,new StringBuilder(""),digits);
        return arl;
    }


    void helper(int index, StringBuilder s,String digits){
        // System.out.println(s);
        if(s.length() == digits.length()){
            //System.out.println(s);
            arl.add(new String(s));
            return;
        }
        int a = digits.charAt(index) - '0';
        for(int i = 0 ; i < arr[a].length() ; i++){
        s.append((arr[a].charAt(i)));
        helper(index+1,s,digits);
        s.deleteCharAt(s.length()-1);

        }
    }
}