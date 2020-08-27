package 二叉树;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 层次遍历从底至顶 {
    public static void main(String[] args) {
        System.out.println(fun(TreeNode.getTree()));
    }

    private static List<List<Integer>> fun(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            current--;
            temp.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                next++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                next++;
            }
            if (current == 0) {
                res.addFirst(new ArrayList<>(temp));
                temp.clear();
                current = next;
                next = 0;
            }
        }
        return res;
    }
}
