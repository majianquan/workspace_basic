package old.leetcode.linkedList.code_141;

import leetcode.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle
 */
public class Solution {
    // hash
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSet = new HashSet<>();
        while (head != null) {
            if(nodesSet.contains(head)) {
                return true;
            } else {
                nodesSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
    // 双指针
    public boolean hashCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast =  head.next;

        while (slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
