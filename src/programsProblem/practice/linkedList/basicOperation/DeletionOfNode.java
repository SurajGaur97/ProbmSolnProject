package programsProblem.practice.linkedList.basicOperation;

public class DeletionOfNode {

    public Node deleteHead(Node head) {
        Node temp = head.next;
        head = null;
        return head = temp;
    }

    public Node deleteAtSomewhereBetween(Node head, int index) {
//        Node slowPtr = head;
//        Node fastPtr = head;
//        Node prev = null;
//
//        for (int i = 1; i < index; i++) {
//            prev = slowPtr;
//            slowPtr = slowPtr.next;
//            fastPtr = fastPtr.next;
//        }
//
//        prev.next = slowPtr.next;
//        slowPtr = null; // Optional: Set the removed node to null

        Node curr = head;

        for(int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        Node remNode = curr.next;
        curr = remNode.next;
        remNode = null;

        return head;
    }

    public Node deleteAtEnd(Node head) {
        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;

        return head;
    }

}
