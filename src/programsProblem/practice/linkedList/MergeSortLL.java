package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class MergeSortLL {
    public void driverMethod() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);

        ListNode sortedList = divide(head);
        while (sortedList != null) {
            System.out.print(sortedList);
            sortedList = sortedList.next;
        }
    }

    private ListNode divide(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode leftHalf = divide(head);
        ListNode rightHalf = divide(secondHalf);

        return conquer(leftHalf, rightHalf);
    }

    private ListNode conquer(ListNode leftHalf, ListNode rightHalf) {
        ListNode left = leftHalf;
        ListNode right = rightHalf;

        ListNode merge = new ListNode();
        ListNode curr = merge;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else if (right.val < left.val) {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) curr.next = left;
        if (right != null) curr.next = right;

        return merge.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
