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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Find depth of left subtree
        int leftDepth = maxDepth(root.left);

        // Find depth of right subtree
        int rightDepth = maxDepth(root.right);

        // Return maximum depth + current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
