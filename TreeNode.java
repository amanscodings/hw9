public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        // Test cases
        TreeNode p1 = root.left.left; // Node with value 1
        TreeNode q1 = root.left; // Node with value 3
        TreeNode p2 = root.left; // Node with value 3
        TreeNode q2 = root.right.left; // Node with value 5

        // Output for test cases
        System.out.println(solution.lowestCommonAncestor(root, p1, q1).val); // Output: 3
        System.out.println(solution.lowestCommonAncestor(root, p2, q2).val); // Output: 4
    }
}