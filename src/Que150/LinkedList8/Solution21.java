package Que150.LinkedList8;

public class Solution21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //跟归并排序一样的，我觉得可能得用个虚拟头节点
        //这个比我想的好，因为它只需要在原来两个链表上更改，不需要一个新的链表
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        //这个确实是这样的，因为剩下没排序上的都是不递减排序好的。
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
