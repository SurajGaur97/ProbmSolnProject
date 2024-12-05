package programsProblem.practice.graph.undirected.bfs;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInGraphBfs implements DriverClass<Boolean> {
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

    private boolean isCycle(int V, List<List<Integer>> adj){
        boolean[] isVisited = new boolean[V];

        for(int u = 0;u < V;u++){
            if(!isVisited[u] && bfsCycle(adj, u, isVisited)){
                return true;
            }
        }

        return false;
    }

    private boolean bfsCycle(List<List<Integer>> adj, int u, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);

        while (!queue.isEmpty()){
            int parent = queue.poll();

            List<Integer> lst = adj.get(parent);
            isVisited[parent] = true;

            for(int i : lst){
                if(i == parent)
                    continue;

                if(isVisited[i])
                    return true;

                queue.add(i);
            }
        }
        return false;
    }
}
