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
    static int maxd;
    public int diameterOfBinaryTree(TreeNode root) {
        maxd=0;
        computeheight(root);
        return maxd;
    }
    private int computeheight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=computeheight(root.left);
        int right=computeheight(root.right);
        maxd=Math.max(maxd,left+right);
        return 1+Math.max(left,right);
    } 
}
