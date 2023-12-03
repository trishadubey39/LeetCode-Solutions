class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        for (int n1:nums1
             ) {
            set1.add(n1);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n2:nums2
        ) {

            if(set1.contains(n2)) {
                set2.add(n2);
            }
        }

        int[] result = new int[set2.size()];
        int i =0;
        for (int x:set2
             ) {
            result[i] = x;
            i++;
        }

        return result;
    }
}