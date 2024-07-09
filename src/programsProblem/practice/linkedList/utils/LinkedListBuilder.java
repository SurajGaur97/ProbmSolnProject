package programsProblem.practice.linkedList.utils;

public class LinkedListBuilder {
    /**
     * @param str
     * @return
     * @apiNote Eg: ListNode head = new LinkedListBuilder().buildLinkedList("1 2 3 4 5");
     */
    public static ListNode buildLinkedList(String str) {
        ListNode LinkedList = new ListNode();
        ListNode curr = LinkedList;

        String[] valueList = str.split(" ");
        for (int i = 0;i < valueList.length;i++){
            curr.next = new ListNode(Integer.parseInt(valueList[i]));
            curr = curr.next;
        }

        return LinkedList.next;
    }
}
