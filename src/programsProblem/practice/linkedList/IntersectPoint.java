package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.LinkedListUtils;
import programsProblem.practice.linkedList.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectPoint {
    LinkedListUtils linkedListUtils = new LinkedListUtils();

    public void driverMethod() {
        ListNode common = new ListNode(15);
        common.next = new ListNode(30);

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(9);
        head1.next.next.next = common;

        ListNode head2 = new ListNode(10);
        head2.next = common;

        ListNode res = intersectPoint(head1, head2);
        linkedListUtils.printList(res); //printing list.
    }

    private ListNode intersectPoint(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        int c1 = linkedListUtils.getSize(curr1);
        int c2 = linkedListUtils.getSize(curr2);

        int diff = Math.abs(c1 - c2);

        if (c1 > c2)
            while (diff != 0) {
                curr1 = curr1.next;
                diff--;
            }
        else
            while (diff != 0) {
                curr2 = curr2.next;
                diff--;
            }

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2)
                return curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return null;
    }

    //Thought by me but worthless(working only for some inputs)
    private ListNode getIntersectPoint(ListNode head1, ListNode head2) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null || curr2 != null) {
            if (curr1 != null && !set.contains(curr1)) {
                set.add(curr1);
                curr1 = curr1.next;
            }
            if (curr2 != null && !set.contains(curr2)) {
                set.add(curr2);
                curr2 = curr2.next;
            }
            if (set.contains(curr1) || set.contains(curr2)) {
                return curr1;
            }
        }
        return null;
    }
}
