package programsProblem.easyLeetcode;

import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dlist1 = list1;
        ListNode dlist2 = list2;

        ListNode resList = new ListNode(0);
        ListNode curr = resList;

        while(dlist1 != null && dlist2 != null) {
            if(dlist1.val <= dlist2.val) {
                curr.next = dlist1;
                dlist1 = dlist1.next;
            }
            else if(dlist2.val < dlist1.val) {
                curr.next = dlist2;
                dlist2 = dlist2.next;
            }
            curr = curr.next;
        }

        if(dlist1 != null) curr.next = dlist1;
        if(dlist2 != null) curr.next = dlist2;

        return resList.next;
    }
}
