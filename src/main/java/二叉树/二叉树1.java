package 二叉树;

import domain.ListNode;
import domain.TreeNode;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: lb
 * @time: 2020/7/18 3:38 下午
 */
public class 二叉树1 {
    public static void main(String[] args) {

        /*
                1
            2       3
          4       5   6
        7   8   9
         */
//        System.out.println(先序(a));
//        System.out.println(中序(a));
//        System.out.println(后序(a));
//        System.out.println(层次(a));
//        System.out.println(sumPath(a, 15));
//        int[] pre = {1, 2, 4, 7, 8, 3, 5, 9, 6};
//        int[] mid = {7, 4, 8, 2, 1, 9, 5, 3, 6};
//        System.out.println(先中重建二叉树(pre, mid));
//        System.out.println(层次(镜像二叉树(a)));
//        System.out.println(是否为镜像二叉树(a));
//        System.out.println(z(a));
//        System.out.println(中序(a));
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        List<Integer> ac = new ArrayList<>();
        ac.add(0);
        ac.add(1);
        ac.add(2);
        ac.add(3);
        ac.add(4);
        ac.add(5);
        ac.add(6);
        TreeNode a1 = TreeNode.getTree();
        TreeNode a = TreeNode.getTree();
//        hanota(ac,new ArrayList<>(),new ArrayList<>());
//        System.out.println(二叉树最大深度(a1));
//        System.out.println(层次(a1));
//        for (ListNode node : 二叉树层链表(a)) {
//            链表.print(node);
//        }
        二叉树转链表(a);
        层次(a);
        System.out.println(相同的树(a, a1));

    }



    private static boolean 相同的树(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        if (!相同的树(a.left, b.left) || !相同的树(a.right, b.right)) {
            return false;
        }
        return true;
    }

    private static void 二叉树转链表(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode process = next;
                while (process.right != null) {
                    process = process.right;
                }
                process.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

    private static ListNode[] 二叉树层链表(TreeNode root) {
        if (root == null) {
            return new ListNode[0];
        }
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(temp);
        List<ListNode> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode tList = new ListNode(-1);
            ListNode tempRes = tList;
            while (size > 0) {
                TreeNode t = queue.poll();
                tList.next = new ListNode(t.val);
                tList = tList.next;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                size--;
            }
            result.add(tempRes.next);
        }
        ListNode[] re = new ListNode[result.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = result.get(i);
        }
        return re;
    }
    /*
                1
              2    3
            4        5*/

    private static int 二叉树最大深度(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        while (!A.isEmpty()) {
            while (!C.isEmpty() && C.get(C.size() - 1) < A.get(0)) {
                B.add(C.remove(C.size() - 1));
            }
            while (!B.isEmpty() && B.get(B.size() - 1) > A.get(0)) {
                C.add(B.remove(B.size() - 1));
            }
            C.add(A.remove(0));
        }
        System.out.println(C);
        System.out.println(B);
    }


    private static boolean 是否为镜像二叉树(TreeNode root) {
        if (root == null)
            return true;
        return isjingxiang(root.left, root.right);
    }

    private static boolean isjingxiang(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return isjingxiang(left.left, left.right) && isjingxiang(right.left, right.right);
    }

    private static TreeNode 镜像二叉树(TreeNode head) {
        if (head == null)
            return head;
        TreeNode temp = head;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            TreeNode xx = t.left;
            t.left = t.right;
            t.right = xx;
            if (t.left != null) {
                stack.push(t.left);
            }
            if (t.right != null) {
                stack.push(t.right);
            }
        }
        return head;
    }

    public static TreeNode 先中重建二叉树(int[] pre, int[] mid) {
        TreeNode node = fun1(pre, mid, 0, pre.length - 1, 0, mid.length - 1);
        return node;
    }

    private static TreeNode fun1(int[] pre, int[] mid, int pres, int pree, int mids, int mide) {
        if (pres > pree) {
            return null;
        }
        TreeNode node = new TreeNode(pre[pres]);
        if (pres == pree) {
            return node;
        }
        int midIndex = 0;
        for (int i = 0; i < mid.length; i++) {
            if (node.val == mid[i]) {
                midIndex = i;
            }
        }
        int leftCount = midIndex - mids;
        node.left = fun1(pre, mid, pres + 1, pres + leftCount, mids, midIndex);
        node.right = fun1(pre, mid, pres + leftCount + 1, pree, midIndex + 1, mide);
        return node;
    }

    public static List<Integer> 先序(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        System.out.println("先序遍历");
        return result;
    }

    public static List<Integer> 中序(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = head;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
        }
        System.out.println("中序遍历");
        return result;
    }

    private static List<Integer> 后序(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = head;
        TreeNode pre = null;
        stack.push(temp);
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if (temp.left == null && temp.right == null || (pre != null && (pre == temp.left || pre == temp.right))) {
                result.add(temp.val);
                stack.pop();
                pre = temp;
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
        }
        System.out.println("后序遍历");
        return result;
    }

    public static List<Integer> 层次(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = head;
        queue.add(temp);
        int res = 0;
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            result.add(temp.val);
            current--;
            if (temp.left != null) {
                queue.add(temp.left);
                next++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                next++;
            }
            if (current == 0) {
                System.out.println("换行" + result);
                current = next;
                next = 0;
                res++;
            }
        }
        System.out.println("层次遍历");
        System.out.println(res);
        return result;

//        List<Integer> result = new ArrayList<>();
//        Queue<Node> queue1 = new LinkedList<>();
//        Node temp = root;
//        queue1.add(temp);
//        while(!queue1.isEmpty()) {
//            temp = queue1.pop();
//            result.add(temp.val);
//            if(temp.children!=null ) {
//                for(Node n : temp.children) {
//                    queue1.add(n);
//                }
//            }
//        }
//        return result;

    }

    /**
     * @description:二叉树中和为某一值的路径
     * @params:
     * @return:
     * @author: lb
     * @time: 2020/7/18 5:15 下午
     */
    public static LinkedList<Integer> curSum;
    public static List<List<Integer>> result;

    public static List<List<Integer>> sumPath(TreeNode node, int sum) {
        curSum = new LinkedList<>();
        result = new ArrayList<>();
        dfs(node, sum);
        System.out.println("和为" + sum + "的路径是");
        return result;
    }

    public static void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        curSum.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(curSum));
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        curSum.remove(curSum.size() - 1);
    }
}
