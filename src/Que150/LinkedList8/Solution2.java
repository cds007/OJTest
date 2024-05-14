package Que150.LinkedList8;

public class Solution2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //感觉就是模拟进位加法，好像也不是很难
        //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //输出：[8,9,9,9,0,0,0,1]
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;//进位
        while (l1!=null||l2!=null){
            int n1 = l1!=null?l1.val:0;
            int n2 = l2!=null?l2.val:0;
            int sum = n1+n2+carry;
            if (head==null){
                head = new ListNode(sum%10);
                tail = head;
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (carry>0){
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
