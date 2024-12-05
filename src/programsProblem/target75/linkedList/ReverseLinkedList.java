package programsProblem.target75.linkedList;

import programsProblem.target75.linkedList.util.LinkedListBuilder;
import programsProblem.target75.linkedList.util.ListNode;
import programsProblem.utils.DriverClass;

public class ReverseLinkedList implements DriverClass<ListNode> {
    @Override
    public void driverMethod(){
        ListNode listNode = LinkedListBuilder.buildLinkedList("1,2,3,4,5");

        printElement(reverseList(listNode));
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
