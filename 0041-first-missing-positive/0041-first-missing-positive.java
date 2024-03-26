class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}