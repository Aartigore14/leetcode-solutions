
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both trees are empty
        if (p == null && q == null) {
            return true;
        }

        // One tree is empty, or values differ
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        // Compare left and right subtrees
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
