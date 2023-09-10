package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class ReverseLL {
    public void diverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode temp
//                = reverseListRecursive(head);
                = reverseListIterative(head);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private ListNode reverseListIterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
//        head = prev;
        return prev;
    }

    private ListNode reverseListRecursive(ListNode head) {  //head = 1 -> 2 -> 3 -> 4 -> 5
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next); //newHead = 1 -> 2 <- 3 <- 4 <- 5
        head.next.next = head;      //2 -> 1
        head.next = null;   //1 -> null
        return newHead;
    }
}
