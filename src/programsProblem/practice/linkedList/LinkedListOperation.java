package programsProblem.practice.linkedList;

public class LinkedListOperation {
    class ListNode {
        String data;
        ListNode next;
        ListNode() {}
        ListNode(String data) {
            this.data = data;
        }
        ListNode(String data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    //Add first, last
    ListNode head;
    int size;

    public LinkedListOperation() {
        this.size = 0;
    }

    public void addFirst(String data) {
        ListNode newNode = new ListNode(data);
        this.size++;
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        ListNode newNode = new ListNode(data);
        this.size++;
        if(head == null) {
            head = newNode;
            return;
        }

        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    //Print list
    public void printList() {
        if(head == null) {
            System.out.print("The List is Empty!");
            return;
        }

        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    //Delete first, last
    public void deleteFirst() {
        if(head == null) {
            System.out.println("The list is Empty");
            return;
        }

        this.size--;
        head = head.next;
    }

    public void deleteLast() {
        if(head == null) {
            System.out.println("The list is Empty");
            return;
        }

        this.size--;
        if(head.next == null ) {
            head = null;
            return;
        }

        ListNode secondLast = head;
        ListNode lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    //print size
    public void getSize() {
        System.out.println("Size -> " + this.size);
    }
}
