class Solution {
    public void setZeroes(int[][] A) 
    {
       
       int row=A.length;
        int col=A[0].length;
        int x=1,y=1;
        for(int i=0;i<col;i++){
            if(A[0][i]==0){
                x=0;
               break;}
        } 
        for(int i=0;i<row;i++){
            if(A[i][0]==0){
                y=0;
               break;}
        } 
        //label the top row and column with 0 if there are any 0s
        for(int i=1;i<row;i++)
            for(int j=1;j<col;j++)
            {
                if(A[i][j]==0)
                {
                    A[i][0]=0;
                    A[0][j]=0;
                }
            }
        
       for(int j=1;j<col;j++)
        {
           if(A[0][j]==0)
           {
               for(int i=1;i<row;i++)
                   A[i][j]=0;
           }
        }
        
        for(int i=1;i<row;i++)
        {
            if(A[i][0]==0)
            {
                for(int j=0;j<col;j++)
                    A[i][j]=0;
            }
        }
        if(x==0)
        for(int i=0;i<col;i++)
            A[0][i]=0;
               
        if(y==0)
        for(int i=0;i<row;i++)
            A[i][0]=0;

        System.gc();
        //return A;
    }
}