package Que150.LinkedList8;

public class Solution141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        //检测环用快慢指针就行了，一定会追上的。
        if (head==null||head.next==null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow!=fast){
            if (fast==null||fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
