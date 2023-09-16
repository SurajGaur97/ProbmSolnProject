package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class RemoveLoopFromLL {
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head;

        removeLoop(head);
        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
    }

    private void removeLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        if (slow == head) {
            while (slow.next != head) {
                slow = slow.next;
            }
            slow.next = null;
            return;
        }

        fast = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = null;
    }
}
