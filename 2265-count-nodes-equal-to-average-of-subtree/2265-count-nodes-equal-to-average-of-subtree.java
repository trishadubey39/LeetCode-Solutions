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
    class Pair{
     int sum;
     int num;
     Pair(int sum,int num){
           this.sum=sum;
           this.num=num;
     }
   }
   int count=0;
   public Pair sol(TreeNode root){
     if(root==null)return new Pair(0,0);
     Pair left= sol(root.left);
     Pair right=sol(root.right);
     int sum1=root.val+left.sum+right.sum;
     int num1=1+left.num+ right.num;
    
    if(root.val==sum1/num1)count++;
    return new Pair(sum1,num1);
   }
    public int averageOfSubtree(TreeNode root) {
        Pair left= sol(root);
        return count;
    }
}