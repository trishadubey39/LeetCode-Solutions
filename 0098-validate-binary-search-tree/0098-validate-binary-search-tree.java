/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> ls= new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        isValidBST(root.left);
        ls.add(root.val);
        isValidBST(root.right);
        return isValid(ls);
    }
    private boolean isValid(ArrayList<Integer> ls){
        if(ls.size() == 1) return true;
        for(int i=1;i<ls.size();i++){
            if(ls.get(i)<=ls.get(i-1)) return false;
        }
        return true;
    }
}