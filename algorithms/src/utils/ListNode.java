package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return toString(-1);
    }

    public String toString(int limit) {
        int counter = 0;
        ListNode local = new ListNode(val, next);
        StringBuilder result = new StringBuilder();
        while (local != null && (counter < limit || limit < 0)) {
            result.append(local.val);
            if(local.next != null) {
                result.append(' ');
            }
            local = local.next;
            counter++;
        }
        return result.toString();
    }
}
