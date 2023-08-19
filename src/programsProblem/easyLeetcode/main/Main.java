package programsProblem.easyLeetcode.main;

import programsProblem.easyLeetcode.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    static RomanToInteger romanToInteger = new RomanToInteger();
//    static MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
//    static RemoveElement removeElement = new RemoveElement();
//    static SquareRoot squareRoot = new SquareRoot();
//    static SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
//    static LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
//    static AddBinary addBinary = new AddBinary();
//    static RemoveDuplicates removeDuplicates = new RemoveDuplicates();
//    static PascalsTriangle pascalsTriangle = new PascalsTriangle();
//    static BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
//    static IsSameTree isSameTree = new IsSameTree();
    static  IntersactionOfTwoLinkedList intersactionOfTwoLinkedList = new IntersactionOfTwoLinkedList();

    public static void main(String[] args) {

        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(8);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(1);
        list2.next.next.next = new ListNode(8);
        list2.next.next.next.next = new ListNode(4);
        list2.next.next.next.next.next = new ListNode(5);
        System.out.println(intersactionOfTwoLinkedList.getIntersectionNode1(list1, list2).val);

        /*TreeNode p = new TreeNode(3);
        p.left = new TreeNode(1);
        p.right = new TreeNode(2);

        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(2);
        q.right = new TreeNode(2);

        System.out.println(isSameTree.isSameTree(p, q));*/

        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> arrList = new ArrayList<>();
        System.out.println(binaryTreePreorderTraversal.preorderTraversal1(root, arrList));
        System.out.println(binaryTreePreorderTraversal.preorderTraversal(root));*/

//        System.out.println(pascalsTriangle.generate(5));

        /*ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(3);
        removeDuplicates.deleteDuplicates(list1);*/

//        System.out.println(addBinary.addBinary("101111", "10"));

//        System.out.println(lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));

//        System.out.println(searchInsertPosition.searchPosition(new int[] {1,2,4,5}, 3));

//        System.out.println(squareRoot.mySqrt(2147483647));

        /*int[] nums = new int[] {3,2,2,3};
        System.out.println(removeElement.removeElement1(nums, 2));
        for(int num: nums) {
            System.out.print(num + " ");
        }*/

        /*ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(2);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);
        list2.next.next.next.next = new ListNode(5);

        ListNode dlist1 = list1;
        System.out.print("First node: ");
        while(dlist1 != null) {
            System.out.print(dlist1.val + " -> ");
            dlist1 = dlist1.next;
        }
        System.out.print("null");

        ListNode dlist2 = list2;
        System.out.print("      Second node: ");
        while(dlist2 != null) {
            System.out.print(dlist2.val + " -> ");
            dlist2 = dlist2.next;
        }
        System.out.println("null");

        ListNode node = mergeTwoSortedLists.mergeTwoLists(list1, list2);
        System.out.print("Result List: ");
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("null");*/

//        System.out.println(romanToInteger.romanToInt("DCCLXXXIX"));
    }
}
