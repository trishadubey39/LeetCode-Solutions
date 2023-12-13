class Solution {
    public int numSpecial(int[][] mat) {
        int result = 0;
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                if (mat[i][j] == 1)
                {
                    int sumx = 0;
                    int sumy = 0;
                    for (int m = 0; m < mat[i].length; m++)
                    {
                        sumx += mat[i][m];
                    }
                    for (int k = 0; k < mat.length; k++)
                    {
                        sumy += mat[k][j];
                    }
                    if (sumx == 1 && sumy == 1)
                    {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}