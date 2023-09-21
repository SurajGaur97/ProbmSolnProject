package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class ReverseNodeInKGroup {
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = reverseKGroup(head, 3);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }

    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        //Checking if the head's length is less than k then it should out from recursion with head;
        ListNode tmp = head;
        int n = 0;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }
        if (n < k) return head;

        //reversing the k nodes first.
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; curr != null && i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //getting the reverse list in head.next
        head.next = reverseKGroup(curr, k);

        //returning the reverse list
        return prev;
    }
}
