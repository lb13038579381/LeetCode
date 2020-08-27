package 二叉树;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 和为k的路径 {
    public static void main(String[] args) {
        int k = 10;
        System.out.println(fun(TreeNode.getTree(), k));
    }

    private static List<List<Integer>> fun(TreeNode root, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(root, 0, k, cur, res);
        return res;
    }

    private static void dfs(TreeNode node, int curSum, int k, List<Integer> cur, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        cur.add(node.val);
        if (curSum == k && node.left == null && node.right == null) {
            res.add(new ArrayList<>(cur));
            return;
        }
        dfs(node.left, curSum, k, cur, res);
        dfs(node.right, curSum, k, cur, res);
        cur.remove(cur.size() - 1);
    }
}
