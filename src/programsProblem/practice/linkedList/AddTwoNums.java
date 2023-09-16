package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class AddTwoNums {
    public void driverMethod() {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode res = addTwoNumbers1(l1, l2);
        while (res != null) {
            System.out.print(res);
            res = res.next;
        }
    }

    //Leetcode solution
    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    //My code taken some help for carry part from leetcode.
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode resCurr = res;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            resCurr.next = new ListNode(digit);

            l1 = l1.next;
            l2 = l2.next;
            resCurr = resCurr.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            resCurr.next = new ListNode(digit);

            l1 = l1.next;
            resCurr = resCurr.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            carry = sum / 10;

            resCurr.next = new ListNode(digit);

            l2 = l2.next;
            resCurr = resCurr.next;
        }

        if (carry != 0) {
            resCurr.next = new ListNode(carry);
            resCurr = resCurr.next;
        }

        return res.next;
    }
}
