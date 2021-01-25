package old.leetcode.linkedList.code_206;

import leetcode.linkedList.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/ (206. 反转链表)
 */
public class Solution {
    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public static void main(String[] args) {
        ListNode temp1 =new ListNode(1);
        ListNode temp2 =new  ListNode(2);
        ListNode temp3 =new  ListNode(3);
        ListNode temp4 =new  ListNode(4);
        ListNode temp5 =new  ListNode(5);
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;
        new Solution().reverseList2(temp1);
    }
    // 迭代 O(n)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
