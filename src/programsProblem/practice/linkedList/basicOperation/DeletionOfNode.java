package programsProblem.practice.linkedList.basicOperation;

public class DeletionOfNode {

    public Node deleteHead(Node head) {
        Node temp = head.next;
        head = null;
        return head = temp;
    }

    //It will work for at-end node deletion
    public Node deleteAtSomewhereBetween(Node head, int index) {
        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
//        Node remNode = curr.next;
//        curr = remNode.next;
//        remNode = null;
        curr.next = curr.next.next;

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
