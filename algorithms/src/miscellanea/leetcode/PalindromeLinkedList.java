package miscellanea.leetcode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(1))));
        Solution solution = new Solution();
        solution.isPalindrome(head);
    }
}

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

    @Override
    public String toString() {
        ListNode local = new ListNode(val, next);
        String result = "";
        while (local != null) {
            result += local.val;
            result += ' ';
            local = local.next;
        }
        return result;
    }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        while (slow.next != null) {
            slow = slow.next;
            prev = new ListNode(slow.val, prev);
        }
        while (prev != null) {
            if (head.val != prev.val) {
                System.out.println(false);
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        System.out.println(true);
        return true;
    }


}
