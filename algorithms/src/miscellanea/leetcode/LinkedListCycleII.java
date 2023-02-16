package miscellanea.leetcode;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode listNodeCycleEnds = new ListNode(-4);
        ListNode listNodeCycleBegins = new ListNode(2, new ListNode(0, listNodeCycleEnds));
        listNodeCycleEnds.next = listNodeCycleBegins;
        ListNode list1 = new ListNode(3, listNodeCycleBegins);

        System.out.println(list1.toString(10));

        System.out.println(new LinkedListCycleII().detectCycle(list1).toString(10));
    }

//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null && set.add(head)) {
//            head = head.next;
//        }
//        return head;
//    }

    public ListNode detectCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
