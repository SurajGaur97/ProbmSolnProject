package programsProblem.practice.web;

import programsProblem.practice.DriverClass;

import java.util.concurrent.CompletableFuture;

public class AsynchrounousJavaEg implements DriverClass {
    @Override
    public void driverMethod() {
        asynchronousEg();
    }

    void asynchronousEg() {
        // Create a CompletableFuture that will be executed asynchronously.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // This is the task that will be executed asynchronously.
            return "Hello, world!";
        });

        // Monitor the status of the task.
        future.thenAccept(result -> {
            // This method will be called when the task is complete.
            System.out.println(result);
        });

        // Continue processing other work while the task executes in the background.
        System.out.println("Doing other work...");
    }
}
