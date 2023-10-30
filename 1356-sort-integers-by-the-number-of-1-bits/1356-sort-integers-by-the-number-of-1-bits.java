class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparing(x -> Integer.toBinaryString((Integer) x).replaceAll("[^1]", "").length()).thenComparing(x -> (Integer) x)).mapToInt(x -> x).toArray();
    }
}