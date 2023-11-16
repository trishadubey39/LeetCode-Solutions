class Solution {
    private int solve(int col,int n,boolean[] rc,boolean[] udc,boolean[] ldc)
    {
        if (col==n)
            return 1;

        int cnt=0;
        for (int row=0;row<n;row++)
        {
            if (!rc[row] && !ldc[row+col] && !udc[n-1+col-row])
            {
                rc[row]=true;
                ldc[row+col]=true;
                udc[n-1+col-row]=true;

                cnt+=solve(col+1,n,rc,udc,ldc);

                rc[row]=false;
                ldc[row+col]=false;
                udc[n-1+col-row]=false;
            }
        }

        return cnt;
    }

    public int totalNQueens(int n) {
        int ans=0;

        boolean[] rc=new boolean[n]; //row check
        boolean[] udc=new boolean[2*n-1]; //upper diagonal check
        boolean[] ldc=new boolean[2*n-1]; //lower diagonal check

        ans=solve(0,n,rc,udc,ldc);
        return ans;
    }
}