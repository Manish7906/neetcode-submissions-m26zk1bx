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

    public int kthSmallest(TreeNode root, int k) {

        // Step 1: Store inorder traversal
        List<Integer> inOrderList = new LinkedList<>();
        helper(root, inOrderList);

        // Step 2: Return kth smallest element (1-indexed)
        return inOrderList.get(k - 1);
    }

    // Inorder Traversal Function
    private void helper(TreeNode node, List<Integer> inOrderList) {

        if (node == null)
            return;

        helper(node.left, inOrderList);     // Left
        inOrderList.add(node.val);          // Root
        helper(node.right, inOrderList);    // Right
    }
}
