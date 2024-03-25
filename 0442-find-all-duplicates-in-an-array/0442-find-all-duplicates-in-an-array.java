class Solution {
    public List<Integer> findDuplicates(int[] n) {
        List<Integer> res = new ArrayList();

        for (int i : n) {
            int index = Math.abs(i);
            if (n[index - 1] < 0) {
                res.add(index);
            }
            n[index - 1] *= -1;
        }

        return res;
    }
}