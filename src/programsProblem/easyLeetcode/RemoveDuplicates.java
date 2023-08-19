package programsProblem.easyLeetcode;
//16-jun-2023
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode copy = head;

        while(copy.next != null) {
            if(copy.val == copy.next.val) {
                copy.next = copy.next.next;
            }
            else {
                copy = copy.next;
            }
        }
        return head;
    }
}
