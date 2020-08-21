package 链表;

import domain.ListNode;

public class 合并k个有序 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getList();
        ListNode l2 = ListNode.getList2();
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l1;
        listNodes[1] = l2;
        链表.print(fun(listNodes, 0, listNodes.length - 1));
    }

    private static ListNode fun(ListNode[] listNodes, int left, int right) {
        if (left == right) {
            return listNodes[left];
        }
        int mid = left + (right - left) / 2;
        ListNode p1 = fun(listNodes,left,mid);
        ListNode p2 = fun(listNodes,mid+1,right);
        return mergeTwoList(p1,p2);
    }

    private static ListNode mergeTwoList(ListNode p1, ListNode p2) {
        ListNode newHead = new ListNode(-1);
        ListNode res = newHead;
        while(p1 != null && p2!=null){
            if(p1.val < p2.val) {
                newHead.next = p1;
                p1 = p1.next;
                newHead = newHead.next;
                continue;
            }
           else {
                newHead.next = p2;
                p2=p2.next;
                newHead = newHead.next;
                continue;
            }
        }
        if(p1 != null) {
            newHead.next = p1;
            p1=p1.next;
            newHead = newHead.next;
        }
        if(p2 != null) {
            newHead.next = p2;
            p2=p2.next;
            newHead = newHead.next;
        }
        return res.next;
    }

}
