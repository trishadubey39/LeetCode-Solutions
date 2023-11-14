class Solution {
    public boolean isNumber(String s) {
        boolean digitseen = false, eseen = false, dotseen = false;
        int countPlusMinus = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            // case 1 ---  digit
            if(Character.isDigit(ch)){ // if it is digit
                digitseen = true; // make it true
            }
            //case 2 --- minus/plus
            else if(ch == '+' || ch == '-'){
                if(countPlusMinus == 2){ // if already 2 +/- seen
                    return false;
                }
                if(i>0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')){ // if +/- comes in middle and i-1 position if there is not e/E
                    return false;
                }

                if(i == s.length()-1){ // if +/- comes at last position
                    return false;
                }
                countPlusMinus++; // increment it by 1
            }
            //case 3 --- dot
            else if(ch == '.'){
                if(eseen || dotseen){  // if dot comes after e/E or already 1 dot seen
                    return false;
                }
                if(i == s.length() -1 && !digitseen){ // if there is single dot
                    return false;
                }
                dotseen = true;  // make it true
            }
            //case 4 --- e/E
            else if(ch == 'e' || ch == 'E'){
                if(eseen || !digitseen || i == s.length()-1){ // if e/E already seen or e/E comes in starting or e/E comes at the end
                    return false;
                }
                eseen = true;  // make it true
            }
            else{
                return false;  // if any other character comes then it will be invalid
            }
        }
        return true;  // finally return true
    
    }
}