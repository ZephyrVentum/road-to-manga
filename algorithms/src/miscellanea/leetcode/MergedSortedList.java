package miscellanea.leetcode;

import utils.ListNode;

public class MergedSortedList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = new MergedSortedList().mergeTwoLists(list1, list2);
        System.out.println(merged);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode body = new ListNode();
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            head.val = list1.val;
            list1 = list1.next;
        } else {
            head.val = list2.val;
            list2 = list2.next;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                if (head.next == null) {
                    head.next = list2;
                } else {
                    body.next = list2;
                }
                return head;
            } else if (list2 == null) {
                if (head.next == null) {
                    head.next = list1;
                } else {
                    body.next = list1;
                }
                return head;
            }

            if (head.next == null) {
                head.next = body;
            } else {
                body.next = new ListNode();
                body = body.next;
            }

            if (list1.val < list2.val) {
                body.val = list1.val;
                list1 = list1.next;
            } else {
                body.val = list2.val;
                list2 = list2.next;
            }
        }
        return head;
    }
}
