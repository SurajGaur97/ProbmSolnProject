package programsProblem.easyLeetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    public void driverMethod() {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();

        System.out.println("pop: " + param_2 + ", top: " + param_3 + ", is empty: " + param_4);
    }
}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int track = queue.size();
        int pop = 0;

        while (track > 0){
            if(track == 1){   //picking the first element after traversing which will be the stack's Top element
                pop = queue.poll();     //Polling the element
                break;      //from protecting no such element exception.
            }
            queue.offer(queue.poll());  //Enqueue(Dequeue) do Dequeue then Enqueue, mean it gets each element on top 1 by 1 and then we are able to do out preferred operation.
            track--;
        }

        return pop;
    }

    public int top() {
        int track = queue.size();
        int top = 0;

        while (track > 0){
            if(track == 1){   //picking the first element after traversing which will be the stack's Top element
                top = queue.peek();      //Peeking the element
            }
            queue.offer(queue.poll());  //Enqueue(Dequeue) do Dequeue then Enqueue, mean it gets each element on top 1 by 1 and then we are able to do out preferred operation.
            track--;
        }
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */