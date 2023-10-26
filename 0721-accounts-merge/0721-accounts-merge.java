class Solution {
    class UnionFind {
        int[] parents;
        
        public UnionFind(int num) {
            parents = new int[num];
            Arrays.fill(parents, -1);
        }
        
        public void union(int a, int  b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA == rootB) {
                return;
            }
            
            if (parents[rootA] > parents[rootB]) {
                parents[rootB] += parents[rootA];
                parents[rootA] = rootB;
            } else {
                parents[rootA] += parents[rootB];
                parents[rootB] = rootA;
            }
        }
        
        public int find(int a) {
            if (parents[a] < 0) {
                return a;
            }
            
            int parent = find(parents[a]);
            parents[a] = parent;
            return parent;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        
        Map<String, Integer> emailToId = new  HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);
                
                
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }
        

        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String key : emailToId.keySet()) {
            int root = uf.find(emailToId.get(key));
            
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }
            
            idToEmails.get(root).add(key);
        }
        
        
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergedDetails.add(emails);
        }
        
        return mergedDetails;
    }
}