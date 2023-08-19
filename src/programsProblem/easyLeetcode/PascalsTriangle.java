package programsProblem.easyLeetcode;

import java.util.ArrayList;
import java.util.List;

//17-jun-2023
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>(1));

        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int currLstInd = 0;
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(j, 1);
                }
                else {
                    if(currLstInd < resList.get(i).size()) {
                        list.add(resList.get(i).get(currLstInd) + resList.get(i).get(currLstInd + 1));
                        currLstInd++;
                    }
                }
            }
            resList.add(list);
        }

        resList.remove(0);
        return  resList;
    }
}
