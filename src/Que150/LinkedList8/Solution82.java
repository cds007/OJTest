package Que150.LinkedList8;

public class Solution82 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        ListNode() {
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        //1.感觉也不是很难，比反转链表II简单，一要虚拟头节点，二用一个双指针就ok了。
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {//考虑清楚这个终止条件，因为下面要用到cur.next.next这个值，所以它也不能为空
            if (cur.next.val == cur.next.next.val) {//应该是有多种写法的，可能也不需要判断两个next这么多。
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
