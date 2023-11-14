class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        //build tree/trie
        Node root = new Node("*");
        for(List<String> list : paths){
            insert(list,root);
        }
        //serialize all subtrees
        HashMap<String,List<Node>> trees = new HashMap();
        // trees : key-> serialized subtree
        // value-> root node of serialized subtree 
        serialize(root,trees);
        // mark all subtree with same structure 
        for(String key : trees.keySet()){
            if(trees.get(key).size()>1){
                for(Node node : trees.get(key)){
                    node.deleted = true;
                }
            }
        }
        List<List<String>> ans = new ArrayList();
        // get folders which are not deleted
        dfs(root,ans,new ArrayList());
        return ans;
    }
    private void insert(List<String> list , Node root){
        Node curr = root;
        for(String str : list){
            if(curr.children.get(str)==null) curr.children.put(str,new Node(str));
            curr = curr.children.get(str);
        }
    }
    private String serialize(Node curr,HashMap<String,List<Node>> trees){
        if(curr.children.size()==0) return ""+curr.str;
        String ans = "(";
        // note : not serializing current node 
        for(String key : curr.children.keySet()){
            ans = ans + key +"#"+serialize(curr.children.get(key),trees);
        }
        ans = ans+")";
        List<Node> list = trees.getOrDefault(ans,new ArrayList());
        list.add(curr);
        trees.put(ans,list);
        return ans;
    }
    private void dfs(Node curr,List<List<String>> ans,List<String> path){
        for(String key : curr.children.keySet()){
            if(curr.children.get(key).deleted==false){
                path.add(key);
                dfs(curr.children.get(key),ans,path);
            }
        }
        if(path.size()>0){
            List<String> list = new ArrayList();
            for(String str : path) list.add(str);
            ans.add(list);
            path.remove(path.size()-1);
        }
    }
}
class Node{
    String str;
    TreeMap<String,Node> children;
    boolean deleted;
    
    public Node(String str){
        this.str = str;
        this.children = new TreeMap();
    }
}