//package 链表;
//
//import domain.ListNode;
//
//public class 部分翻转 {
//    public static void main(String[] args) {
//        链表.print(fun(ListNode.getList(), 3, 6));
//    }
//
//    //    // 1 2  3 4 5 6  7 8 9
////       1 2  4 3 5 6
////       1 2  5 4 3 6
////       1 2  6 5 4 3  7 8 9
//    private static ListNode fun(ListNode head, int s, int e) {
//        ListNode temp = head;
//        ListNode res = new ListNode(-1);
//        res.next = head;
//        ListNode start = head;
//        for (int i = 0; i < s - 1; i++) {
//            start = start.next;
//        }
//        ListNode end = start.next;
//        for (int i = 0; i < e - s; i++) {
//            ListNode next = end.next;
//            end.next[3,5]
//            1
//            2[3,5]
//            1
//            2[3,5]
//            1
//            2[3,5]
//            1
//            2[3,5]
//            1
//            2[3,5]
//            1
//            2
//        }
//    }
//}
