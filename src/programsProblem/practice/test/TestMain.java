package programsProblem.practice.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        String size = s.nextLine();

        String temp = s.nextLine();
        String[] A = temp.split(" ");

        int[] intList = new int[A.length];
        for (int k = 0; k < A.length; k++) {
            int pos = Integer.parseInt(A[k]) - k;
            intList[k] = pos > 0 ? pos : -pos;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < A.length; k++) {
            if(!map.containsKey(intList[k]))
                map.put(intList[k], 1);
            else
                map.put(intList[k], map.get(intList[k]) + 1);
        }

        int count = 0;
        if(!map.isEmpty() && map.get(0) != null) {
            count = map.get(0);
        }

        int res = 1;
        for (int i = 1; i <= count; i++) {
            res = res * i;
        }

        if(res == 1) {
            res = 0;
        }

//        int i = 0, j = 1, count = 0;
//        while(i < A.length && j < A.length) {
//            //int num = Integer.parseInt(A[k]);
//            if(i != j && j < A.length) {
//                int val = (Integer.parseInt(A[i]) - Integer.parseInt(A[j])) / (i - j);
//                int y = val < 0 ? -val : val;
//                if(y == 1) {
//                    count = count + 2;
//                }
//            }
//            if(j == A.length - 1) {
//                i++;
//                j = i + 1;
//            } else {
//                j++;
//            }
//        }

        System.out.println(res);
        // for(int i: reqArr) {
        //     System.out.println(i);
        // }
    }
}
