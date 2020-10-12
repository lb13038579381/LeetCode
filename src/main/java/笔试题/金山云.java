package 笔试题;
import domain.TreeNode;
import 二叉树.二叉树1;

import java.util.*;

public class 金山云 {
    public static void main(String[] args) {
        //3 5 6 -1 -1 2 7 -1 -1 4 -1 -1 1 9 -1 -1 8 -1 -1
        String s = "3 5 6 -1 -1 2 7 -1 -1 4 -1 -1 1 9 -1 -1 8 -1 -1";
        String[] ss = s.split(" ");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        TreeNode root = helper(nums);
        System.out.println(root);
        System.out.println(find(root, 5, 1).val);
    }

    static int start = -1;

    private static TreeNode helper(int[] nums) {
        start++;
        if (nums[start] != -1) {
            TreeNode cur = new TreeNode(nums[start]);
            cur.left = helper(nums);
            cur.right = helper(nums);
            return cur;
        }
        return null;
    }

    public static TreeNode find(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, 1);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}