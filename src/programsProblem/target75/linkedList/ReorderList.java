package programsProblem.target75.linkedList;

import programsProblem.target75.linkedList.util.LinkedListBuilder;
import programsProblem.target75.linkedList.util.ListNode;
import programsProblem.utils.DriverClass;

public class ReorderList implements DriverClass<ListNode> {
    @Override
    public void driverMethod(){
        ListNode head = LinkedListBuilder.buildLinkedList("1,2,3,4");
        reorderList1(head);
        printElement(head);
    }

    //CodeStoryWithMIK
    public void reorderList1(ListNode head){
        ListNode fast = head;
        ListNode mid = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode rev = reverse(mid);
        ListNode curr = head;

        while (curr != null && rev.next != null){
            ListNode tmp = curr.next;
            ListNode revTmp = rev.next;

            curr.next = rev;
            rev.next = tmp;

            curr = tmp;
            rev = revTmp;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    //------------------------------------------------------------------------
    //By me.
    public void reorderList(ListNode head){
        ListNode rev = reverseList(copyHead(head));
        ListNode curr = head;

        int size = getSize(head);
        ListNode res = new ListNode(curr.val);
        curr = curr.next;
        ListNode resCurr = res;

        for(int i = 1;i <= size;i++){
            if(i % 2 == 0){
                resCurr.next = curr;
                curr = curr.next;
            } else {
                resCurr.next = rev;
                rev = rev.next;
            }
            resCurr = resCurr.next;
        }

        curr = head;
        resCurr = res;
        for(int i = 0;i < size;i++){
            curr.next = resCurr.next;
            curr = curr.next;
            resCurr = resCurr.next;

            if(i == size - 2)
                curr.next = null;
        }
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    private ListNode copyHead(ListNode head){
        ListNode headCopy = new ListNode(head.val);
        ListNode hadCopyCurr = headCopy;
        ListNode curr = head;

        while (curr.next != null){
            hadCopyCurr.next = new ListNode(curr.next.val);
            hadCopyCurr = hadCopyCurr.next;
            curr = curr.next;
        }

        return headCopy;
    }

    private int getSize(ListNode head){
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }
}
