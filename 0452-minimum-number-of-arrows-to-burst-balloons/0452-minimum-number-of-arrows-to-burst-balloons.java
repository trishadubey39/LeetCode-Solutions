class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int[] prev = points[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if (currStartPoint > prevEndPoint) { // no overlap
                count++;
                prev = points[i];
            } else {
                // overlap
                prev[0] = Math.max(prevStartPoint, currStartPoint);
                prev[1] = Math.min(prevEndPoint, currEndPoint);
            }
        }

        return count;
    }
}