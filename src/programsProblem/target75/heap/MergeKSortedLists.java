package programsProblem.target75.heap;

import programsProblem.target75.linkedList.util.ListNode;
import programsProblem.utils.DriverClass;

import java.util.PriorityQueue;

public class MergeKSortedLists implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{h1, h2, h3};
        printElement(mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode head = null;
        ListNode current = null;

        for (ListNode list : lists) {
            while (list != null) {
                pq.offer(list.val);
                list = list.next;
            }
        }

        if (!pq.isEmpty()) {
            head = new ListNode(pq.poll());
            current = head;
        }

        while (!pq.isEmpty()) {
            current.next = new ListNode(pq.poll());
            current = current.next;
        }

        return head;
    }
}
