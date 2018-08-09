package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

    private List[][] tmp;

    private List<TreeNode> generateTree(int start, int end){
        if (tmp[start][end] != null) return tmp[start][end];
        List<TreeNode> res = new ArrayList<>();
        if (start == end) res.add(new TreeNode(start));
        else if (start > end) res.add(null);
        else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = generateTree(start, i - 1);
                List<TreeNode> right = generateTree(i + 1, end);
                for (TreeNode aleft : left) {
                    for (TreeNode aright : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = aleft;
                        root.right = aright;
                        res.add(root);
                    }
                }
            }
        }
        tmp[start][end] = res;
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        tmp = new List[n + 2][n + 2];
        return generateTree(1, n);
    }


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Object t = new UniqueBinarySearchTreesII().generateTrees(3);
        System.out.println(t);
    }

}
