package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.LinkedListUtils;
import programsProblem.practice.linkedList.utils.ListNode;

public class RemoveNthNodeFromEnd {
    private final LinkedListUtils linkedListUtils = new LinkedListUtils();

    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = removeNthFromEnd1(head, 2);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = linkedListUtils.getSize(head);
        int desiredIndex = size - n - 1;    //getting the required index from beginning so that it can be removed from beginning
        ListNode curr = head;

        //step. 1
        if (n == size) {
            return curr.next;
        }

        //step. 2
        for (int i = 0; i < desiredIndex; i++)   //reaching to required node through reference
            curr = curr.next;

        //step. 3
        curr.next = curr.next.next; //removing the required node through reference

        return head;
    }

    //LeetCode Solution (Less memory used)
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null; // Return null if the head is already null
        }

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
