package programsProblem.practice.graph.undirected.dfs;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInGraph implements DriverClass<Boolean> {
    @Override
    public void driverMethod(){
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1));
        adj.add(List.of(0, 2, 4));
        adj.add(List.of(1, 3));
        adj.add(List.of(2, 4));
        adj.add(List.of(1, 3));

        printElement(isCycle(V, adj));
    }

    public boolean isCycle(int V, List<List<Integer>> adj){
        boolean[] isVisited = new boolean[V];

        for(int u = 0;u < V;u++){
            if(!isVisited[u] && dfsCycle(adj, u, isVisited, -1)){
                return true;
            }
        }

        return false;
    }

    private boolean dfsCycle(List<List<Integer>> adj, int u, boolean[] isVisited, int parent){
        isVisited[u] = true;

        for(int i : adj.get(u)){
            if(i == parent)
                continue;

            if(isVisited[i])
                return true;

            if(dfsCycle(adj, i, isVisited, u))
                return true;
        }

        return false;
    }
}
