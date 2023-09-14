class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        List<String> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src,new ArrayList<>());
            }
            map.get(src).add(dest);
        }
        for(String src : map.keySet()){
            Collections.sort(map.get(src));
        }
        dfs("JFK", map, n, ans);
        return ans;
    }   
    
    public boolean dfs(String src, Map<String,List<String>> map, int n, List<String> ans){
        ans.add(src);
        if(ans.size()==n+1){
            return true;
        }
        if(!map.containsKey(src)){
            ans.remove(ans.size()-1);
            return false;
        }
        for(int i=0;i<map.get(src).size();i++){
            String link = map.get(src).get(i);
            map.get(src).remove(i);
            if(dfs(link, map, n, ans)){
                return true;
            }else{
                map.get(src).add(i, link);
                continue;
            }
        }
        ans.remove(ans.size()-1);
        return false;
    }
}