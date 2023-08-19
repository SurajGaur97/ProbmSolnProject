package programsProblem.company.netwestGroupRBS;

import java.util.HashMap;
import java.util.Map;

/*you are given two arrays of different lengths of positive integers. write an algorithm to count the numbers
of elements that are not common to each list*/
public class CountNonMatchedElement {
    public int  countOfElement(int[] listInput1, int[] listInput2)
    {
        int  answer = 0;
        // Write your code here
        Map<Integer,Integer> mapA = new HashMap<>();
        Map<Integer,Integer> mapB = new HashMap<>();

        for (int j : listInput1) {
            if (!mapA.containsKey(j)) {
                mapA.put(j, 1);
            } else {
                mapA.put(j, mapA.get(j) + 1);
            }
        }

        for (int j : listInput2) {
            if (!mapB.containsKey(j)) {
                mapB.put(j, 1);
            } else {
                mapB.put(j, mapB.get(j) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: mapA.entrySet()) {
            if(mapB.containsKey(entry.getKey())) {
                mapA.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: mapB.entrySet()) {
            if(mapA.containsKey(entry.getKey())) {
                mapB.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: mapA.entrySet()) {
            answer += entry.getValue();
        }

        for(Map.Entry<Integer,Integer> entry: mapB.entrySet()) {
            answer += entry.getValue();
        }

        return answer;
    }
}
