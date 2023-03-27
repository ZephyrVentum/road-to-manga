package miscellanea.leetcode;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        System.out.println(new RemoveNthNodeFromEndOfList());
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> arr = new ArrayList<>(30);
        ListNode next = head;
        do {
            arr.add(next);
            next = next.next;
        } while (next != null);

        if (arr.size() == 1) {
            return null;
        }

        if (arr.size() == n) {
            return head.next;
        }

        if (n == 1) {
            arr.get(arr.size() - 2).next = null;
            return head;
        }

        final ListNode beforeDel = arr.get(arr.size() - n - 1);
        beforeDel.next = beforeDel.next.next;

        return head;
    }
}
