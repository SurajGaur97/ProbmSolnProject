package programsProblem.practice.linkedList.utils;

public class LinkedListUtils {
    public ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public int getIndxNode(ListNode head, int indx) {
        ListNode curr = head;

        for (int i = 0; i < indx; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public int getSize(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public ListNode createCopy(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode copy = new ListNode(head.val);
        copy.next = createCopy(head.next);
        return copy;
    }

    public ListNode reverseLinkedIter(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr);
            curr = curr.next;
        }
    }

}
