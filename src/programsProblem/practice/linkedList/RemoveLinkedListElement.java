package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class RemoveLinkedListElement {
    public void driverMethod() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode list = removeElements(head, 6);

//        DoublyListNode head = new DoublyListNode(7);
//        head.next = new DoublyListNode(7);
//        head.next.next = new DoublyListNode(7);
//        head.next.next.next = new DoublyListNode(7);
//
//        DoublyListNode list = removeElements(head, 7);

        while (list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    private ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode copy = dummy;

        while(copy.next != null) {
            if(copy.next.val == val)
                copy.next = copy.next.next;
            else
                copy = copy.next;
        }

        return dummy.next;
    }
}
