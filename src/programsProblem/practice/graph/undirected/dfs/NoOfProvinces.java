package programsProblem.practice.graph.undirected.dfs;

import programsProblem.utils.DriverClass;

public class NoOfProvinces implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        int[][] array = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        printElement(findCircleNum(array));
    }

    public int findCircleNum(int[][] isConnected){
        boolean[] isVisited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0;i < isConnected.length;i++){
            for(int j = 0;j < isConnected[i].length;j++){
                if(i != j){
                    if(!isVisited[i] && (isConnected[i][j] == 1 || isConnected[j][i] == 1)){
                        isVisited[i] = true;
                        count++;
                    }
                }
            }
        }
        if(count == 0)
            return isConnected.length;

        return count;
    }
}
