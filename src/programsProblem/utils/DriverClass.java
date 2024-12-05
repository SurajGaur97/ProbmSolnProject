package programsProblem.utils;

import programsProblem.practice.linkedList.utils.ListNode;
import programsProblem.practice.tree.utils.TreeNode;

import java.util.*;

@FunctionalInterface
public interface DriverClass<T> {

    void driverMethod();

    default void printElement(int[] nums) {
        for (int ele : nums){
            System.out.print(ele + " ");
        }
    }

    default void printElement(int[][] nums) {
        for (int i = 0;i < nums[0].length;i++){
            for (int j = 0;j < nums[0].length;j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    default void printElement(T[] array) {
        for (T ele : array){
            System.out.print(ele + " ");
        }
    }

    default void printElement(List<T> List) {
        for (T ele : List){
            System.out.print(ele + " ");
        }
    }

    default void printElement(T element){
        if(element instanceof TreeNode)
            printTree((TreeNode) element);
        else if(element instanceof programsProblem.target75.linkedList.util.ListNode)
            printElement((programsProblem.target75.linkedList.util.ListNode) element);
        else
            System.out.println(element);
    }

    default void printTree(TreeNode root){
        if(root == null) return;
        List<String> lst = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()){
            TreeNode curr = que.poll();
            if(curr != null){
                lst.add(String.valueOf(curr.val));
                if(curr.left != null) que.add(curr.left);
                else que.add(null);
                if(curr.right != null) que.add(curr.right);
                else que.add(null);
            } else
                lst.add("null");
        }

        int ndx = 0;
        Collections.reverse(lst);
        for(String str : lst){
            if(str.equals("null"))
                ndx++;
            else break;
        }

        Collections.reverse(lst);
        for(int i = 0;i < lst.size() - ndx;i++){
            System.out.print(lst.get(i) + " ");
        }
    }

    default void printElement(Set<T> set){
        for(T ele : set){
            System.out.print(ele + " ");
        }
    }

    default void printElement(ListNode list){
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    default void printElement(Map<T, T> map){
        for(Map.Entry<T, T> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    default void printElementLst(List<List<T>> list){
        for(List<T> lst : list)
            for(T t : lst)
                System.out.println(t);
    }


    private void printElement(programsProblem.target75.linkedList.util.ListNode head){
        programsProblem.target75.linkedList.util.ListNode current = head;

        while (current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
