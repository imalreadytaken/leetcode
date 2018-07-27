package hard;

/**
 * 递归函数中，记录左右子树加根，但返回时返回根加大的那个子树
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        _maxPathSum(root);
        return max;
    }

    private int _maxPathSum(TreeNode root) {
        int left = 0, right = 0;
        if (root.left != null) left = _maxPathSum(root.left);
        if (root.right!= null) right = _maxPathSum(root.right);
        if (left > 0) root.val += left;
        if (right > 0) root.val += right;
        max = Math.max(max, root.val);
        return root.val - Math.max(Math.min(left, right), 0);
    }

}
