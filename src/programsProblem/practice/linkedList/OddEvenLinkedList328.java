package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.LinkedListBuilder;
import programsProblem.practice.linkedList.utils.ListNode;
import programsProblem.utils.DriverClass;

public class OddEvenLinkedList328 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        ListNode head = new LinkedListBuilder().buildLinkedList("1 2 3 4 5");

        printElement(oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddNdx = head;
        ListNode evnNdx = head.next;
        ListNode evnHead = evnNdx;

        while(evnNdx != null && evnNdx.next != null) {
            oddNdx.next = oddNdx.next.next;
            oddNdx = oddNdx.next;

            evnNdx.next = evnNdx.next.next;
            evnNdx = evnNdx.next;
        }
        oddNdx.next = evnHead;

        return head;
    }
}
