class Solution {
    int m, n;
    int M = 1000;
    public boolean possiblyEquals(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        return solve(0, 0, M, s1, s2, new boolean[s1.length()+1][s2.length()+1][2*M]);
    }

    private boolean solve(int i, int j, int bal, String A, String B, boolean[][][] seen){
        if (i == A.length() && j == B.length()){
            return bal == M;
        }
        if (i == A.length() && !isD(B.charAt(j)) && bal <= M){
            return false;
        }
        if (j == B.length() && !isD(A.charAt(i)) && bal >= M){
            return false;
        }
        if (i < m && j < n && !isD(A.charAt(i)) && !isD(B.charAt(j)) && A.charAt(i) != B.charAt(j) && bal == M){
            return false;
        }
        if (seen[i][j][bal]){
            return false;
        }
        seen[i][j][bal]=true;
        if (i == m && j < n && !isD(B.charAt(j)) && bal > M && solve(i, j+1, bal-1, A, B, seen)){
            return true;
        }
        if (i < m && j == n && !isD(A.charAt(i)) && bal < M && solve(i+1, j, bal+1, A, B, seen)){
            return true;
        }
        if (i < m && j < n && A.charAt(i) == B.charAt(j) && bal == M && solve(i+1, j+1, bal, A, B, seen)){
            return true;
        }
        if (i < m && j < n && !isD(A.charAt(i)) && !isD(B.charAt(j)) && bal > M && solve(i, j+1, bal-1, A, B, seen)){
            return true;
        }
        if (i < m && j < n && !isD(A.charAt(i)) && !isD(B.charAt(j)) && bal < M && solve(i+1, j, bal+1, A, B, seen)){
            return true;
        }
        if (i < m && isD(A.charAt(i))){
            int k = i;
            while(k < m && isD(A.charAt(k))){
                k++;
            }
            for (int b : gen(A.substring(i, k))){
                if (solve(i+len(b),j,bal+b,A,B,seen)){
                    return true;
                }
            }
        }
        if (j < n && isD(B.charAt(j))){
            int k = j;
            while(k < n && isD(B.charAt(k))){
                k++;
            }
            for (int b : gen(B.substring(j, k))){
                if (solve(i,j+len(b),bal-b,A,B,seen)){
                    return true;
                }
            }
        }
        return false;
    }

    private List<Integer> gen(String s){
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++){
            ans.add(Integer.parseInt(s.substring(0, i)));
        }
        return ans;
    }

    private int len(int n){
        if (n < 10){
            return 1;
        }else if (n < 100){
            return 2;
        }else{
            return 3;
        }
    }

    private boolean isD(char ch){
        return Character.isDigit(ch);
    }
}