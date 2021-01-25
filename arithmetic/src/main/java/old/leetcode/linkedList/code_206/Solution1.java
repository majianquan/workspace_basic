package old.leetcode.linkedList.code_206;

import leetcode.linkedList.ListNode;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
//    public ListNode reverseList2(ListNode head) {
////        ListNode p = reverseList(head.next)
//        head.next.next = null;
//        head.next = p;
//    }
}
