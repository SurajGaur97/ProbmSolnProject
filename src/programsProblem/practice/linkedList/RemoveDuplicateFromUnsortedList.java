package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

import java.util.HashSet;

public class RemoveDuplicateFromUnsortedList {

    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);

        ListNode res = removeDuplicate(head);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }
    }

    private ListNode removeDuplicate(ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (!set.contains(curr.val)) {
                set.add(curr.val);
                prev = curr;
            } else {
                prev.next = prev.next.next;
            }
            curr = curr.next;
        }

        return head;
    }
}
