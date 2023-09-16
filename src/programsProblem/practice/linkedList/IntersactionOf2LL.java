package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class IntersactionOf2LL {
    public void driverMethod() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);

        ListNode res = getIntersaction(l1, l2);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }
    }

    private ListNode getIntersaction(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode tail = res;

        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
                l2 = l2.next;
                tail = tail.next;
            } else if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }
        return res.next;
    }

}
