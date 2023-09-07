package programsProblem.practice.linkedList.basicOperation;

public class TraversingInLL {

    public int getNthNodeVal(Node head, int n) {
        Node temp = head;
        for(int i = 1; i < n; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void iterateLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getLLSize(Node head) {
        Node temp = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
