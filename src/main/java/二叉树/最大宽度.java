package 二叉树;

import domain.TreeNode;

import java.util.*;

public class 最大宽度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexEs = new LinkedList<>();
        queue.offer(root);
        indexEs.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int curIndex = indexEs.removeFirst();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    indexEs.add(curIndex * 2);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    indexEs.add(curIndex * 2 + 1);
                }
            }
            if (indexEs.size() >= 2) {
                res = Math.max(res, indexEs.getLast() - indexEs.getFirst() + 1);
            }
        }
        return res;
    }
}
