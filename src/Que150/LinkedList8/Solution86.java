package Que150.LinkedList8;

public class Solution86 {
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

    public ListNode partition(ListNode head, int x) {
        //这题我感觉还挺难的，老实说。
        //但是看了题解感觉还行，没那么难，维护两个链表，small和large，然后两个虚拟头节点smallhead和largehead，最后只要small尾指向large头即可。
        //纯纯模拟，好像也不是很难，照着代码走一遍就行。
        ListNode small = new ListNode(0);//small动态节点
        ListNode smallHead = small;//虚拟small头节点
        ListNode large = new ListNode(0);//large动态节点
        ListNode largeHead = large;//虚拟large头节点
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;//注意！是head的next，因为是虚拟头节点。
        return smallHead.next;//这个也是
    }
}
