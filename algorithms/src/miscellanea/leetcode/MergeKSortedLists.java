package miscellanea.leetcode;


import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        ListNode merged = new MergeKSortedLists().mergeKLists(lists);
        System.out.println(merged);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode body = result;
        mergeKListsRec(body, new ArrayList<>(Arrays.asList(lists)));
        return result.next;
    }

    public void mergeKListsRec(ListNode answer, List<ListNode> lists) {
        if (!lists.isEmpty()) {
            ListNode lowestNode = null;
            int positionOfNodeWithLowestValue = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) == null) {
                    positionOfNodeWithLowestValue = i;
                    lowestNode = null;
                    break;
                } else if (lowestNode == null || lowestNode.val > lists.get(i).val) {
                    positionOfNodeWithLowestValue = i;
                    lowestNode = lists.get(i);
                }
            }
            if (lowestNode == null) {
                lists.remove(positionOfNodeWithLowestValue);
                mergeKListsRec(answer, lists);
                return;
            } else if (lowestNode.next == null) {
                lists.remove(positionOfNodeWithLowestValue);
            } else {
                lists.set(positionOfNodeWithLowestValue, lowestNode.next);
            }
            answer.next = lowestNode;
            mergeKListsRec(answer.next, lists);
        }
    }
}
