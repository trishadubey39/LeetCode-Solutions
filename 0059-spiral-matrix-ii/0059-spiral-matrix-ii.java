class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        //int matrixtwo[][]=new int[n][n];
        int sr=0; int sc=0;
        int er=n-1;int ec=n-1;
      int i=1;
       while(i<=n*n && sr<=er && sc<=ec){
           //top
           for(int j=sc;j<=ec;j++){
               matrix[sr][j]=i;
               i++;
           }
           //right
           for(int j=sr+1;j<=er;j++){
               matrix[j][ec]=i;
               i++;
           }
          // bottom
           for(int j=ec-1;j>=sc;j--){
               matrix[er][j]=i;
               i++;
           }
           //left
           for(int j=er-1;j>sr;j--){
               matrix[j][sc]=i;
               i++;
           }
           sr++;
           er--;
           sc++;
           ec--;
       }
    
    return matrix;
       }
}