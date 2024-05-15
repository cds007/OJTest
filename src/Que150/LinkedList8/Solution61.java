package Que150.LinkedList8;

public class Solution61 {

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

    public ListNode rotateRight(ListNode head, int k) {
        //1.我的想法：先取余，然后旋转时直接最后一个指向第一个，倒数第二个指向空就行了
        //但是我的想法有点问题，1是时间复杂度有点高O(nk)，二是不断的循环，头指针也得变，有点麻烦。
        //题解是直接计算出循环后的最后一个节点是什么，然后一轮循环就行了，时间复杂度是O(n)
        if (k==0||head==null||head.next==null){
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next!=null){
            iter = iter.next;
            n++;
        }
        int add = n-k%n;
        if (n==add){
            return head;
        }
        iter.next = head;//尾指针指向头
        while (add-->0){
            iter = iter.next;
        }
        ListNode ret =  iter.next;
        iter.next = null;
        return ret;
    }
}
