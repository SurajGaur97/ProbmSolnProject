package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class MiddleNode {
    public void driverClass() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(middleNode(head).val);
    }

    private ListNode middleNode(ListNode head) {
        int size = getSizeOfLL(head);
        ListNode curr = head;
        for (int i = 0; i < size / 2; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private int getSizeOfLL(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
