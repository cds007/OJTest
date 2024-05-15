package Que150.fenzhi16;


public class Solution148 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        // 归并排序
        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        public ListNode mergeSort(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }

            // 1. 找到链表中间的结点
            ListNode centerNode = findCenterListNode(head);

            ListNode list1 = head;
            ListNode list2 = centerNode.next;

            // 2. 从链表中间断开成前后两个链表
            centerNode.next = null;

            // 3. 分别对前后两个链表进行排序
            list1 = mergeSort(list1);
            list2 = mergeSort(list2);

            // 4. 把排序后的两个链表合并成一个链表
            return mergeTwoSortedList(list1, list2);
        }

        // 递归形式的合并两个有序链表
        private ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
            if (temp1 != null) {
                temp.next = temp1;
            } else if (temp2 != null) {
                temp.next = temp2;
            }
            return dummyHead.next;
        }

        // 这个方法的输入的链表的结点数量 >= 2
        private ListNode findCenterListNode(ListNode head) {
            ListNode slow = head, fast = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }
}

