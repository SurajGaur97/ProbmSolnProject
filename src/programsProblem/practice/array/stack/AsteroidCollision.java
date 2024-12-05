package programsProblem.practice.array.stack;

import programsProblem.utils.DriverClass;

import java.util.Stack;

public class AsteroidCollision implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        int[] asteroids = new int[]{-2,-1,1,2};
//        int[] asteroids = new int[]{-2,-2,1,-2};
        int[] asteroids = new int[]{-2,1,-2,-2};
        printElement(asteroidCollision(asteroids));
    }

    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < a.length; i++) {
            if(a[i] > 0 || stk.isEmpty())
                stk.add(a[i]);
            else {
                while(!stk.isEmpty()) {
                    int top = stk.peek();
                    if(top < 0) {
                        stk.push(a[i]);
                        break;
                    }
                    int mod = Math.abs(a[i]);
                    if(top > mod){
                        break;
                    } else if(top == mod) {
                        stk.pop();
                        break;
                    } else {
                        stk.pop();
                        if(stk.isEmpty()) {
                            stk.push(a[i]);
                            break;
                        }
                    }
                }
            }
        }

        int i = 0;
        int[] res = new int[stk.size()];
        for(int num: stk)
            res[i++] = num;

        return res;
    }
}
