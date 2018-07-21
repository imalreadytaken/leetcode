package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Stack<TreeNode>[] s = new Stack[2];
        s[0] = new Stack<>();
        s[1] = new Stack<>();
        TreeNode tmp;
        int cur = 0, cnt = 0;
        s[0].push(root);
        double sum = 0;
        while (!s[cur].empty()){
            while (!s[cur].empty()){    // 循环弹出
                tmp = s[cur].pop();
                sum += tmp.val;
                cnt++;
                if (tmp.left != null) s[1-cur].push(tmp.left);
                if (tmp.right != null) s[1-cur].push(tmp.right);
            }
            res.add(sum / cnt);
            sum = cnt = 0;
            cur = 1 - cur;
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

