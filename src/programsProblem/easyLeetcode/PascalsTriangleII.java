package programsProblem.easyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>(1));

        for(int i = 0; i < rowIndex + 1; i++) {
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
        return resList.get(rowIndex);
    }
}
