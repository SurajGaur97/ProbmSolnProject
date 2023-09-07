package programsProblem.practice.linkedList.basicOperation;

public class LinkedListDriverClass {
    private Node head;

    public void masterDriverMethod() {
        driverMethodForInsert();
        driverMethodForIterate();
        driverMethodForDelete();
        driverMethodForIterate();
    }

    private void driverMethodForInsert() {
        InsertionOfNode insertionOfNode = new InsertionOfNode();

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        //Insert at Beginning
        head = insertionOfNode.insertAtBeginning(head, 4);

        //Insert at Somewhere in between
        head = insertionOfNode.insertAtSomewhereBetween(head, 5);

        //Insert at End
        head = insertionOfNode.insertAtEnd(head, 6);
    }

    private void driverMethodForDelete() {
        DeletionOfNode deletionOfNode = new DeletionOfNode();

        //Deleting Head
//        head = deletionOfNode.deleteHead(head);

        head = deletionOfNode.deleteAtSomewhereBetween(head, 2);

//        head = deletionOfNode.deleteAtEnd(head);
    }

    private void driverMethodForIterate() {
        TraversingInLL traversingInLL = new TraversingInLL();

        traversingInLL.iterateLinkedList(head);
//        System.out.println("\n" + traversingInLL.getLLSize(head));
//        System.out.println(traversingInLL.getNthNodeVal(head, traversingInLL.getLLSize(head)));
    }
}
