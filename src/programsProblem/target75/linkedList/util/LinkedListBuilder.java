package programsProblem.target75.linkedList.util;

public class LinkedListBuilder {
    public static ListNode buildLinkedList(String str){
        if(str.length() == 0) return null;

        String[] chars = str.split(",");
        ListNode root = new ListNode(Integer.parseInt(chars[0]));
        ListNode curr = root;

        for(int i = 1;i < chars.length;i++){
            curr.next = new ListNode(Integer.parseInt(chars[i]));
            curr = curr.next;
        }

        return root;
    }
}
