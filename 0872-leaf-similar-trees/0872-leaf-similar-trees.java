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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> nodeList1 = new ArrayList<>();
        List<Integer> nodeList2 = new ArrayList<>();
        findLeafDfs(root1, nodeList1);
        findLeafDfs(root2, nodeList2);
        return nodeList1.equals(nodeList2);
    }

    private void findLeafDfs(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            nodeList.add(node.val);
        } else {
            findLeafDfs(node.left, nodeList);
            findLeafDfs(node.right, nodeList);
        }
    }
}