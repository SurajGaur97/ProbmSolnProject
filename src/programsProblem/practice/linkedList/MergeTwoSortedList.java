package programsProblem.practice.linkedList;

import programsProblem.practice.common.DriverClass;
import programsProblem.practice.linkedList.utils.ListNode;

public class MergeTwoSortedList implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        printElement(mergeList1(l1, l2));
    }

    private ListNode mergeList2(ListNode l1, ListNode l2) {
        ListNode resList = null;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                resList = insertIt(resList, l1);
                l1 = l1.next;
            } else {
                resList = insertIt(resList, l2);
                l2 = l2.next;
            }
        }

        while (l1 != null){
            resList = insertIt(resList, l1);
            l1 = l1.next;
        }
        while (l2 != null){
            resList = insertIt(resList, l2);
            l2 = l2.next;
        }

        return resList;
    }

    private ListNode insertIt(ListNode resList, ListNode list) {
        ListNode newNode = new ListNode(list.val);
        if(resList == null)
            resList = newNode;
        else {
            ListNode current = resList;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        return resList;
    }

    private ListNode mergeList1(ListNode l1, ListNode l2) {
        ListNode resList = null;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode newNode = new ListNode(l1.val);
                if(resList == null)
                    resList = newNode;
                else {
                    ListNode current = resList;
                    while (current.next != null){
                        current = current.next;
                    }
                    current.next = newNode;
                }
                l1 = l1.next;
            } else {
                ListNode newNode = new ListNode(l2.val);
                if(resList == null)
                    resList = newNode;
                else {
                    ListNode current = resList;
                    while (current.next != null){
                        current = current.next;
                    }
                    current.next = newNode;
                }
                l2 = l2.next;
            }
        }

        while (l1 != null){
            ListNode newNode = new ListNode(l1.val);
            if(resList == null)
                resList = newNode;
            else {
                ListNode current = resList;
                while (current.next != null){
                    current = current.next;
                }
                current.next = newNode;
            }
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode newNode = new ListNode(l2.val);
            if(resList == null)
                resList = newNode;
            else {
                ListNode current = resList;
                while (current.next != null){
                    current = current.next;
                }
                current.next = newNode;
            }
            l2 = l2.next;
        }
        return resList;
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode resList = new ListNode();
        // creating reference so that it will persist changes in original list ie 'resList' when I make changes
        // in referenced list ie 'curr' list
        ListNode curr = resList;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        //if one of the list is not null after looping then directly assign it to the curr list.(it means one of
        // the list of them are greater in size.
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;

        return resList.next;
    }

}
