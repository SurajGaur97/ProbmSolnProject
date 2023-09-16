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

    //Main logic is behind this method
    private ListNode divide(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;

        ListNode leftHalf = divide(head);
        ListNode rightHalf = divide(secondHalf);

        return conquer(leftHalf, rightHalf);
    }

    //Merging the two sorted lists as normal approach not anything new
    private ListNode conquer(ListNode leftHalf, ListNode rightHalf) {
        ListNode merge = new ListNode();
        ListNode curr = merge;

        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.val < rightHalf.val) {
                curr.next = leftHalf;
                leftHalf = leftHalf.next;
            } else if (rightHalf.val < leftHalf.val) {
                curr.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            curr = curr.next;
        }

        if (leftHalf != null) curr.next = leftHalf;
        if (rightHalf != null) curr.next = rightHalf;

        return merge.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //Note: Always take the first middle node(not the second one in the case of even no of elements)
        //for solving linked list question when need to get middle node.
        //Stack overflow if you put (fast != null && fast.next != null): this condition is used for getting
        //the second node (which is not required here).
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
