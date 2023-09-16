package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class RotateList {
    public void driveMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode res = rotateRight1(head, 0);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }

    }

    private ListNode rotateRight1(ListNode head, int k) {
        int size = 0;
        ListNode a = head;
        while (a != null) {
            size++;
            a = a.next;
        }
        k = k % size;   //Getting actual rotating count

        ListNode curr = head;

        int lenFromStart = size - k;
        while (lenFromStart != 1) {
            curr = curr.next;
            lenFromStart--;
        }

        ListNode temp = curr.next;
        curr.next = null;

        ListNode temCurr = temp;
        while (temCurr.next != null) {
            temCurr = temCurr.next;
        }
        temCurr.next = head;
        head = temp;

        return head;
    }

    private ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ListNode a = head;
        while (a != null) {
            size++;
            a = a.next;
        }
        k = k % size;   //Getting actual rotating count
        for (int i = 0; i < k; i++) {
            ListNode curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            ListNode temp = curr.next;
            curr.next = null;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
