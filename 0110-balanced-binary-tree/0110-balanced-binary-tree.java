
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        // Base case: empty tree has height 0
        if (root == null) {
            return 0;
        }

        // Find left subtree height
        int leftHeight = height(root.left);

        // If left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Find right subtree height
        int rightHeight = height(root.right);

        // If right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check height difference
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return current node's height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
