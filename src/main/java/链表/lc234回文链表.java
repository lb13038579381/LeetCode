package 链表;

import domain.ListNode;

public class lc234回文链表 {
    public static void main(String[] args) {
        ListNode node = ListNode.getList();
        System.out.println(fun(node));
    }

    // 1 2 3 4 5 4 3 2 1
    private static boolean fun(ListNode node) {
        if (node == null || node.next == null) {
            return true;
        }
        ListNode slow = node;
        ListNode quick = node;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        slow.next = reverse(slow.next);
        quick = slow.next;
        slow = node;
        while(quick != null) {
            if(slow.val != quick.val) {
                return false;
            }
            slow = slow.next;
            quick=quick.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode process = node;
        ListNode next = null;
        while (process != null) {
            next = process.next;
            process.next = pre;
            pre = process;
            process = next;
        }
        return pre;
    }
}
