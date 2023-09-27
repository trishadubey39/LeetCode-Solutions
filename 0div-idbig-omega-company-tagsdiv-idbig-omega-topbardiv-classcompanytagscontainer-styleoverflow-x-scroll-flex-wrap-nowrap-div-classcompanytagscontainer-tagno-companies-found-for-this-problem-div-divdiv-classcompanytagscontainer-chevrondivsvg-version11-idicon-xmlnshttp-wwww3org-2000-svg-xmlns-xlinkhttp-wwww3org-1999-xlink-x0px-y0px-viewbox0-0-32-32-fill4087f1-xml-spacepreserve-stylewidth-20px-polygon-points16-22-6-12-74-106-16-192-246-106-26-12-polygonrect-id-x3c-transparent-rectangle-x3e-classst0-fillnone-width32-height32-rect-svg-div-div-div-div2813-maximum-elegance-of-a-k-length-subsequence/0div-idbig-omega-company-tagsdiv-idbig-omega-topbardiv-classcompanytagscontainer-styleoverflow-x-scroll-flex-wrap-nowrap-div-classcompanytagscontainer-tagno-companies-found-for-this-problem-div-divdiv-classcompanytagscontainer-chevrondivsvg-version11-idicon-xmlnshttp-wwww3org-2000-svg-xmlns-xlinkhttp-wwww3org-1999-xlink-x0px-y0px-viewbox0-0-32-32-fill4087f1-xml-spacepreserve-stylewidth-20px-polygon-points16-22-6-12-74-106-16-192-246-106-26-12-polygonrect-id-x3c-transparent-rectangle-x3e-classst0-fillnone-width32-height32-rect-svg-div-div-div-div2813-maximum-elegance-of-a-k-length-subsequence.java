class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        long ans = 0;
        Arrays.sort(items, (a,b)-> b[0]-a[0]);
        Set<Integer> categoriesSeen = new HashSet<>();
        List<Integer> duplicateCategories = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans += items[i][0];
            int currCat = items[i][1];
            if(categoriesSeen.contains(currCat)){
                duplicateCategories.add(items[i][0]);
            }else{
                categoriesSeen.add(currCat);
            }
        }
        long curr = ans;
        ans += 1L*categoriesSeen.size()*categoriesSeen.size();
        
        int n = items.length;
        for(int i=k;i<n;i++){
            int currCat = items[i][1];
            int currVal = items[i][0];
            
            if(categoriesSeen.contains(currCat)){
                continue;
            }
            if(duplicateCategories.size()==0){
                break;
            }
            curr += currVal - duplicateCategories.get(duplicateCategories.size()-1);
            duplicateCategories.remove(duplicateCategories.size()-1);
            categoriesSeen.add(currCat);
            ans = Math.max(ans, curr + 1L*categoriesSeen.size()*categoriesSeen.size());
        }
        return ans;        
    }
}