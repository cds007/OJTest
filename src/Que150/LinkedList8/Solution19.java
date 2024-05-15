package Que150.LinkedList8;

public class Solution19 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode() {
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size =0;
        while(cur!=null){
            cur = cur.next;
            size++;
        }
        int pos = size+1-n-1;
        ListNode dummy = new ListNode();
        dummy.next = head;
        cur = dummy;
        while(pos--!=0){
            cur = cur.next;
        }//cur最后是停在了被删除节点的前一个节点的位置
        cur.next = cur.next.next;
        return dummy.next;
    }
}
