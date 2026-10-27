
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        // Step 1: Visit Left
        inorder(root.left, result);

        // Step 2: Visit Root
        result.add(root.val);

        // Step 3: Visit Right
        inorder(root.right, result);
    }
}
