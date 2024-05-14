package Que150.LinkedList8;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next==null) return head;//这题就得用穿针引线法！最好理解！
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        int i=0;
        while(i<left-1){
            pre = pre.next;
            i++;
        }
        ListNode cur = pre.next;
        ListNode temp = cur.next;
        int j=0;
        while(j<right-left){
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            j++;
        }
        return dummy.next;
    }
}
