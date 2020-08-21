package 链表;

import com.sun.xml.bind.v2.model.annotation.Quick;
import domain.ListNode;
import domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description: 链表相关
 * @author: lb
 * @time: 2020/7/19 2:52 下午
 */
public class 链表 {
    public static void main(String[] args) {

//        print(删除重复(ListNode.getList()));
//        print(删除重复2(ListNode.getList()));
        print(两数相加(ListNode.getList(), ListNode.getList()));
        System.out.println(两数相加(ListNode.getList(), ListNode.getList()));
//        print(合并两个有序链表(ListNode.getList(), ListNode.getList2()));
//        System.out.println(是否存在环形链表(ListNode.getList2()));
//          print(删除链表的倒数第n个节点(ListNode.getList(),3));
//        print(旋转链表(ListNode.getList(), 3));

//        print(两两交换(ListNode.getList()));
//        System.out.println(二叉树.中序(链表转二叉树(ListNode.getList())));
//        print(反转链表(ListNode.getList()));
//        System.out.println(Arrays.toString(反向打印(ListNode.getList())));
//        print(移除未排序重复(ListNode.getList2()));
//        print(中间节点(ListNode.getList()));
//        print(排序链表(ListNode.getList()));
//        print(reverseK(ListNode.getList(), 3));
    }

    //1 2 3 4 5 6 7 8 9
    //3 2 1 6 5 4 9 8 7
    public static ListNode reverseK(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = dummy;
        ListNode pre = dummy;

        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }
    // 1 2 3 4 5 6 7 8 9 10 11
    // 3 2 1 6 5 4 9 8 7 10 11

    private static ListNode 排序链表(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = 排序链表(head);
        ListNode right = 排序链表(mid);

        ListNode newHead = new ListNode(0);
        ListNode res = newHead;
        while (left != null && right != null) {
            if (left.val > right.val) {
                newHead.next = new ListNode(right.val);
                right = right.next;
                newHead = newHead.next;
            } else {
                newHead.next = new ListNode(left.val);
                left = left.next;
                newHead = newHead.next;
            }
        }
        if (left != null) {
            newHead.next = left;
        }
        if (right != null) {
            newHead.next = right;
        }

        return res.next;
    }

    private static ListNode 中间节点(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode slow = head.next;
        ListNode quick = slow.next.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    //1 1 1 1 2 3 3 2 1
    private static ListNode 移除未排序重复(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        while (slow != null) {
            ListNode quick = slow;
            while (quick.next != null) {
                if (quick.next.val == slow.val) {
                    quick.next = quick.next.next;
                } else {
                    quick = quick.next;
                }
            }
            slow = slow.next;
        }
        return head;
    }

    private static int[] 反向打印(ListNode head) {
        int[] result = new int[1];
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            result[0] = head.val;
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        result = new int[stack.size()];
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    //     1 3 5 7 9
    private static ListNode 反转链表(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (temp.next == null) {
                ListNode cur = new ListNode(temp.val);
                cur.next = pre;
                pre = cur;
                temp = temp.next;
            } else {
                ListNode next = new ListNode(temp.next.val);
                ListNode cur = new ListNode(temp.val);
                cur.next = pre;
                next.next = cur;
                pre = cur;
                temp = temp.next;
            }
        }
        return pre;
    }

    public static List<ListNode> nodes = new ArrayList<>();

    private static TreeNode 链表转二叉树(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        return fun(0, nodes.size() - 1);
    }

    private static TreeNode fun(int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nodes.get(mid).val);
        if (left == right)
            return node;
        node.left = fun(left, mid - 1);
        node.right = fun(mid + 1, right);
        return node;
    }

    //1 3 5 7 9 11 13 15
//2 1 4 3 6 5 8 7
    private static ListNode 两两交换(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode newHead = head.next;
            newHead.next = new ListNode(head.val);
            return newHead;
        }
        int cur = 0;
        ListNode temp = head;
        ListNode pre = null;
        ListNode newHead = null;
        ArrayList<ListNode> jiList = new ArrayList<>();
        ArrayList<ListNode> ouList = new ArrayList<>();
        while (temp != null) {
            if (cur == 1) {
                newHead = new ListNode(temp.val);
                break;
            }
            cur++;
            temp = temp.next;
        }
        temp = head;
        ListNode result = newHead;
        cur = 0;
        while (temp != null) {
            if (cur % 2 == 0) {
                if (cur == 0) {
                    newHead.next = new ListNode(temp.val);
                    cur++;
                    temp = temp.next;
                    continue;
                }
                ouList.add(temp);
            } else if (cur != 1) {
                jiList.add(temp);
            }
            cur++;
            temp = temp.next;
        }
        ListNode tempNew = newHead;
        tempNew = tempNew.next;
        for (int i = 0; i < ouList.size(); i++) {
            if (i <= jiList.size() - 1) {
                tempNew.next = jiList.get(i);
                tempNew = tempNew.next;
            }
            tempNew.next = new ListNode(ouList.get(i).val);
            tempNew = tempNew.next;
        }
        return result;
    }

    private static ListNode 旋转链表(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        ListNode newHead = null;
        for (int i = 0; i < length; i++) {
            if (i == length - k % length) {
                newHead = temp;
            }
            if (i == length - 1) {
                temp.next = head;
            }
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < length; i++) {
            if (i == length - k % length - 1) {
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return newHead;

    }


    /*
     *  1 2 2 4 4 4   4 5  6
     */
    private static ListNode 删除链表的倒数第n个节点(ListNode head, int k) {
        ListNode quick = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            quick = quick.next;
        }
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    private static boolean 是否存在环形链表(ListNode head) {
        ListNode temp = head;
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            if (quick.val == slow.val) {
                return true;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }


    private static ListNode 合并两个有序链表(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode newHead;
        if (a.val > b.val) {
            newHead = b;
            b = b.next;
        } else {
            newHead = a;
            a = a.next;
        }
        ListNode result = newHead;
        while (a != null || b != null) {
            while (a != null && b != null) {
                if (a.val > b.val) {
                    newHead.next = b;
                    newHead = newHead.next;
                    b = b.next;
                } else {
                    newHead.next = a;
                    newHead = newHead.next;
                    a = a.next;
                }
            }
            if (a == null) {
                while (b != null) {
                    newHead.next = b;
                    newHead = newHead.next;
                    b = b.next;
                }
            }
            if (b == null) {
                while (a != null) {
                    newHead.next = a;
                    a = a.next;
                    newHead = newHead.next;
                }
            }
        }
        return result;
    }


    private static ListNode 两数相加(ListNode a, ListNode b) {
        int ass = 10;
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack1 = new Stack<>();
        while (a != null) {
            stack.push(a);
            a = a.next;
        }
        while (b != null) {
            stack1.push(b);
            b = b.next;
        }
        int flag = 0;
        ListNode newHead = null;
        ListNode cur;
        while (!stack.isEmpty() || !stack1.isEmpty() || flag != 0) {
            if (!stack.isEmpty()) {
                flag += stack.pop().val;
            }
            if (!stack1.isEmpty()) {
                flag += stack1.pop().val;
            }
            cur = new ListNode(flag % 10);
            cur.next = newHead;
            newHead = cur;
            flag = flag / 10;
        }
        return newHead;
    }


    public static ListNode 删除重复2(ListNode head) {
        ListNode cur = head;
        ListNode slow = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                cur.next = cur.next.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    private static ListNode 删除重复(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        if (head == null)
            return;
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp.next != null) {
            sb.append(temp.val).append(",");
            temp = temp.next;
        }
        System.out.println(sb.append(temp.val).toString());
    }
}
