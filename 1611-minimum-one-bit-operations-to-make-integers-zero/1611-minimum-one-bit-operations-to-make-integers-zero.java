class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0)
            return 0;
        int a = 1;
        while (a * 2 <= n)
            a <<= 1;
        return minimumOneBitOperations(n ^ (a | a >> 1))+ a;
    }
}