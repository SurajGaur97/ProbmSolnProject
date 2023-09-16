package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class DetectLifeCycle {
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head;

        ListNode res = detectCycle(head);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }
    }

    private ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        } while (fast != null && fast.next != null);

        if (fast == null) return null;

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
