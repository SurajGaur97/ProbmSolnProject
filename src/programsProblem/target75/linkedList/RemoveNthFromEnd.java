package programsProblem.target75.linkedList;

import programsProblem.target75.linkedList.util.ListNode;
import programsProblem.utils.DriverClass;

public class RemoveNthFromEnd  implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = removeNthFromEnd(head, 2);
        printElement(res);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        // Move the fast pointer ahead by n nodes
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast becomes null, it means the node to be removed is the head node
        if (fast == null) {
            return head.next; // Return the updated head
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return head; // Return the original head
    }
}
