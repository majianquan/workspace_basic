package old.leetcode.linkedList.code_24;

import leetcode.linkedList.ListNode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs (24. 两两交换链表中的节点)
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode temp1 =new ListNode(1);
        ListNode temp2 =new ListNode(2);
        ListNode temp3 =new ListNode(3);
        ListNode temp4 =new ListNode(4);
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = null;
    }
    public ListNode swapPairs(ListNode head) {
        if((head == null) || (head.next == null)) return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }
}
