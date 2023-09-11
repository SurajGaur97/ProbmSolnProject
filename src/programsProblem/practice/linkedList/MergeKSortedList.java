package programsProblem.practice.linkedList;

import programsProblem.practice.linkedList.utils.ListNode;

public class MergeKSortedList {
    public void driverMethod() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        //Ignore here, can be used in leetcode for base condition.
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        if (lists == null || lists.length == 0) return;
        if (lists.length == 1) lists[0] = lists[0];

//        ListNode res = mergeKLists1(lists);
        ListNode res = mergeKLists(lists, 0, lists.length - 1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //By Myself Thought Solution
    private ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        //step 1
        ListNode result = mergeIt(lists[0], lists[1]);

        //step 2
        int i = 2;
        while (i < lists.length) {
            result = mergeIt(result, lists[i]);
            i++;
        }

        return result;
    }

    //Leetcode best approach:
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start + 1 == end) {
            return mergeIt(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeIt(left, right);
    }

    private ListNode mergeIt(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode resList = new ListNode(0);
        ListNode curr = resList;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else if (list2.val < list1.val) {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return resList.next;
    }
}
