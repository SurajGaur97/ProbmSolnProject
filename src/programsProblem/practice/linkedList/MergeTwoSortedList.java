package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class MergeTwoSortedList {
    public void driverMethod() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = mergeList(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode resList = new ListNode();
        // creating reference so that it will persist changes in original list ie 'resList' when I make changes
        // in referenced list ie 'curr' list
        ListNode curr = resList;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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
