package programsProblem.practice.backTrack;

import programsProblem.utils.DriverClass;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaning implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        Robot robot = new Robot();
        int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        Set<String> visited = new HashSet<>();

        backTrack(robot, 0, 0, 0, visited, directions);
    }

    private void backTrack(Robot robApi, int x, int y, int direction, Set<String> visited, int[][] directions) {
        String coOrdinate = x + "_" + y;

        if(visited.contains(coOrdinate)) return;
        visited.add(coOrdinate);

        robApi.clean();

        for (int i = 0;i < 4;i++){
            int new_direction = (direction + i) % 4;    //for selecting new index for directions array

            int new_x = directions[new_direction][0];   //0 indexed value is x coordinate
            int new_y = directions[new_direction][1];   //1 indexed value is y coordinate

            if(robApi.move()){ //move method ensures that is robot movable forward?
                backTrack(robApi, new_x, new_y, new_direction, visited, directions);
                goBack(robApi); //if there is any obstacle occurs then return back and set the direction as it was.
            }
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();  //rotating 180 degree the robot
        robot.move();   //moving back
        robot.turnRight();
        robot.turnRight();  //rotating 180 degree again for resetting the direction as robot's direction was.
    }

    //Robot class API provider
    static class Robot {
        public boolean move() {
            return true;
        }

        public void clean() {
        }

        public void turnRight() {
        }

        public void turnLeft() {
        }
    }
}
