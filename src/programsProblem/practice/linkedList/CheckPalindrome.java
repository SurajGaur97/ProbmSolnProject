package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.LinkedListUtils;
import programsProblem.practice.linkedList.utils.ListNode;

public class CheckPalindrome {
    private final LinkedListUtils linkedListUtils = new LinkedListUtils();

    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new DoublyListNode(1);

        System.out.println(isPalindrome(head));
//        System.out.println(checkPalindrome3(head));
    }

    //Reverse the list
    private boolean checkPalindrome3(ListNode head) {
        ListNode curr = head;
        ListNode copy = linkedListUtils.createCopy(head);
        ListNode revList = linkedListUtils.reverseLL(copy);

        while (curr != null && revList != null) {
            if (curr.val != revList.val) {
                return false;
            }
            curr = curr.next;
            revList = revList.next;
        }
        return true;
    }

    //Get the node at an index
    private boolean checkPalindrome2(ListNode head) {
        int size = linkedListUtils.getSize(head);
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            if (linkedListUtils.getIndxNode(head, i) != linkedListUtils.getIndxNode(head, j)) {
                return false;
            }
        }
        return true;
    }

    //Do half and then reverse the 2nd list
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Empty or single-node list is considered a palindrome.
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list.
        ListNode reversedSecondHalf = linkedListUtils.reverseLinkedIter(slow);

        // Step 3: Compare the first half with the reversed second half.
        while (reversedSecondHalf != null) {
            if (head.val != reversedSecondHalf.val) {
                return false; // Values don't match, not a palindrome.
            }
            head = head.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true; // Linked list is a palindrome.
    }
}
