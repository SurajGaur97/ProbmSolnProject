package programsProblem.practice.linkedList.basicOperation;

public class InsertionOfNode {

    public Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        return head = newNode;
    }

    public Node insertAtSomewhereBetween(Node head, int val) {
        Node newNode = new Node(val);
        Node temp = head;

        temp = temp.next;
        temp = temp.next;

        Node temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;

        return head;
    }

    public Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }


    //Iterating the LinkedList
    public void iterateLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
