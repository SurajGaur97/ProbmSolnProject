package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.LinkedListBuilder;
import programsProblem.practice.linkedList.utils.ListNode;
import programsProblem.utils.DriverClass;

public class MaximumTwinSumOfALinkedList implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        ListNode head = new LinkedListBuilder().buildLinkedList("5 4 2 1");
        int res = pairSum(head);

        printElement(res);
    }

    public int pairSum(ListNode head) {
        ListNode curr = head;
        ListNode rev = reverse(curr);

        int n = getSize(rev);
        System.out.print(n);
        int i = 0, maxSum = Integer.MIN_VALUE;
        while(i <= (n / 2) - 1) {
            if(maxSum < curr.val + rev.val)
                maxSum = curr.val + rev.val;

            curr = curr.next;
            rev = rev.next;
            i++;
        }

        return maxSum;
    }

    private ListNode reverse(ListNode head) {
        ListNode rev = null;
        ListNode curr = head;

        ListNode copy = new ListNode(head.val);
        ListNode copyCurr = copy;
        while(curr != null) {
            copyCurr.next = new ListNode(curr.val);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        ListNode tmpCopy = copy.next;

        while(tmpCopy != null) {
            ListNode tmp = tmpCopy.next;
            tmpCopy.next = rev;
            rev = tmpCopy;
            tmpCopy = tmp;
        }

        return rev;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode curr = head;

        while(curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }
}
