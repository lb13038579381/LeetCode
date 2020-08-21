package 二叉树;

import domain.TreeNode;

import java.util.HashMap;

public class 打家劫舍 {
    static HashMap<TreeNode,Integer> bubaohan = new HashMap<>();
    static HashMap<TreeNode,Integer> baohan = new HashMap<>();

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.left = i;
        System.out.println(fun(a));
    }

    private static int fun(TreeNode root) {
        dfs(root);
        return Math.max(bubaohan.getOrDefault(root,0),baohan.getOrDefault(root,0));
    }

    private static void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        baohan.put(root,bubaohan.getOrDefault(root.left,0) + bubaohan.getOrDefault(root.right,0));
        bubaohan.put(root, Math.max(baohan.getOrDefault(root.left,0),bubaohan.getOrDefault(root.left,0)) + Math.max(baohan.getOrDefault(root.right,0),bubaohan.getOrDefault(root.right,0)));
    }
}
