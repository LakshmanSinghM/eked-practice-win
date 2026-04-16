// Practical Assignment – Stream API – ForkJoinPool: Recursive Factorial Calculation
// Consider the task of calculating a factorial using ForkJoinPool. 
// The factorial of a number n is denoted as n! and is calculated as the product of all positive integers from 1 to n.

// Implement the FactorialTask class that extends RecursiveTask.

// In the constructor of FactorialTask, pass the number n whose factorial needs to be calculated.

// In the compute() method, split the task into subtasks and use fork() for asynchronous execution.

// Use join() to retrieve the results of subtasks and combine them to produce the final result.

// In the main method, create an instance of FactorialTask with the number whose factorial should be calculated and execute it using a ForkJoinPool.

// Output the result of the factorial calculation.

// As a result, the following structure should be obtained:

package java_stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FactorialTask extends RecursiveTask<Integer> {
    int start, end;
    int threadHold;

    public FactorialTask(int n) {
        start = 1;
        end = n;
        // atleast two number should be processed by a thread
        threadHold = 2;
    }

    public FactorialTask(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    protected Integer compute() {
        if (end - start <= threadHold) {
            int fact = 1;
            for (int i = start; i <= end; i++) {
                fact = fact * i;
            }
            return fact;
        }

        int mid = (end + start) / 2;

        FactorialTask left = new FactorialTask(start, mid);
        FactorialTask right = new FactorialTask(mid + 1, end);
        
        // async operation
        left.fork();

        // compute not fork (aysnc) so our current thred is not idle
        Integer rightResult = right.compute();
        Integer leftResult = left.join();

        return rightResult * leftResult;
    }

}

public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int n = 10; // Calculate factorial for number 10

        //  for big number we can replace with the BigInteger class 

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(n);

        long result = forkJoinPool.invoke(factorialTask);

        System.out.println("Factorial " + n + "! = " + result);
    }
}