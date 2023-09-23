package programsProblem.practice.linkedList.utils;

public class LinkedListBuilder {
    public ListNode buildLinkedList(String str) {
        ListNode LinkedList = new ListNode();
        ListNode curr = LinkedList;

        String[] valueList = str.split(" ");
        for (int i = 0; i < valueList.length; i++) {
            curr.next = new ListNode(Integer.parseInt(valueList[i]));
            curr = curr.next;
        }

        return LinkedList.next;
    }
}
