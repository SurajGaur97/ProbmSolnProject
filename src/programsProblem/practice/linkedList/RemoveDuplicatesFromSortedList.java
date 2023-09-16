package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class RemoveDuplicatesFromSortedList {
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        removeDuplicate(head);
        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
    }

    private ListNode removeDuplicate(ListNode head) {
        if (head.next == null) return head;

        if (head.val == head.next.val) {
            head.next = head.next.next;
        } else {
            head = head.next;
        }
        return removeDuplicate(head);
    }

    private ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
