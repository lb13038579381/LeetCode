import domain.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 链表相加 {
    public static void main(String[] args) {
        ListNode a = new ListNode(7);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        ListNode e = new ListNode(5);
        ListNode f = new ListNode(9);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(8);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);

        ListNode result = addTwoNumbers(a,e);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 !=null) {
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int count = 0;
        List<ListNode> result = new LinkedList<>();
        while(!s1.isEmpty() && !s2.isEmpty()) {
            int now = count + s1.pop()+s2.pop();
            if(now > 10) {
                ListNode temp = new ListNode(now - 10);
                result.add(temp);
                count=1;
            }else {
                count=0;
            }
        }
        if(!s1.isEmpty() && s2.isEmpty()) {
            while(!s1.isEmpty()){
                ListNode temp = new ListNode(s1.pop());
                result.add(temp);
            }
        }
        if(s1.isEmpty() && !s2.isEmpty()) {
            while(!s2.isEmpty()){
                ListNode temp = new ListNode(s2.pop());
                result.add(temp);
            }
        }
        ListNode head = result.get(0);
        for (int i = 1;i < result.size();i++) {
            head.next = result.get(i);
        }
        return head;
    }
}
