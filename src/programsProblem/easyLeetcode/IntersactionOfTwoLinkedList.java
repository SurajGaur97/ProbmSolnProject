package programsProblem.easyLeetcode;

public class IntersactionOfTwoLinkedList {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;

        while(h1 != h2) {
            h1 = h1 != null ? h1.next : headB;
            h2 = h2 != null ? h2.next : headA;
        }

        return h1;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;

        int sizeA = 0, sizeB = 0;
        while(h1 != null) {
            sizeA++;
            h1 = h1.next;
        }
        while(h2 != null) {
            sizeB++;
            h2 = h2.next;
        }

        h1 = headA; h2 =headB;
        int diff = Math.abs(sizeA - sizeB);
        while(diff != 0) {
            if(sizeA > sizeB)
                h1 = h1.next;
            else
                h2 = h2.next;
            diff--;
        }

        while(h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
            if(h1 == null || h2 == null)
                return null;
        }

        return h1;
    }
}
