public class Solution {
  public int maxPoints(int[][] points) {
        int res = 2;
        int n = points.length;
        if (n == 1)
            return 1;
            
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int extra = 2;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    int p1 = points[i][0] * (points[j][1] - points[k][1]);// x1(y2 – y3)
                    int p2 = points[j][0] * (points[k][1] - points[i][1]);// x2(y3 – y1)
                    int p3 = points[k][0] * (points[i][1] - points[j][1]);// x3(y1 – y2)
                    if (p1 + p2 + p3 == 0)
                        extra++;
                }

                res = Math.max(res, extra);
            }
        }
        return res;
  }
}

