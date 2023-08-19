package programsProblem.practice.linkedList;

public class LinkedListCycle {
    public boolean cycleExist(ListNode head) {
        ListNode turtle = head;
        ListNode rabit = head;

        while(rabit != null && rabit.next != null) {
            turtle = turtle.next;
            rabit = rabit.next.next;

            if(turtle == rabit)
                return true;
        }
        return false;
    }
}
