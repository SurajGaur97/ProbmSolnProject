package programsProblem.practice.graph.undirected.dfs;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms implements DriverClass<Boolean> {
    @Override
    public void driverMethod(){
        List<List<Integer>> rooms = new ArrayList<>();

//        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
//        rooms.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
//        rooms.add(new ArrayList<>(List.of(2)));
//        rooms.add(new ArrayList<>(List.of(0)));

        rooms.add(new ArrayList<>(List.of(1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(3)));
        rooms.add(new ArrayList<>());

//        printElement(bfs(rooms));
        printElement(dfs(rooms));
    }

    public boolean dfs(List<List<Integer>> rooms){
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        helperDfs(rooms, visited, 0);

        for(boolean visit : visited)
            if(!visit)
                return false;

        return true;
    }

    private void helperDfs(List<List<Integer>> rooms, boolean[] visited, int source){
        visited[source] = true;

        for(Integer integer : rooms.get(source))
            if(!visited[integer])
                helperDfs(rooms, visited, integer);
    }

    private boolean bfs(List<List<Integer>> rooms){
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> que = new LinkedList<>();

        visited[0] = true;  //presumed that 0th room always be open

        for(Integer n : rooms.get(0)){
            que.add(n);
            visited[n] = true;
        }

        while (!que.isEmpty()){
            List<Integer> curr = rooms.get(que.poll());
            for(Integer integer : curr){
                if(!visited[integer]){
                    que.add(integer);
                    visited[integer] = true;
                }
            }
        }

        for(boolean visit : visited)
            if(!visit)
                return false;

        return true;
    }
}
