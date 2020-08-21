package 其他;

import domain.ListNode;

public class LRULinkList {
    private ListNode head;

    private int cacheSize;

    public LRULinkList(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void put(int a) {
        if (head == null) {
            this.head = new ListNode(a);
            return;
        } else {
            ListNode temp = head;
            if (temp.val == a) {
                return;
            }
            while (temp.next != null) {
                if (temp.next.val == a) {
                    ListNode tar;
                    ListNode next;
                    if (temp.next.next == null) {
                        tar = temp.next;
                        tar.next = head;
                        this.head = tar;
                        temp.next = null;
                        verifyCapcite();
                        return;
                    }
                    next = temp.next.next;
                    tar = temp.next;
                    temp.next = next;
                    tar.next = head;
                    this.head = tar;
                    verifyCapcite();
                    return;
                }
                temp = temp.next;
            }
            ListNode now = new ListNode(a);
            now.next = head;
            this.head = now;
            verifyCapcite();
        }
    }

    public int get() {
        if (this.head != null) {
            return this.head.val;
        } else {
            return -1;
        }
    }

    private void verifyCapcite() {
        if (head == null) {
            return;
        }
        int cur = 0;
        ListNode temp = head;
        while (temp != null) {
            cur++;
            temp = temp.next;
        }
        if (cur > this.cacheSize) {
            temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        ListNode temp = head;
        while (temp.next != null) {
            result.append(temp.val).append(",");
            temp = temp.next;
        }
        result.append(temp.val);
        return result.toString();
    }

    public static void main(String[] args) {
        LRULinkList lruLinkList = new LRULinkList(5);
        lruLinkList.put(1);
        lruLinkList.put(2);
        lruLinkList.put(3);
        lruLinkList.put(4);
        lruLinkList.put(5);
        lruLinkList.put(6);
        lruLinkList.put(7);
        lruLinkList.put(3);
        lruLinkList.put(6);

        System.out.println(lruLinkList.get());
        System.out.println(lruLinkList);

    }
}
